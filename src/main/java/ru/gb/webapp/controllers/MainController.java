package ru.gb.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //GET http://localhost:8189/app
    @GetMapping
    public String showStartPage() {

        return "index";
    }
}