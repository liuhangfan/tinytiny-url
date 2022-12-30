package com.example.urlmgrservice.service;

import com.example.urlmgrservice.domain.dto.RedirectCreator;
import com.example.urlmgrservice.domain.vo.CreatorResult;
import com.example.urlmgrservice.entity.TinyDoc;
import com.example.urlmgrservice.exception.*;
import com.example.urlmgrservice.repository.TinyRepo;
import com.example.urlmgrservice.utils.UUID.UUIDGenerator;
import com.example.urlmgrservice.utils.UrlFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;


@Service
public class RedirectService {
    private final TinyRepo tinyRepo;

    private final UUIDGenerator uuidGenerator;

    @Autowired
    public RedirectService(TinyRepo tinyRepo, UUIDGenerator uuidGenerator) {
        this.tinyRepo = tinyRepo;
        this.uuidGenerator = uuidGenerator;
    }

    public TinyDoc getTinyDoc(String alias) {
        TinyDoc tinyDoc = tinyRepo.findTinyDocsById(alias);
        if (tinyDoc == null) {
            throw new TinyUrlNotFoundException("not found alias: %s".formatted(alias));
        }
        return tinyDoc;
    }

    public CreatorResult createTinyUrl(RedirectCreator redirectCreator) {
        try {
            if(redirectCreator.getDomain() == null) {
                throw new IllegalDomainException("empty domain");
            }
            String url = UrlFormatter.format(redirectCreator.getUrl());
            TinyDoc tinyDoc = new TinyDoc(url);
            attachIdByAlias(tinyDoc, redirectCreator.getAlias());
            TinyDoc saveTinyDoc = tinyRepo.insert(tinyDoc);
            return new CreatorResult(redirectCreator.getDomain()+"/"+saveTinyDoc.getId(), saveTinyDoc.getId(),
                    redirectCreator.getDomain());
        } catch (DuplicateKeyException e) {
            throw new AliasDuplicateException("alias already exists".formatted(redirectCreator.getAlias()));
        } catch (Exception e) {
            throw new InternalException("create alias %s failed, %s".formatted(redirectCreator.getAlias(),e));
        }
    }

    private void attachIdByAlias(TinyDoc tinyDoc, String alias) {
        if (alias != null && alias.length() > 0) {
            if (alias.length() > 16) {
                throw new IllegalAliasException("alias=%s is too long, try a shorter one".formatted(alias));
            }
            tinyDoc.setId(alias);
        } else {
            tinyDoc.setId(uuidGenerator.nextIdBase64String());
        }
    }
}
