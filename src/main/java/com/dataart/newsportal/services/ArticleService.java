package com.dataart.newsportal.services;

import com.dataart.newsportal.entities.Article;

import java.util.List;

public interface ArticleService {

    public Article getArticle(int id);

    public List<Article> getAllArticles();

    public void saveArticle(Article article);

    public void deleteArticle(int id);
}
