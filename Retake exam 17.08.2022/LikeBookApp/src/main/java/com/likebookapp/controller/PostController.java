package com.likebookapp.controller;

import com.likebookapp.model.dtos.PostAddDTO;
import com.likebookapp.service.AuthService;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PostController {

    private final AuthService authService;
    private PostService postService;

    public PostController(AuthService authService, PostService postService) {
        this.authService = authService;
        this.postService = postService;
    }

    @ModelAttribute("postAddDTO")
    public PostAddDTO initPostAddDTO() {
        return new PostAddDTO();
    }

    @GetMapping("/post/add")
    public String addPost() {
        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        return "/post-add";
    }

    @PostMapping("/post/add")
    public String ships(@Valid PostAddDTO postAddDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (!this.authService.isLoggedIn()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors() || !this.postService.create(postAddDTO)) {
            redirectAttributes.addFlashAttribute("postAddDTO", postAddDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.postAddDTO", bindingResult);

            return "redirect:/post/add";
        }



        return "redirect:/home";
    }
}
