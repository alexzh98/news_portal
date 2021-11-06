package com.dataart.newsportal.repositories;

import com.dataart.newsportal.entities.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {


    Page<Author> findByNameContainsIgnoreCaseOrderBySurnameAsc(String surname,Pageable pageable);


}
