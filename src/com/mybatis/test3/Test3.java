package com.mybatis.test3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.mybatis.bean.User;
import com.mybatis.util.MybatisUtils;

public class Test3 {
	/**
	 * ×¢½â²âÊÔ·½·¨
	 */
	@Test
	public void testAdd(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession(true);
		UserMapper mapper = session.getMapper(UserMapper.class);
		int add = mapper.addUser(new User(-1,"ss",45));
		System.out.println("add = "+add );
		
		session.close();
	}
}
