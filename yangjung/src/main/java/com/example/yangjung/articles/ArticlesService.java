package com.example.yangjung.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    public void incViewCount(Long id) {
        Article article = articlesRepository.findById(id).orElse(null);
        article.setViewCount( article.getViewCount() + 1 );
        articlesRepository.save(article);
    }

}
