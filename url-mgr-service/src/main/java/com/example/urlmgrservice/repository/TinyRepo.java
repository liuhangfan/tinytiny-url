package com.example.urlmgrservice.repository;

import com.example.urlmgrservice.entity.TinyDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinyRepo extends MongoRepository<TinyDoc, String> {
    //@Query()
    TinyDoc findTinyDocsById(String id);
}
