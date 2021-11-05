package com.dataart.newsportal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AUTHORS", schema = "NEWS_SCHEMA")
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "DATE_OF_BIRTH")
    private Date dob;

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            mappedBy = "authorOfArticle")
    private List<Article> articlesOfAuthor;

    public void addArticleToAuthor(Article article) {

        if (articlesOfAuthor == null) {
            articlesOfAuthor = new ArrayList<>();
        }
        articlesOfAuthor.add(article);

        article.setAuthorOfArticle(this);
    }


    public Author(String name, String surname, Date dob) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
    }
}
