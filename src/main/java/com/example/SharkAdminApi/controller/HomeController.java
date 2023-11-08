package com.example.SharkAdminApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String homePageAccount() {
        return "<html><body>"
                + "<h1>WELCOME to Account</h1>"
                + "</body></html>";
    }
}
