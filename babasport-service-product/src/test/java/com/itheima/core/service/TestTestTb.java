package com.itheima.core.service;

import com.itheima.core.pojo.TestTb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * 测试Spring整合Mybatis
 * 
 * @author lx
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestTestTb {

	
	@Autowired
//	private TestTbDao testTbDao;
	private TestTbService testTbService;

//	@Autowired
//	private Jedis jedis;
	
	@Test
	public void testAdd() throws Exception {
		TestTb testTb = new TestTb();
		testTb.setName("阿六");
		testTb.setBirthday(new Date());
		testTbService.insertTestTb(testTb);
	}

//	@Test
//	public void testRedis() throws Exception {
//		jedis.set("aaa","110");
//		jedis.close();
//	}
}
