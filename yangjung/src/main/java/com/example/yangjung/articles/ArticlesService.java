package com.example.yangjung.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    public void incViewCount(Long id) {
        Article article = articlesRepository.findById(id).orElse(null);
        article.setViewCount( article.getViewCount() + 1 );
        articlesRepository.save(article);
    }

    //게시물 전체보기 페이지 처리하기
    public Page<Article> getArticles(Pageable pageable) {
        Pageable sortedByDesc
                = PageRequest.of(pageable.getPageNumber(),
                pageable.getPageSize(), Sort.by("id").descending());

        return articlesRepository.findAll(sortedByDesc);
    }

    //검색된 게시물 페이지 처리하기
    public Page<Article> searchArticles
    (String searchType, String searchWords, Pageable pageable) {

        Pageable sortedByDesc
                = PageRequest.of(pageable.getPageNumber(),
                pageable.getPageSize(), Sort.by("id").descending());

        if( "writer".equals(searchType) ) {
            return articlesRepository.findByWriterContaining(searchWords, sortedByDesc);
        }
        return articlesRepository.findBySubjectContaining(searchWords, sortedByDesc);
    }


}







