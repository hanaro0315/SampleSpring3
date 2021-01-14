package com.hanaro.sample3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class LoginSucHandler implements AuthenticationSuccessHandler{

	@Autowired
	private CustomService cus;
	
	private String loginName;
	private String defaultUrl;
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDefaultUrl() {
		return defaultUrl;
	}

	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("loginId");
		cus.resetFailCnt(username);
	
		SavedRequest saveRequest = requestCache.getRequest(request, response);
		HttpSession session = request.getSession(false);
		if(session==null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		
		if(saveRequest!=null) {
			String targetUrl = saveRequest.getRedirectUrl();
			redirectStrategy.sendRedirect(request, response, targetUrl);
		}
		else {
			redirectStrategy.sendRedirect(request, response, defaultUrl);
		}
		
	}
	
	

}
