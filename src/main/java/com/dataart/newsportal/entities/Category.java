package com.dataart.newsportal.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CATEGORIES",schema = "NEWS_SCHEMA")
@Getter @Setter
@NoArgsConstructor
public class Category {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    //categories -> название листа в Article
//    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinTable(
//            name = "ARTICLES_CATEGORIES",
//            schema = "NEWS_SCHEMA",
//            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
//            inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID"))
//    private List<Article> articlesInCategory;

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            mappedBy = "categoryOfArticle")
    private List<Article> articlesInCategory;

    public void addArticleInCategoriesList(Article article){

        if (articlesInCategory == null){
            articlesInCategory = new ArrayList<>();
        }
        articlesInCategory.add(article);
        article.setCategoryOfArticle(this);
    }

    public Category(String name) {
        this.name = name;
    }
}
