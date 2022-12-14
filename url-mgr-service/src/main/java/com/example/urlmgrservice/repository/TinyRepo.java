package com.example.urlmgrservice.repository;

import com.example.urlmgrservice.entity.TinyDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TinyRepo extends MongoRepository<TinyDoc,String> {
    //@Query()
    public Optional<TinyDoc> findTinyDocsById(String id);
}
