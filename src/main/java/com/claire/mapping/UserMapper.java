package com.claire.mapping;

import org.apache.ibatis.annotations.Insert;
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
	
	@Insert("insert into user(nickname, password) values (#{name},#{password})")
	Boolean saveUser(@Param("name") String name, @Param("password") String password);
	
	@Insert("insert into user(firstname,lastname, gender, profile, description, email, region, street, city, country) "
			+ "values(#{firstname},#{lastname}, #{gender}, #{profile}, #{description}, #{email}, #{region}, #{street}, #{city}, #{country})")
	Boolean updateUserProfile(@Param("firstname") String firstname,@Param("lastname") String lastname, @Param("gender") String gender, 
			@Param("profile") String profile, @Param("description") String description, 
			@Param("email") String email, @Param("region") String region, @Param("street") String street, 
			@Param("city") String city, @Param("country") String country);
}
