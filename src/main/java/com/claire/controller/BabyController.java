package com.claire.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.functors.ForClosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.claire.domain.Article;
import com.claire.domain.Baby;
import com.claire.domain.User;
import com.claire.mapping.ArticleMapper;
import com.claire.mapping.BabyMapper;
import com.claire.service.ArticleService;
import com.claire.service.BabyService;
import com.claire.service.UserService;

/**
 * Claire
 */
@Controller
public class BabyController {
	@Autowired
	private BabyMapper babyMapper;
	
	@Autowired
	private BabyService babyService;
	
    @GetMapping("/gallery")
    public String showAllArticle(Model model){

        return "gallery";
    }
    

    @GetMapping("/baby")
    public String showBaby(Model model){

        return "babyInfo";
    }
   
    @RequestMapping("/babyinfo")
    public String userinfo(HttpServletRequest request){
        return  "/user/babyinfo";
    }
    
    @RequestMapping("/lottery")
    public String lottery(Model model){
    	Random random = new Random();
    	List<Baby> luckybabies = babyService.getLuckyBabies();
    	
    	
    	System.out.println(luckybabies.get(0).getName());
    	System.out.println(luckybabies.get(1).getName());
    	System.out.println(luckybabies.get(2).getName());
    	model.addAttribute("first", luckybabies.get(0).getName());
    	model.addAttribute("second", luckybabies.get(1).getName());
    	model.addAttribute("third", luckybabies.get(2).getName());
        return  "/user/lottery";
    }
    

}
