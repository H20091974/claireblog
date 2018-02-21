package com.claire.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claire.domain.Baby;

@Repository
@Mapper
public interface BabyMapper {
	
	@Select("select * from baby_info order by rand() limit 3")
	List<Baby> getLuckyBabies();
	
	@Select("select * from baby_info ")
	List<Baby> getLuckyBabies2();
	
	@Select("select count(*) from baby_info ")
	int getBabyNum();
}
