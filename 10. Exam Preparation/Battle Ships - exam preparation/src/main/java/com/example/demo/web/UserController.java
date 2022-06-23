package com.example.demo.web;

import com.example.demo.models.dto.UserLoginDto;
import com.example.demo.models.dto.UserRegisterDto;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerDto")
    public UserRegisterDto initRegisterDto() {
        return new UserRegisterDto();
    }
    @ModelAttribute("loginDto")
    public UserLoginDto initLoginDto() {
        return new UserLoginDto();
    }

    @GetMapping("/register")
    public String register() {

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDto registerDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("registerDto", registerDto);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel"
                            , bindingResult);
            return "redirect:/register";
        }
        userService.registerAndLogin(registerDto);

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDto loginDto
                        , BindingResult bindingResult
                        , RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.userService.login(loginDto)){
            redirectAttributes
                    .addFlashAttribute("loginDto",loginDto);

            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel"
                    ,bindingResult);

            return "redirect:/login";
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/Home";
    }

}
