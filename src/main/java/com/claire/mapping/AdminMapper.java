package com.claire.mapping;

import com.claire.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by hzn on 2018/1/6.
 * 后台管理员操作sql
 */
@Repository
@Mapper
public interface AdminMapper {

    @Select({
            "select count(*) ",
            "from admin ",
            "where username = #{un} ",
            "and password = #{pw}"
    })
    int selectByPw(@Param("un") String username, @Param("pw") String password) throws RuntimeException;


}
