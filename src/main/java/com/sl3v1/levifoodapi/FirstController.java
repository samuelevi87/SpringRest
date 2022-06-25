package com.sl3v1.levifoodapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Olá sem Dev tools";
    }

}
