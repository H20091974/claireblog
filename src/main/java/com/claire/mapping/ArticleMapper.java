/**
 * 
 */
package com.claire.mapping;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.claire.domain.Article;

/**
 * @author claire
 *
 */
@Repository
@Mapper
public interface ArticleMapper {
	@Insert("insert into article(title, author, postDate, headFig, content, tags) "
			+ "values(#{title}, #{author}, #{postDate}, #{headFig}, #{content}, #{tag})")
	int add(@Param("title") String title, @Param("author") int authorID, 
			@Param("postDate") Date postDate, @Param("headFig") String headFig,
			@Param("content") String content, @Param("tag") String tag);
	
	@Update("update article set content = #{content} where id = #{id}")
	int update(@Param("content") String content, @Param("id") int id);
	
	@Delete("delete from article where id = #{id}")
	int delete(int id);
	
	@Select("select title, user.nickname as author, postDate, views, headFig, summary, tags from article,user where article.author=user.id")
	List<Article> findAllArticles();
	
	@Select("select * from article where id = #{id}")
	Article findArticleById(@Param("id") int id);
	
	@Select("select * from article where author = #{uid}")
	List<Article> findArticlesByAuthor(@Param("uid") int userId);
	
	//SELECT * FROM article where author=1 and postDate < (select postDate from article where id=3) limit 1
	@Select("SELECT * FROM article where author=#{uid} and postDate < (select postDate from article where id=#{id}) limit 1")
	Article findPreviousArticlyByAuthor(@Param("uid") int uid, @Param("id") int id);
	
	//SELECT * FROM article where author=1 and postDate > (select postDate from article where id=3) order by postDate desc limit 1
	@Select("SELECT * FROM article where author=#{uid} and postDate > (select postDate from article where id=#{id}) order by postDate desc limit 1")
	Article findNextArticlyByAuthor(@Param("uid") int uid, @Param("id") int id);
}
