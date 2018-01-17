package com.claire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.claire.mapping.ArticleMapper;
import com.claire.service.ArticleService;

/**
 * 前端页面显示的控制器
 * 共包括archives,login,projects,tags,about,post,login这几个页面
 */
@Controller
public class indexController {
	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ArticleService articleService;

    @GetMapping("/")
    public String index(Model model){
    	System.out.println(articleMapper.findArticleById(2).toString());
    	model.addAttribute("article", articleService.findArticleById(2));
        return "index";
    }
    
    
    

}
