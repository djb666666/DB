package com.cy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogDaoTest {
	@Autowired
	private SysLogDao syslogdao;
	@Test
	public void testFindPageObjects() {
		List<SysLog> list = syslogdao.findPageObjects("admin",0,3);
		System.out.println(list.size());
	}
	@Test
	public void testGetRowCount() {
		int rowCount = syslogdao.getRowCount(null);
		System.out.println(rowCount);
	}
}