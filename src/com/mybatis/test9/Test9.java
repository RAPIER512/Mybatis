package com.mybatis.test9;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.mybatis.bean.CUser;
import com.mybatis.util.MybatisUtils;
/** 
 *²âÊÔ»º´æ
 *1.Ò»¼¶»º´æÄ¬ÈÏ¿ªÆô
 *
 */

public class Test9 {

	@Test
	public void testCacheOne(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession(true);
		
		String statement = "com.mybatis.test9.userMapper.getUser";
		CUser user = session.selectOne(statement, 1);
		System.out.println("User="+user);
		
		session.clearCache();
		
		user = session.selectOne(statement, 1);
		System.out.println("user="+user);
		
		
		session.close();
	}
	
	@Test
	public void testCacheTwo(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		SqlSession session2 = factory.openSession();
		
		String statement = "com.mybatis.test9.userMapper.getUser";
		CUser user = session.selectOne(statement,1);
		session.commit();
		System.out.println(user);
		
		user = session2.selectOne(statement, 1);
		session2.commit();
		System.out.println(user);
		
		session.close();
		session2.close();
	}
	
	
}
