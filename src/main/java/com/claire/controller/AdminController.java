package com.claire.controller;

import com.claire.domain.Article;
import com.claire.mapping.AdminMapper;
import com.claire.service.ArticleService;
import com.claire.service.MonitorService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

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

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("freeMemory", monitorService.getFreeMemory());
        model.addAttribute("sidebar","index");
        return "admin/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){

        return "success";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        return "success";
    }

    @RequestMapping("/article/publish")
    public String article_publish(Model model){

        model.addAttribute("sidbar","article");
        model.addAttribute("sub","publish");
        return "admin/article/publish";

    }


    /**
     * 保存文章
     * @param request
     * @return
     */
    @RequestMapping("/article/save")
    @ResponseBody
    public String article_save(HttpServletRequest request){

        try {
            MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
            MultipartFile file = params.getFile("headFig");
            String title = params.getParameter("title");
            String tagsinput = params.getParameter("tagsinput");
            String content = params.getParameter("content");

            String headFigPath = "log/" + file.getOriginalFilename();

            if (StringUtils.isBlank(title) || StringUtils.isBlank(content)) {
                return "title or content is empty.";
            }
            BufferedOutputStream stream = null;
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(headFigPath)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload headFig";
                }
                Article article = new Article();
                article.setTags(tagsinput);
                article.setTitle(title);
                article.setPostDate(new Date());
                article.setContent(content);
                article.setHeadFig(headFigPath);
                articleService.add(article);
            } else {
                return "You failed to upload headFig because the file was empty.";
            }
        }catch (Exception e){
            return "insert article error.";
        }
        return "upload successful";
    }

    @RequestMapping("/article/list")
    public String article_list(Model model){

        return "admin/article/list";
    }

}
