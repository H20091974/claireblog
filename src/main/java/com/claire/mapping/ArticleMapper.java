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
	@Insert("insert into article(title, author, postDate, headFig, content, tag) "
			+ "values(#{title}, #{author}, #{postDate}, #{headFig}, #{content}, #{tag}")
	int add(@Param("title") String title, @Param("author") int authorID, 
			@Param("postDate") Date postDate, @Param("headFig") String headFig,
			@Param("content") String content, @Param("tag") String tag);
	
	@Update("update article set content = #{content} where id = #{id}")
	int update(@Param("content") String content, @Param("id") int id);
	
	@Delete("delete from article where id = #{id}")
	int delete(int id);
	
	@Select("select * from article where id = #{id}")
	Article findArticleById(@Param("id") int id);
	
	@Select("select * from article where author = #{uid}")
	List<Article> findArticlesByAuthor(@Param("uid") int userId);
	
}
