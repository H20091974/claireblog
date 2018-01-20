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
import com.claire.domain.User;
import com.claire.mapping.ArticleMapper;
import com.claire.service.ArticleService;
import com.claire.service.UserService;

/**
 * Claire
 */
@Controller
public class ArticleController {
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	
    @GetMapping("/articleList")
    public String showAllArticle(Model model){
//    	System.out.println(articleMapper.findAllArticles().toString());
    	List<Article> articleList = articleService.findAllArticles();
    	model.addAttribute("articles", articleList);
        return "articleList";
    }
    
    @GetMapping("/article")
    public String showAllArticleByID(Model model, Integer id){
//    	System.out.println(articleMapper.findArticleById(id).toString());
    	Article article = articleService.findArticleById(id);
    	model.addAttribute("article", article);
    	
    	String userProfile = userService.getUserProfile(Integer.parseInt(article.getAuthor()));
//    	System.out.println(userProfile);
    	model.addAttribute("userprofile", userProfile);
    	
    	Article previous = articleService.findPreviousArticlyByAuthor(Integer.parseInt(article.getAuthor()), article.getId());
    	model.addAttribute("previous", previous);
    	
    	Article next = articleService.findNextArticlyByAuthor(Integer.parseInt(article.getAuthor()), article.getId());
    	model.addAttribute("next", next);
    	
        return "article";
    }
    
    

}
