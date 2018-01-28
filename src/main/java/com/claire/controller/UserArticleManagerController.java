package com.claire.controller;

import com.claire.domain.Article;
import com.claire.service.ArticleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhongnanhuang209074 on 2018/1/27.
 */
@Controller
@RequestMapping("/user")
public class UserArticleManagerController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/articles")
    public String articles(Model model){

        List<Article> articleList = articleService.findAllArticles();
        model.addAttribute("articles",articleList);

        return  "/user/articles";
    }

    @RequestMapping("/userinfo")
    public String userinfo(HttpServletRequest request){
        return  "/user/userinfo";
    }



    @RequestMapping("/article/publish")
    public String publish(HttpServletRequest request){
        return  "/user/publish";
    }


    @RequestMapping("/article/editor/{id}")
    public String editor(Model model,@PathVariable int id){
        Article article = articleService.findArticleById(id);
        model.addAttribute("article",article);
        System.out.println(article);
        return  "/user/editor";
    }


    @RequestMapping("/article/save")
    @ResponseBody
    public String article_save(HttpServletRequest request){
        try {

            MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
            MultipartFile file = params.getFile("headFig");
            String title = params.getParameter("title");
            String tagsinput = params.getParameter("tagsinput");
            String content = params.getParameter("content");

            System.out.println(params.getParameter("id"));

            String headFigPath = "image\\" + file.getOriginalFilename();

            if (StringUtils.isBlank(title) || StringUtils.isBlank(content)) {
                return "title or content is empty.";
            }
            BufferedOutputStream stream = null;
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File("D:\\"+headFigPath)));
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

    @RequestMapping("/images/publish")
    public String images_publish(Model model){
        return "/user/images_publish";
    }


    @RequestMapping("/images/save")
    @ResponseBody
    public String images_save(HttpServletRequest request){

        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        System.out.println("---------------------------------------");
        Map<String,MultipartFile> fileMap = params.getFileMap();
        for (Map.Entry<String,MultipartFile> node : fileMap.entrySet()){
            System.out.println(node.getKey() + "-->" + node.getValue().getOriginalFilename());
        }

        return "/user/images_publish";
    }

}
