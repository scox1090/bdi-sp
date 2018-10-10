package com.bdi.sp;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory ssf;
	
	@Autowired
	private SqlSession ss;
	
	@Test
	public void test() {
		try {
			Connection con = ds.getConnection();
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void test2() {
		SqlSession ss = ssf.openSession();
		assertNotNull(ss);	// 이곳에서 쓰는 ss는 44번에서 선언한 ss
	}
	
	@Test
	public void test3() {
		assertNotNull(ss);	// 이곳에서 쓰는 ss는 31번에서 AutoWired한 ss
	}
}
