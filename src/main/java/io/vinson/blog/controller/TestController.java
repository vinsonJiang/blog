package io.vinson.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "/test/article", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/test/blog", method = RequestMethod.GET)
    public String blog(Model model) {
        return "blog";
    }
    @RequestMapping(value = "/test/message", method = RequestMethod.GET)
    public String message(Model model) {
        return "message";
    }
}
