package com.dataart.newsportal.repositories;

import com.dataart.newsportal.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
}
