package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysPet;

public interface SysPetService {
	
	PageObject<SysPet> findPageObjects(
			String name,
			Integer pageCurrent);
	
	int SaveObject(SysPet entity);
	
	SysPet findObjectById(Integer id);
	
	int updateObject(SysPet sysPet);
}
