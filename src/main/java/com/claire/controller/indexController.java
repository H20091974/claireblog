package com.claire.controller;

import com.claire.mapping.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 前端页面显示的控制器
 * 共包括archives,login,projects,tags,about,post,login这几个页面
 */
@Controller
public class indexController {

    @Autowired
    private AdminMapper adminMapper;

    @GetMapping("/")
    public String index(Model model){

        System.out.println(adminMapper.selectByPw("admin", "21232f297a57a5a743894a0e4a801fc3"));
        return "index";
    }

}
