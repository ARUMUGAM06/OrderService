package com.ecommerce.orderapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final BuildProperties buildProperties;

    @GetMapping("/")
    public String home() {
        return "<html><head><title>Home</title></head>" +
                "<body><div style='display: flex; justify-content: center;" +
                " height: 100vh; margin-top: 2%; font-size: 32px; color: green;'>" +
                "<strong>"+buildProperties.getName()+" Service Started on "+buildProperties.getTime().toString().split("T")[0]+"</strong></div></body></html>";
    }
}
