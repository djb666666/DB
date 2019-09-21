package com.cy.pj.sys.service.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SysLogServiceImpl implements SysLogService{
	@Autowired
	private SysLogDao sysLogDao;
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1) throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysLogDao.getRowCount(username);
		if(rowCount==0) throw new ServiceException("系统找不到指定记录");
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
		//PageObject<SysLog> pageObject = new PageObject<>();
		/*
		 * pageObject.setPageCurrent(pageCurrent); pageObject.setPageSize(pageSize);
		 * pageObject.setRowCount(rowCount);
		 * pageObject.setPageCount((rowCount-1)/pageSize+1);
		 * pageObject.setRecords(records);
		 */
		return new PageObject<> (pageCurrent, pageSize,rowCount,records);
	}
	@RequiresPermissions("sys:log:delete")
	@Override
	public int deleteObjects(Integer... ids) {
		if(ids==null||ids.length==0) throw new IllegalArgumentException("请选择一个");
		int row;
		try {
			row=sysLogDao.deleteObjects(ids);
		} catch (Throwable  e) {
			e.printStackTrace();
			throw new ServiceException("系统故障,正在恢复中...");
		}
		if(row ==0) throw new ServiceException("记录可能已经不存在");
		return row;
	}
	//@Async(value = "asyncThreadPool")
	@Async
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveObject(SysLog entity) {
		try{Thread.sleep(5000);}catch(Exception e) {}
		sysLogDao.insertObject(entity);
	}
}
