package com.itheima.core.service;

import com.itheima.core.dao.TestTbDao;
import com.itheima.core.pojo.TestTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试 事务
 * @author lx
 *
 */
@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService {

	
	@Autowired
	private TestTbDao testTbDao;
	@Override
	public void insertTestTb(TestTb testTb) {
		// TODO Auto-generated method stub
		testTbDao.insertTestTb(testTb);
		
		throw new RuntimeException();
	}

	
	
}
