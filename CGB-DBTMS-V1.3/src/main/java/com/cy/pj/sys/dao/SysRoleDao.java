package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.SysRole;

@Mapper
public interface SysRoleDao {
	List<SysRole> findPageObjects(
			@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("PageSize")Integer PageSize);
	
	int getRowCount(@Param("name") String name);
	
	int deleteObjects(Integer id);
	
	int insertObject(SysRole sysRole);
}

