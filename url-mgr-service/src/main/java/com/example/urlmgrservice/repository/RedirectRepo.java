package com.example.urlmgrservice.repository;

import com.example.urlmgrservice.entity.RedirectResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RedirectRepo extends JpaRepository<RedirectResult, Long> {
    Optional<RedirectResult> findByAlias(String alias);

    Boolean existsByAlias(String alias);
}

