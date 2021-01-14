package com.hanaro.sample3;

import java.util.ArrayList;
import java.util.Collection;

import javax.security.auth.login.AccountException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomDetails implements UserDetails{

	
	private String ID;
    private String PASSWORD;
    private String AUTHORITY;
    private boolean ENABLED;
    private String NAME;
    private int FAIL_CNT;

    
    
    
	public int getFAIL_CNT() {
		return FAIL_CNT;
	}

	public void setFAIL_CNT(int fAIL_CNT) {
		FAIL_CNT = fAIL_CNT;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return PASSWORD;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return ENABLED;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(AUTHORITY));
        return auth;

	}

}
