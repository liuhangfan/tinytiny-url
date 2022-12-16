package com.example.urlmgrservice.service;

import com.example.urlmgrservice.domain.dto.RedirectCreator;
import com.example.urlmgrservice.domain.vo.CreatorResult;
import com.example.urlmgrservice.entity.TinyDoc;
import com.example.urlmgrservice.repository.TinyRepo;
import com.example.urlmgrservice.utils.UrlFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedirectService {
    private final TinyRepo tinyRepo;

    @Autowired
    public RedirectService(TinyRepo tinyRepo) {
        this.tinyRepo = tinyRepo;
    }

    public TinyDoc getTinyDoc(String alias) {
        TinyDoc tinyDoc = tinyRepo.findTinyDocsById(alias);
        return tinyDoc;
    }

    public CreatorResult createTinyUrl(RedirectCreator redirectCreator) {
        try {
            String url = UrlFormatter.format(redirectCreator.getUrl());
            TinyDoc tinyDoc = new TinyDoc(redirectCreator.getAlias(), url);
            TinyDoc saveTinyDoc = tinyRepo.insert(tinyDoc);
            return new CreatorResult(saveTinyDoc.getId(), "");
        } catch (Exception e) {
            return new CreatorResult("", e.toString());
        }
    }


}
