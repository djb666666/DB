package com.cy;

import java.util.List;

import javax.sql.DataSource;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatasourceTests2 {

	@Autowired
	private DataSource dataSource;
	@Test
	public void testDataSource() throws Exception{
		Assert.assertNotEquals(null, dataSource);
		System.out.println(dataSource.getConnection());
	}
	
}

