package com.mybatis.test7;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.bean.ConditionUser;
import com.mybatis.bean.User;
import com.mybatis.util.MybatisUtils;



public class Test7 {

	public static void main(String[] args) {
		
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession(true);
		
		String statement = "com.mybatis.test7.userMapper.getUser";
		String name = "o";
		name = null;
		
		ConditionUser parameter = new ConditionUser("%"+name+"%", 13, 18);
		List<User> list =session.selectList(statement, parameter);
		session.close();
		System.out.println("list = "+list);
	}

}
