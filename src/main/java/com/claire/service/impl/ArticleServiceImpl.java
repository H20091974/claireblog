/**
 * 
 */
package com.claire.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claire.domain.Article;
import com.claire.mapping.ArticleMapper;
import com.claire.service.ArticleService;

/**
 * @author claire
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleMapper articleMapper;
	
	@Override
	public int add(String title, int authorID, Date postDate, String headFig, String content, String tag) {
		return articleMapper.add(title, authorID, postDate, headFig, content, tag);
	}

	@Override
	public int update(String content, int id) {
		return articleMapper.update(content, id);
	}

	@Override
	public int delete(int id) {
		return articleMapper.delete(id);
	}

	@Override
	public Article findArticleById(int id) {
		return articleMapper.findArticleById(id);
	}

	@Override
	public List<Article> findArticlesByAuthor(int userId) {
		return articleMapper.findArticlesByAuthor(userId);
	}

	@Override
	public List<Article> findAllArticles() {
		return articleMapper.findAllArticles();
	}

	@Override
	public Article findPreviousArticlyByAuthor(int uid, int id) {
		return articleMapper.findPreviousArticlyByAuthor(uid, id);
	}

	@Override
	public Article findNextArticlyByAuthor(int uid, int id) {
		return articleMapper.findNextArticlyByAuthor(uid, id);
	}

}
