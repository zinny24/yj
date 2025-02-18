package com.example.comment.v4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String writer;

    @Column
    private String content;

    //외래키 설정, 조인 설정
    @ManyToOne(optional = false)
    @JoinColumn(name="article_id", nullable = false)
    private Article article;

}









