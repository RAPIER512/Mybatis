package com.mybatis.test4;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.bean.Order;
import com.mybatis.util.MybatisUtils;

public class Test4 {

	public static void main(String[] args) {
		
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.mybatis.test4.orderMapper.getOrder";
		Order order = session.selectOne(statement, 2);
		System.out.println("order="+order);
	}

}
