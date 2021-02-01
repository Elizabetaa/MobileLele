package com.example.mobiLelele.mobiLelele.web;

import com.example.mobiLelele.mobiLelele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    private final UserService userService;

    public LogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/logout")
    public String showLogin() {
        userService.logoutUser();
        return "redirect:/";
    }

}
