package com.mybatis.test8;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mybatis.util.MybatisUtils;



public class Test8 {

	public static void main(String[] args) {
		
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession(true);
		
		String statement = "com.mybatis.test8.userMapper.getUserCount";
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("sexid", 0);
		map.put("usercount", -1);
		session.selectOne(statement,map);
		System.out.println("result= "+map.get("usercount"));
		session.close();
	}

}
