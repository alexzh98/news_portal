package com.dataart.newsportal.services;

import com.dataart.newsportal.entities.Author;

import java.util.List;

public interface AuthorService {

    public Author getAuthor(int id);

    public List<Author> getAllAuthors();

    public void saveAuthor(Author author);

    public void deleteAuthor(int id);
}
