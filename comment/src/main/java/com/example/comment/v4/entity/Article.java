package com.example.comment.v4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    public String subject;

    @Column(nullable = false, length = 20)
    public String writer;

    @Column(nullable = false, columnDefinition = "TEXT")
    public String content;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyy-MM-dd")
    public LocalDate createDate = LocalDate.now();

    /* 댓글 추가 작업 */

}








