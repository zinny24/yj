package com.example.comment.v4.respository;

import com.example.comment.v4.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepsi extends JpaRepository<CommentEntity, Integer> {
}
