package ru.tkachenko.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dmitry Tkachenko
 *         11.09.17
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "greeting";
    }
}
