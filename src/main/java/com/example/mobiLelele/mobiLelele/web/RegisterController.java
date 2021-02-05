package com.example.mobiLelele.mobiLelele.web;

import com.example.mobiLelele.mobiLelele.model.service.UserRegisterServiceModel;
import com.example.mobiLelele.mobiLelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegister")
    public UserRegisterServiceModel userRegister() {
        return new UserRegisterServiceModel();
    }

    @GetMapping("/users/register")
    public String showRegister() {
        return "/auth-register";
    }


    @PostMapping("/users/register")
    public String register(@Valid @ModelAttribute UserRegisterServiceModel userRegister,
                        BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegister", userRegister);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegister", bindingResult);

            return "redirect:/users/register";
        }

        this.userService.createUser(userRegister);

        return "redirect:/users/login";


    }
}
