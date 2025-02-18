package com.example.comment.v4.respository;

import com.example.comment.v4.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleReposi extends JpaRepository<Article, Integer> {


}
