package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;
@Mapper
public interface SysMenuDao {
	List<Map<String,Object>> findObjects();
	
	List<Node> findZtreeMenuNodes();
	
	int insertObject(SysMenu entity);
	
	int updateObject(SysMenu entity);
	

	 /**
	  * 根据菜单id统计子菜单的个数
	  * @param id
	  * @return
	  */
	 int getChildCount(Integer id);
	 /**
	  * 根据id 删除菜单
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 List<String> findPermissions(
				@Param("menuIds")
				Integer[] menuIds);
	 
	 List<String> findPermission(@Param("menuIds")Integer []menuIds);
}	
