package com.bd2.api.web;

import com.bd2.api.dto.HelloDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping(path = "/hello")
    public HelloDTO hello() {
        return new HelloDTO("Hello World!");
    }
}
