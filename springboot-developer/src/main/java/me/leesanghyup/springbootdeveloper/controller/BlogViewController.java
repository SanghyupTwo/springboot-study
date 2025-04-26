package me.leesanghyup.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.leesanghyup.springbootdeveloper.domain.Article;
import me.leesanghyup.springbootdeveloper.dto.ArticleListViewResponse;
import me.leesanghyup.springbootdeveloper.dto.ArticleViewResponse;
import me.leesanghyup.springbootdeveloper.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {

    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();
        model.addAttribute("articles", articles); // 블로그 글 리스트 저장

        return "articleList"; // articleList.html라는 뷰 조회
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable("id") Long id, Model model) {
        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(name = "id", required = false) Long id, Model model) {
        if (id == null) { // id가 없으면 생성
            model.addAttribute("article", new ArticleViewResponse()); // 빈 객체 전달
        } else { // id가 있으면 수정
            Article article = blogService.findById(id); // 해당 id의 글을 찾음
            model.addAttribute("article", new ArticleViewResponse(article)); // 수정할 글 전달
        }
        return "newArticle"; // newArticle.html을 반환
    }
}
