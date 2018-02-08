package com.claire.mapping;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

	@Select("select profile from user where id = #{uid}")
	String findUserProfileById(@Param("uid") int userId);
	
	@Select("select nickname from user where id = #{uid}")
	String findNicknameById(@Param("uid") int userId);
	
	@Select("select count(id) from user where nickname = #{name} and password = #{password}")
	Integer verifyUser(@Param("name") String name, @Param("password") String password);
}
