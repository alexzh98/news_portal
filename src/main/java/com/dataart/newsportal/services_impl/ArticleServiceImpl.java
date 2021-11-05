package com.dataart.newsportal.services_impl;

import com.dataart.newsportal.entities.Article;
import com.dataart.newsportal.repositories.ArticleRepository;
import com.dataart.newsportal.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article getArticle(int id) {

        Article article = null;
        Optional<Article> optional = articleRepository.findById(id);

        if (optional.isPresent()){
            article = optional.get();
        }

        return article;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
        article.getAuthorOfArticle().addArticleToAuthor(article);
    }

    @Override
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }
}
