package bg.softuni.myMobilele.web;

import bg.softuni.myMobilele.models.dto.UserLoginDTO;
import bg.softuni.myMobilele.models.dto.UserRegisterDTO;
import bg.softuni.myMobilele.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Тук този модел ще ни трябва за всички методи,
//инициализираме го в отделен метод с тази анотация
// и той се добавя към всички методи
    @ModelAttribute("userModel")
    public UserLoginDTO initUserModel() {
        return new UserLoginDTO();
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
    public String login(@Valid UserLoginDTO userLoginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
//проверяваме има ли грешки от валидацията на въведените данни
// или че потребителя не е логнат, в този сучай използваме
// redirectAttributes.addFlashAttribute за да запазим въведените данни
// във формата след като се редиректне формата
        if (bindingResult.hasErrors() || !this.userService.login(userLoginDTO)) {
            redirectAttributes.addFlashAttribute("userModel", userLoginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            bindingResult.rejectValue("password", "InvalidPasswordError",
                    "Invalid password.");
            return "redirect:/users/login";
        }

        return "redirect:/";
    }


}