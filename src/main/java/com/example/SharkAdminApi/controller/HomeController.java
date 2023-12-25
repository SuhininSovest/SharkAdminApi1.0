package com.example.SharkAdminApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/")
    public String homePageAccount() {
        return "<html><body>"
                + "<h1>WELCOME to Account</h1>"
                + "</body></html>";
    }
}
