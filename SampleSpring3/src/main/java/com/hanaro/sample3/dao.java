package com.hanaro.sample3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class dao {

	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public List<dto> selectAll(){
		
		SqlSession session = sqlSessionFactory.openSession();
		return session.selectList("dao.mapper.selectAll");
	}
	
}
