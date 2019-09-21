package com.cy.pj.sys.service.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import com.cy.pj.sys.vo.SysRoleMenuVo;

@Service
public class SysRoleServiceImpl implements SysRoleService{
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer PageCurrent) {
		if (PageCurrent==null||PageCurrent<=0) 
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysRoleDao.getRowCount(name);
		if(rowCount==0) throw new ServiceException("记录不存在");
		int pageSize=3;
		int startIndex=(PageCurrent-1)*pageSize;
		List<SysRole> records = 
				sysRoleDao.findPageObjects(name, startIndex, pageSize);
		PageObject<SysRole> pageObject=new PageObject<>();
		pageObject.setPageCurrent(PageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		pageObject.setRowCount(rowCount);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		return pageObject;
	}
	@Override
	public int deleteObjects(Integer id) {
		if(id==null||id<=0) throw new IllegalArgumentException("id值错误...");
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		sysUserRoleDao.deleteObjectsByRoleId(id);
		int rows = sysRoleDao.deleteObjects(id);
		if(rows==0) throw new ServiceException("记录可能已经不存在");
		
		return rows;
	}
	
}
