package com.example.urlmgrservice.service;


import com.example.urlmgrservice.entity.RedirectResult;
import com.example.urlmgrservice.domain.dto.RedirectCreator;
import com.example.urlmgrservice.exception.BadRequestException;
import com.example.urlmgrservice.exception.NotFoundException;
import com.example.urlmgrservice.repository.RedirectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {
    private RedirectRepo redirectRepo;

    @Autowired
    public RedirectService(RedirectRepo redirectRepo){
        this.redirectRepo = redirectRepo;
    }
    public Optional<RedirectResult> createRedirect(RedirectCreator redirectCreator) {
        if(redirectRepo.existsByAlias(redirectCreator.getAlias())){
            throw new BadRequestException("Alias already exists");
        }
        RedirectResult redirectResult = new RedirectResult(redirectCreator.getAlias(), redirectCreator.getUrl());

        RedirectResult postSaveRedirect = redirectRepo.save(redirectResult);
        return Optional.ofNullable(postSaveRedirect);
    }

    public RedirectResult getRedirect(String alias) {
        RedirectResult redirectResult =  redirectRepo.findByAlias(alias).orElseThrow(
                () -> new NotFoundException("we don't have that alias ! Try making it")
        );
        return redirectResult;
    }
}
