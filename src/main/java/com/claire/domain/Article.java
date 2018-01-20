/**
 * 
 */
package com.claire.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author claire
 *
 */
public class Article {
	private int id;
	private String title;
	private String author;
	private Date postDate;
	private int views;
	private String headFig;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public int getViews() {
		return views;
	}


	public void setViews(int views) {
		this.views = views;
	}


	public String getHeadFig() {
		return headFig;
	}


	public void setHeadFig(String headFig) {
		this.headFig = headFig;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}

	private String content;
	private String tags;
	private String summary;
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", postDate=" + postDate + ", views="
				+ views + ", headFig=" + headFig + ", content=" + content + ", tags=" + tags + ", summary=" + summary
				+ "]";
	}
	
	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
}
