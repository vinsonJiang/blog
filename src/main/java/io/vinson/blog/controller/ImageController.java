package io.vinson.blog.controller;

import io.vinson.common.exception.FileNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {

    @RequestMapping("image")
    public void image() {
        throw new FileNotFoundException("file not found");
    }
}
