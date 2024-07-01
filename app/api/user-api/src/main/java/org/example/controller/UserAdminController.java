package org.example.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class UserAdminController {

    @GetMapping
    public String home() {
        return "home";
    }

}
