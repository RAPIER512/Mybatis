package com.mybatis.test5;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.bean.Classes;
import com.mybatis.bean.Order;
import com.mybatis.util.MybatisUtils;

public class Test5 {

	public static void main(String[] args) {
		
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession(true);
		
//		String statement = "com.mybatis.test5.ClassMapper.getClass";
		String statement = "com.mybatis.test5.ClassMapper.getClass2";
		
		Classes c = session.selectOne(statement, 2);
		session.close();
		System.out.println("c="+c);
	}

}
