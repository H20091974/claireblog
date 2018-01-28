package com.claire.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.functors.ForClosure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.claire.domain.Article;
import com.claire.domain.User;
import com.claire.mapping.ArticleMapper;
import com.claire.service.ArticleService;
import com.claire.service.UserService;

/**
 * Claire
 */
@Controller
public class BabyController {
	
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
    
    

}
