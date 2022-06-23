package bg.softuni.myMobilele.web;

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
//@RequestMapping може да се използва и върху клас, като в случая казваме че всички
// мапинги ще са от users
public class UserRegistrationController {

    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public UserRegisterDTO initUserModel() {
        return new UserRegisterDTO();
    }
//    Инициализираме си @ModelAttribute за да можем да си го ползваме в всички методи
//    този атрибут връща нов празен обект от регистрационната форма на потребител

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
// Използва се @Valid за да се направят валидациите заложени в ДТО класа, веднага след него
// (задължително) се използва BindingResult в него се записват резултатите от валидирането

        if (bindingResult.hasErrors()) {

            redirectAttributes
                    .addFlashAttribute("userModel", userModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel"
                            , bindingResult);
            return "redirect:/users/register";
            //  RedirectAttributes заедно с горните редове използваме за да запазим грешните
            //  данни, и така попълнените полета във формата за регистрация не се трият
        }

        userService.registerAndLogin(userModel);

        return "redirect:/";
    }
}
