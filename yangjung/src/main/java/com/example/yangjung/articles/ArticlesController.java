package com.example.yangjung.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
public class ArticlesController {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/write")
    public String viewWrite() {
        return "articles/write";
    }

    @GetMapping
    public String viewList(Model model,
                           @RequestParam(defaultValue = "subject") String searchType,
                           @RequestParam(defaultValue = "") String searchWords) {

        List<Article> articleList = null;

        if(  searchWords.isEmpty()   ) {
            articleList
                    = articlesRepository.findAll( Sort.by("id").descending() );

        }else{
        }

        model.addAttribute("searchType", searchType);
        model.addAttribute("searchWords", searchWords);

        model.addAttribute(  "isSubject", "subject".equals(searchType)  );
        model.addAttribute(  "isWriter", "writer".equals(searchType)  );

        model.addAttribute("aList", articleList);

        return "articles/list";
    }

    @PostMapping("/write")
    public String doWrite(@ModelAttribute Article article) {
        articlesRepository.save(article);
        return "redirect:/articles";
    }


    @GetMapping("/delete/{id}")
    public String doDelete(@PathVariable Long id) {
        articlesRepository.deleteById(id);
        return "redirect:/articles";
    }

    @GetMapping("/view/{id}")
    public String viewView(@PathVariable Long id, Model model) {

        articlesService.incViewCount(id);

        Article article = articlesRepository.findById(id).orElse(null);
        model.addAttribute("article", article);
        return "articles/view";
    }

    @GetMapping("/edit/{id}")
    public String viewEdit(@PathVariable Long id, Model model) {
        Article article = articlesRepository.findById(id).orElse(null);
        model.addAttribute("article", article);

        return "articles/edit";
    }

    @PostMapping("/edit/{id}")
    public String doEdit(
            @ModelAttribute Article article,
            @PathVariable Long id) {
        articlesRepository.save(article);
        return "redirect:/articles";
    }

}
