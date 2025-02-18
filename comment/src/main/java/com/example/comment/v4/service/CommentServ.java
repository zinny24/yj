package com.example.comment.v4.service;

import com.example.comment.v4.entity.Article;
import com.example.comment.v4.entity.CommentEntity;
import com.example.comment.v4.respository.ArticleReposi;
import com.example.comment.v4.respository.CommentRepsi;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommentServ {

    @Autowired
    private CommentRepsi commentRepsi;

    @Autowired
    private ArticleReposi articleReposi;

    @Transactional
    public CommentEntity saveCommentEntity(
            String writer, String content, Integer articleId) {

        CommentEntity ce = new CommentEntity();
        ce.setWriter( writer );
        ce.setContent( content );

        Article article = articleReposi.findById(articleId).orElse(null);
        ce.setArticle( article );

        return commentRepsi.save(ce);

    }

}
