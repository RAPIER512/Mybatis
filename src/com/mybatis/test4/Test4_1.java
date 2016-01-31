package com.mybatis.test4;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.mybatis.bean.Order;
import com.mybatis.util.MybatisUtils;

public class Test4_1 {

	@Test
	public void TestGetOrder2(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.mybatis.test4.orderMapper.getOrder2";
		Order order = session.selectOne(statement, 2);
		System.out.println("order="+order);
	}
	
	
	
	
	
}
