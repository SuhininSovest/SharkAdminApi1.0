package com.example.SharkAdminApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping("/potom")
    public String homePageAccount() {
        return "<html><body>"
                + "<h1>WELCOME to Account</h1>"
                + "</body></html>";
    }
}
