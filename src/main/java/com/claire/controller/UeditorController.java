package com.claire.controller;

import com.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.PrintWriter;

/**
 * Created by hzn on 2018/1/13.
 */

@Controller
@Transactional
@RequestMapping("/")
public class UeditorController {

    @RequestMapping(value = "/ueditor")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext()
                .getRealPath("/");
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
