package com.hanaro.sample3;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuth implements AuthenticationProvider{
	
	@Autowired
	private CustomService cs;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String id = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		Collection<GrantedAuthority> authorities = null;

//		Iterator<? extends GrantedAuthority> iter = authentication.getAuthorities().iterator();
//		while(iter.hasNext()) {
//			GrantedAuthority auth = iter.next();
//			
//		}
		CustomDetails cd = (CustomDetails) cs.loadUserByUsername(id);
		System.out.println("------------------------");
		System.out.println("auth detail : " +authentication.getDetails());
		System.out.println("is auth? : "+authentication.isAuthenticated());
		System.out.println("input pw : "+password);
		System.out.println("db pw : "+cd.getPassword());
		System.out.println("------------------------");

		authorities = cd.getAuthorities();
		
		if(!matchPassword(password,cd.getPassword())) {
			throw new BadCredentialsException(id);
		}
		
		if(!cd.isEnabled()) {
			throw new BadCredentialsException(id);
		}
		return new UsernamePasswordAuthenticationToken(id, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	
	private boolean matchPassword(String id, String pw) {
		return id.equals(pw);
	}

}
