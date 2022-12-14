package com.example.urlmgrservice.service;

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

    public TinyDoc createTinyDoc(RedirectCreator redirectCreator){
        TinyDoc tinyDoc = new TinyDoc(redirectCreator.getAlias(),redirectCreator.getUrl());
        TinyDoc saveTinyDoc = tinyRepo.insert(tinyDoc);
        return saveTinyDoc;
    }

    public TinyDoc getTinyDoc(String alias) {
        TinyDoc tinyDoc =  tinyRepo.findTinyDocsById(alias).orElseThrow(
                () -> new NotFoundException("we don't have that alias ! Try making it")
        );
        return tinyDoc;
    }

}
