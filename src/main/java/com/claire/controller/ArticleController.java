package com.claire.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.functors.ForClosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.claire.domain.Article;
import com.claire.mapping.ArticleMapper;
import com.claire.service.ArticleService;

/**
 * Claire
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ArticleService articleService;
	
    @GetMapping("/articleList")
    public String showAllArticle(Model model){
    	System.out.println(articleMapper.findAllArticles().toString());
    	model.addAttribute("articles", articleService.findAllArticles());
        return "articleList";
    }
    
    private String formatDate(Date date){
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd"); 
    	String strDate = formatter.format(date); 
    	return strDate;
    }
    
    
    

}
