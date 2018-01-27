package com.claire.controller;

import com.claire.domain.Article;
import com.claire.service.ArticleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * Created by zhongnanhuang209074 on 2018/1/27.
 */
@Controller
//@RequestMapping("/user/article")
public class UserArticleManagerController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/user")
    public String publish(HttpServletRequest request){
        return  "user/index";
    }


    @RequestMapping("/editor/id")
    public String editor(HttpServletRequest request){
        return  "article_editor";
    }


    @RequestMapping("/save")
    public String save(HttpServletRequest request){
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

}
