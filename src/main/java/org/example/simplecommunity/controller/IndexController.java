package org.example.simplecommunity.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.simplecommunity.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {


    @GetMapping
    public String index(Model model,
                        @RequestParam("nickname") String nickname,
                        @RequestParam("password") String password,
                        @RequestParam("title") String title,
                        @RequestParam("contents") String contents) {
        PostService postService = new PostService();
        postService.post(nickname, password, title, contents);
        return "index";
    }
}
