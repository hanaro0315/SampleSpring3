package com.hanaro.sample3;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomDAO {
	
	@Resource(name="customFactory")
	private SqlSessionFactory customFactory;

	public CustomDetails getUserById(String id) {
		
		SqlSession session = customFactory.openSession();
		return session.selectOne("dao.mapper.selectUserById", id);
	}
	
	public int checkFailCnt(String id) {
		SqlSession session = customFactory.openSession();
		return session.selectOne("dao.mapper.checkFailCnt", id);
	}
	
	public void updateFailCnt(String id) {
		SqlSession session = customFactory.openSession();
		session.update("dao.mapper.updateFailCnt", id);
	}
	
	public void resetFailCnt(String id) {
		SqlSession session = customFactory.openSession();
		session.update("dao.mapper.resetFailCnt",id);
	}
	
	public void disabledUserById(String id) {
		SqlSession session = customFactory.openSession();
		session.update("dao.mapper.disabledUserById", id);
	}
	
	
}	
