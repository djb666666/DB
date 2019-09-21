package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysDept;

public interface SysDeptService {
	
	/**查询所有部门以及上一级部门信息*/
	 List<Map<String,Object>> findObjects();
	 
	 int deleteObject(Integer id);
	 
	 List<Node> findZtreeDeptNodes();
	 
	 int saveObject(SysDept entity);
	 
	 int updateObject(SysDept entity);
}
