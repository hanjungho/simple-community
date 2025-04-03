package org.example.simplecommunity.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.simplecommunity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    private final PostService postService;

    @Autowired
    public IndexController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("/post")
    public String createPost(@RequestParam("nickname") String nickname,
                             @RequestParam("password") String password,
                             @RequestParam("title") String title,
                             @RequestParam("contents") String contents) {
        postService.post(nickname, password, title, contents);
        return "redirect:/";
    }
}