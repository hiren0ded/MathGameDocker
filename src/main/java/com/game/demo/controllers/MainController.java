package com.game.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
    static int visit = 0;

    @GetMapping("/")
    public ModelAndView swagger()
    {
        visit++;
        System.out.println("Visit Count::" + visit);
        return new ModelAndView("redirect:" + "swagger-ui.html");
    }

}
