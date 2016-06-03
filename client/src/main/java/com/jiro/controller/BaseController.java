package com.jiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dev-pc on 6/3/16.
 */
@Controller
public class BaseController {

    @RequestMapping("/")
    public String base() {
        return "index";
    }


    @RequestMapping("/blackjack")
    public String baseAccess() {
        return base();
    }

}
