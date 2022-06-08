package bg.softuni.myMobilele.web;

import bg.softuni.myMobilele.models.dto.UserLoginDTO;
import bg.softuni.myMobilele.models.dto.UserRegisterDTO;
import bg.softuni.myMobilele.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {
        userService.login(userLoginDTO);
        return "redirect:/";
    }

    @PostMapping("/users/register")
    public String register(UserRegisterDTO userRegisterDTO) {
        return "redirect:/";
    }

    //TODO: Explain POST-redirect-GET
}