package com.dataart.newsportal.services_impl;

import com.dataart.newsportal.entities.Article;
import com.dataart.newsportal.entities.Author;
import com.dataart.newsportal.repositories.AuthorRepository;
import com.dataart.newsportal.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;



    @Override
    public Author getAuthor(int id) {
        Author author = null;
        Optional<Author> optional = authorRepository.findById(id);

        if (optional.isPresent()){
            author = optional.get();
        }

        return author;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }
}
