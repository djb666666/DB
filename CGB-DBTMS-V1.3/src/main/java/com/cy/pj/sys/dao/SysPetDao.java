package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.cy.pj.sys.entity.SysPet;

@Mapper
public interface SysPetDao {
	
		List<SysPet> findPageObjects(
				@Param("name") String name,
				@Param("startIndex")Integer startIndex,
				@Param("pageSize")Integer pageSize);
		
		int getRowCount(@Param("name") String name);
		
		int insertObject(SysPet sysPet);
		
		SysPet findObjectById(Integer id);
		
		int updateObject(SysPet sysPet);
		
		
}
