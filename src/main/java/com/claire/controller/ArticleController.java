package com.claire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.claire.mapping.ArticleMapper;
import com.claire.service.ArticleService;

/**
 * Claire
 */
@Controller
public class ArticleController {

    @GetMapping("/articleList")
    public String index(Model model){
    	
        return "articleList";
    }
    
    
    

}
