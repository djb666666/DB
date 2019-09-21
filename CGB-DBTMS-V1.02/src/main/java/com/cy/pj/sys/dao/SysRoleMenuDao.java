package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuDao {
	
	@Delete("delete from sys_user_roles where role_id=#{roleId}")
	int deleteObjectsByMenuId(Integer menuId);
	
	int insertObjects(
			@Param("roleId")Integer roleId,
			@Param("menuIds")Integer[] menuIds);
	
	int deleteObjectsByRoleId(Integer roleId);
	
	List<Integer> findMenuIdsByRoleIds(
			@Param("roleIds")Integer[] roleIds);
	
	List<Integer> findmenuIdByRoleId(@Param("roleIds")Integer [] roleIds);
}	
