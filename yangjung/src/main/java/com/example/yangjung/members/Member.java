package com.example.yangjung.members;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String userid;

    @Column(nullable = false, length = 20)
    private String passwd;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate = LocalDate.now();


}
