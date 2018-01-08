package com.claire.controller;

import com.claire.mapping.AdminMapper;
import com.claire.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hzn on 2018/1/6.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private MonitorService monitorService;

    @GetMapping("/")
    public String index(Model model){
        System.out.println(adminMapper.selectByPw("admin", "21232f297a57a5a743894a0e4a801fc3"));
        model.addAttribute("freeMemory", monitorService.getFreeMemory());
        model.addAttribute("pageId","index");
        return "admin/index";
    }


}
