package com.dataart.newsportal.controllers;


import com.dataart.newsportal.entities.Article;
import com.dataart.newsportal.entities.Author;
import com.dataart.newsportal.entities.Category;
import com.dataart.newsportal.services_impl.ArticleServiceImpl;
import com.dataart.newsportal.services_impl.AuthorServiceImpl;
import com.dataart.newsportal.services_impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsPortalController {

    @Autowired
    private ArticleServiceImpl articleService;

    @Autowired
    private AuthorServiceImpl authorService;

    @Autowired
    private CategoryServiceImpl categoryService;



    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable int id) {
        return articleService.getArticle(id);
    }

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PostMapping("/articles")
    public Article addNewArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
        return article;
    }

    @PutMapping("/articles")
    public Article updateArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
        return article;
    }




    @GetMapping("/authors/{id}")
    public Author getAuthor(@PathVariable int id) {
        return authorService.getAuthor(id);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/authors")
    public Author addNewAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return author;
    }

    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
        return author;



    }@GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public Category addNewCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return category;
    }

    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return category;
    }

}
