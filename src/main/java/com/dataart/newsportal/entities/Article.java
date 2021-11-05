package com.dataart.newsportal.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ARTICLES",schema = "NEWS_SCHEMA")
@Getter @Setter
@NoArgsConstructor
public class Article {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private byte[] content;

    @Column(name = "CATEGORY_ID")
    int categoryId;

    //TODO Проверить каскад и будет ли нормальное удаление без сброса всех значений
    
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "ARTICLES_CATEGORIES",
            schema = "NEWS_SCHEMA",
            joinColumns = @JoinColumn(name = "ARTICLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))

    private List<Category> categoriesInArticle;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "AUTHOR_ID" )
    private Author authorOfArticle;

    public Article( String title, int categoryId, Author author) {
        this.title = title;
        this.categoryId = categoryId;
        this.authorOfArticle = author;
    }
}
