package com.hanaro.sample3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomService implements UserDetailsService{

	@Autowired
	private CustomDAO cusDAO;
	
	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		CustomDetails cd = cusDAO.getUserById(loginId);
		if(cd==null) {
			throw new UsernameNotFoundException(loginId);
		}
		else {
			cd.getAuthorities();
		}
		
		// TODO Auto-generated method stub
		return cd;
	}
	
	public void countFail(String loginId) {
		 cusDAO.updateFailCnt(loginId);
	}
	
	public int checkFailCnt(String loginId) {
		return cusDAO.checkFailCnt(loginId);
	}
	
	public void resetFailCnt(String loginId) {
		 cusDAO.resetFailCnt(loginId);
	}
	
	public void disabledUser(String loginId) {
		cusDAO.disabledUserById(loginId);
	}
	
	

}
