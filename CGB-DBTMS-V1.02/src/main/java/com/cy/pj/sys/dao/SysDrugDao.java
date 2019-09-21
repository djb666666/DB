package com.cy.pj.sys.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysDrugDao {
	
	List<Map<String,Object>> findObjects();
	
	int deleteObjects(@Param("ids")Integer...ids);
	
	
}
