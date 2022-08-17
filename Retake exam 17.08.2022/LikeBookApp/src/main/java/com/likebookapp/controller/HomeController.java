package com.likebookapp.controller;

import com.likebookapp.init.LoggedUser;
import com.likebookapp.service.AuthService;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final AuthService authService;
    private final PostService postService;
    private final LoggedUser loggedUser;
    private final UserService userService;

    @Autowired
    public HomeController(AuthService authService,
                          PostService postService,
                          LoggedUser loggedUser,
                          UserService userService) {
        this.authService = authService;
        this.postService = postService;
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @GetMapping("/home")
    private String getHome(Model model) {
        if (!this.authService.isLoggedIn()) {
            return "index";
        }

        if (!model.containsAttribute("username")) {
            model.addAttribute("username"
                    , this.loggedUser.getUsername());
        }

        if (!model.containsAttribute("userContents")) {
            model.addAttribute("userContents"
                    , this.userService.getUserContents());
        }

        if (!model.containsAttribute("otherPost")) {
            model.addAttribute("otherPost"
                    , this.postService.getOtherPost());
        }


        return "home";
    }

    @GetMapping("remove/{id}")
    public String removePost(@PathVariable("id") Long postId){
        if (!this.authService.isLoggedIn()) {
            return "index";
        }
        this.userService.removeContent(postId);
        return "redirect:/home";
    }

    @GetMapping("like/{id}")
    public String likePost(@PathVariable("id") Long postId){
        if (!this.authService.isLoggedIn()) {
            return "index";
        }

        this.postService.addLike(postId);
        return "redirect:/home";
    }



}

