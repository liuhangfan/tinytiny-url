package com.example.urlmgrservice.service;


import com.example.urlmgrservice.entity.RedirectResult;
import com.example.urlmgrservice.domain.dto.RedirectCreator;
import com.example.urlmgrservice.entity.TinyDoc;
import com.example.urlmgrservice.exception.BadRequestException;
import com.example.urlmgrservice.exception.NotFoundException;
import com.example.urlmgrservice.repository.TinyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {
    private TinyRepo tinyRepo;

    @Autowired
    public RedirectService(TinyRepo tinyRepo) {
        this.tinyRepo = tinyRepo;
    }

    public Optional<TinyDoc> createTinyDoc(RedirectCreator redirectCreator){

        if(tinyRepo.existsTinyDocById(redirectCreator.getAlias())){
            throw new BadRequestException("Alias already exists");
        }

        TinyDoc tinyDoc = new TinyDoc(redirectCreator.getAlias(),redirectCreator.getUrl());
        TinyDoc saveTinyDoc = tinyRepo.save(tinyDoc);
        return Optional.of(saveTinyDoc);
    }

    public TinyDoc getTinyDoc(String alias) {
        TinyDoc tinyDoc =  tinyRepo.findTinyDocsById(alias).orElseThrow(
                () -> new NotFoundException("we don't have that alias ! Try making it")
        );
        return tinyDoc;
    }

}
