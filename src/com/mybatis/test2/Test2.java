package com.mybatis.test2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.mybatis.bean.User;
import com.mybatis.util.MybatisUtils;

public class Test2 {

	@Test
	public void testAdd(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		
		SqlSession session = factory.openSession();
		String statement = "com.mybatis.test2.userMapper.addUser";
		int insert =  session.insert(statement, new User(-1,"kk",23));
		session.commit();
		session.close();
		System.out.println("insert="+insert);
	}
	
	@Test
	public void testUpdate(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		
		SqlSession session = factory.openSession(true);
		String statement = "com.mybatis.test2.userMapper.updateUser";
		int update =  session.update(statement,new User(8,"kkupdate",25) );
		session.close();
		System.out.println("update="+update);
	}
	
	@Test
	public void testDelete(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		
		SqlSession session = factory.openSession(true);
		String statement = "com.mybatis.test2.userMapper.deleteUser";
		int delete = session.delete(statement, 8);
		session.close();
		System.out.println("delete = "+delete);
	}
	
	@Test
	public void testGetUser(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		
		SqlSession session = factory.openSession(true);
		String statement = "com.mybatis.test2.userMapper.getUser";
		User user = session.selectOne(statement,1);
		session.close();
		System.out.println("user = "+user);
	}
	
	@Test
	public void testGetAll(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		
		SqlSession session = factory.openSession(true);
		String statement = "com.mybatis.test2.userMapper.getALLUsers";
		List<User> list = session.selectList(statement);
		session.close();
		System.out.println("list = "+list);
	}
	
}
