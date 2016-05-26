package com.jiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by dev-pc on 5/26/16.
 */
@Controller
public class BaseController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        System.out.println("index");
        model.put("message", "ASOFJAOSFJAS");
        return "index";
    }

}
