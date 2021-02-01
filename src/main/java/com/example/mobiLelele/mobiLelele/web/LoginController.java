package com.example.mobiLelele.mobiLelele.web;

import com.example.mobiLelele.mobiLelele.security.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final CurrentUser currentUser;

    public LoginController(CurrentUser currentUser) {

        this.currentUser = currentUser;
    }

    @GetMapping("/users/login")
    public String login(){
        return "/auth-login";
    }

}
