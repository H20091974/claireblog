package com.claire.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.claire.domain.User;
import com.claire.mapping.ArticleMapper;
import com.claire.service.ArticleService;
import com.claire.service.UserService;

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
	@Autowired
	private UserService userService;

	@RequestMapping("/")
    public String index(Model model){
    	System.out.println(articleMapper.findArticleById(2).toString());
    	model.addAttribute("article", articleService.findArticleById(2));
        return "index";
    }
    
    @RequestMapping(value="/login")
    @ResponseBody
    public String login(HttpServletRequest request, Model model){
    	
    	 
    	System.out.println("in heree.");
    	String username = request.getParameter("username");
    	String psw = request.getParameter("password");
    	System.out.println(username + "------" + psw);
    	boolean success = userService.verifyUser(username,psw);
    	
    	if(success) return "success";
    	else return "fail";
    }
    
    
    

}
