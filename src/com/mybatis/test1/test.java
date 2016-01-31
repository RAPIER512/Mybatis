package com.mybatis.test1;

import java.io.InputStream;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.bean.User;

public class test {

	public static void main(String[] args) {

		String resource = "conf.xml";
		InputStream is =  Test.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		String statement = "com.mybatis.test1.userMapper.getUser";
		User user =  session.selectOne(statement, 2);
		session.close();
		System.out.println(user);
	}

}
