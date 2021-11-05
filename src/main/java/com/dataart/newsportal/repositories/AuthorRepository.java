package com.dataart.newsportal.repositories;

import com.dataart.newsportal.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
