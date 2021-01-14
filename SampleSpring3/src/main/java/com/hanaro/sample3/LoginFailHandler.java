package com.hanaro.sample3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailHandler implements AuthenticationFailureHandler{

	@Autowired
	private CustomService cusServ;
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("loginId");
		String password = request.getParameter("loginPw");
		String errormsg = exception.getMessage();
		
		if(exception instanceof BadCredentialsException) {
            loginFailCount(username);
        }

		request.setAttribute(loginName,username);
		request.setAttribute(loginPw,password);
		request.setAttribute(errorname, errormsg);
		
		request.getRequestDispatcher(defaultFailUrl).forward(request, response);
	}
	
	protected void loginFailCount(String username) {
		cusServ.countFail(username);
		int cnt = cusServ.checkFailCnt(username);
		System.out.println("System cnt : "+cnt);
		if(cnt==3) {
			cusServ.disabledUser(username);
		}
	}

	private String loginName;
	private String loginPw;
	private String errorname;
	private String defaultFailUrl;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPw() {
		return loginPw;
	}
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}
	public String getErrorname() {
		return errorname;
	}
	public void setErrorname(String errorname) {
		this.errorname = errorname;
	}
	public String getDefaultFailUrl() {
		return defaultFailUrl;
	}
	public void setDefaultFailUrl(String defaultFailUrl) {
		this.defaultFailUrl = defaultFailUrl;
	}
	
}
