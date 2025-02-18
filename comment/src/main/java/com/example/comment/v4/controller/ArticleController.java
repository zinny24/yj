package com.example.comment.v4.controller;

import com.example.comment.v4.entity.Article;
import com.example.comment.v4.respository.ArticleReposi;
import com.example.comment.v4.service.ArticleServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleReposi articleReposi;

    @Autowired
    private ArticleServ articleServ;

    @GetMapping("/write")
    public String viewWrite() {
        return "article/write";
    }

    @PostMapping("/write")
    public String saveWriter(@ModelAttribute Article article) {
        articleReposi.save(article);
        return "redirect:/article/list";
    }

    @GetMapping("/list")
    public String viewList(Model model) {
        List<Article> articles = articleServ.getFindAll();

        model.addAttribute("articles", articles);
        return "article/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Integer id) {
        articleReposi.deleteById(id);
        return "redirect:/article/list";
    }

    @GetMapping("/view/{id}")
    public String viewView(@PathVariable Integer id, Model model) {
        Article article = articleReposi.findById(id).orElse(null);

        model.addAttribute("article", article);
        return "article/view";
    }

}






