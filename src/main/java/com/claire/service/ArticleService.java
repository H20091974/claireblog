/**
 * 
 */
package com.claire.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.claire.domain.Article;
import com.claire.mapping.ArticleMapper;

/**
 * @author claire
 *
 */
public interface ArticleService {
	public int add(String title, int authorID, Date postDate, String headFig, String content, String tag);
	
	public int update(String content, int id);
	
	public int delete(int id);

	public int add(Article article);
	
	public List<Article> findAllArticles();
	
	public Article findArticleById(int id);
	
	public List<Article> findArticlesByAuthor(int userId);
	
}
