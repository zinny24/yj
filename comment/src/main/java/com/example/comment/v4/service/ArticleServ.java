package com.example.comment.v4.service;

import com.example.comment.v4.entity.Article;
import com.example.comment.v4.respository.ArticleReposi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServ {

    @Autowired
    private ArticleReposi articleReposi;

    public List<Article> getFindAll() {
        return articleReposi.findAll( Sort.by("id").descending() );
    }

}
