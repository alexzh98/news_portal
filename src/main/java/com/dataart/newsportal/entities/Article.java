package com.dataart.newsportal.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "ARTICLES", schema = "NEWS_SCHEMA")
@Getter
@Setter
@NoArgsConstructor
public class Article {


    @Column(name = "AUTHOR_ID")
    private int authorIdent;
    @Column(name = "CATEGORY_ID")
    private int categoryIdent;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private byte[] content;

//    @Column(name = "CATEGORY_ID")
//    private int categoryId;
//
//    @Column(name = "AUTHOR_ID")
//    private int authorId;


//    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinTable(
//            name = "ARTICLES_CATEGORIES",
//            schema = "NEWS_SCHEMA",
//            joinColumns = @JoinColumn(name = "ARTICLE_ID"),
//            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
//
//    private List<Category> categoriesOfArticle;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category categoryOfArticle;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "AUTHOR_ID")
    private Author authorOfArticle;


    //TODO Закоментированный конструктор с Объектами вместо id
    public Article(String title, Category categoryOfArticle, Author authorOfArticle) {
        this.title = title;
        this.categoryOfArticle = categoryOfArticle;
        this.authorOfArticle = authorOfArticle;
    }


//    public Article(String title, int categoryOfArticleId, int authorId) {
//        this.title = title;
//        this.categoryIdent = categoryOfArticleId;
//        this.authorIdent = authorId;
//    }
}
