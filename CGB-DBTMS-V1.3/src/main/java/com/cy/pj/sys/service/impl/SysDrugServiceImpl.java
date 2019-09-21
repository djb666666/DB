package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysDrugDao;
import com.cy.pj.sys.service.SysDrugService;

@Service
public class SysDrugServiceImpl implements SysDrugService{
	@Autowired
	private SysDrugDao sysDrugDao;
	@Override
	@RequiresPermissions("sys:drug")
	public List<Map<String, Object>> findObjects() {
		
		return sysDrugDao.findObjects();
	}
	@Override
	public int deleteObjects(Integer... ids) {
		if(ids==null||ids.length==0) throw new ServiceException("请选择一个");
		int rows;
		try {
			rows=sysDrugDao.deleteObjects(ids);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("系统故障,正在修复中...");
		}
		if(rows==0) throw new ServiceException("记录可能已经不存在");
		
		return rows;
	}

}
