package com.cy.pj.sys.service.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysPetDao;
import com.cy.pj.sys.entity.SysPet;
import com.cy.pj.sys.service.SysPetService;

@Service
public class SysPetServiceImpl implements SysPetService {
	@Autowired
	private SysPetDao sysPetDao;
	
	@RequiresPermissions("sys:pet")
	@Override
	public PageObject<SysPet> findPageObjects(String name, Integer pageCurrent) {
		// 1.数据合法性验证
		if (pageCurrent <= 0 || pageCurrent == null)
			throw new ServiceException("参数不合法");
		// 2.依据条件获取总记录数
		int rowCount = sysPetDao.getRowCount(name);
		if (rowCount == 0)
			throw new ServiceException("记录不存在");
		// 3.计算startindex的值
		int pageSize = 3;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysPet> records = sysPetDao.findPageObjects(name, startIndex, pageSize);
		System.out.println(records);
		PageObject<SysPet> pageObject = new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount - 1) / pageSize + 1);
		return pageObject;
	}

	@Override
	public int SaveObject(SysPet entity) {
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		/*
		 * if(StringUtils.isEmpty(entity.getMastername())) throw new
		 * ServiceException("寄养人不能为空");
		 * 
		 * if(StringUtils.isEmpty(entity.getPhone())) throw new
		 * ServiceException("联系电话不能为空");
		 */
		int rows = sysPetDao.insertObject(entity);
		return rows;
	}

	@Override
	public SysPet findObjectById(Integer id) {
		if(id==null||id<=0) throw new ServiceException("参数不合法");
		SysPet syspet = sysPetDao.findObjectById(id);
		if(syspet==null) throw new ServiceException("此用户已经不存在");
		return syspet; 
	}

	@Override
	public int updateObject(SysPet sysPet) {
		if(sysPet==null) throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(sysPet.getMastername()))
			throw new ServiceException("联系人不能为空");
		if(StringUtils.isEmpty(sysPet.getPhone()))
			throw new ServiceException("联系方式不能为空");
		
		int rows = sysPetDao.updateObject(sysPet);
		if(rows==0) throw new ServiceException("修改失败");
		return rows;
	}

}
