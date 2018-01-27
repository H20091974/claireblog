package com.claire.controller;

import com.claire.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhongnanhuang209074 on 2018/1/27.
 */
@Controller
@RequestMapping("/user/article")
public class UserArticleManagerController {

    @Autowired
    private ArticleService articleService;

    public String save(HttpServletRequest request){
        return  null;
    }

}
