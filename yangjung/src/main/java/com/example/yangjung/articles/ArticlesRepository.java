package com.example.yangjung.articles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, Long> {

    Page<Article> findBySubjectContaining(String searchWords, Pageable pageable);

    Page<Article> findByWriterContaining(String searchWords, Pageable pageable);

}
