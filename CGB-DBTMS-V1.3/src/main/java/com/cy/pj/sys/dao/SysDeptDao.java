package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysDept;

@Mapper
public interface SysDeptDao {
	SysDept findById();
	
	/** 查询所有部门以及上一级部门信息( */
	List<Map<String,Object>> findObjects();
	
	 /**
	  * 根据部门id统计子部门的个数
	  * @param id
	  * @return
	  */
	 int getChildCount(Integer id);
	 /**
	  * 根据id 删除部门
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 List<Node> findZtreeDeptNodes();
	 
	 int insertObject(SysDept entity);
	 
	 int updateObject(SysDept entity);
}
