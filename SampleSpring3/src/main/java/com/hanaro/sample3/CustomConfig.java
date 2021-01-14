package com.hanaro.sample3;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



public class CustomConfig extends WebSecurityConfigurerAdapter{

	public void configure(WebSecurity web, HttpSecurity http) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		
		http.formLogin()
			.loginPage("/login")
			.permitAll();
		
		
		http.formLogin()
			.loginProcessingUrl("/loginAction")
			.usernameParameter("loginId")
			.passwordParameter("loginPwd")
			.permitAll();
		
		http.formLogin()
			.defaultSuccessUrl("/")
			.permitAll();
		
		http.formLogin()
			.failureUrl("/login?error")
			.permitAll();
		
		http.authorizeRequests()
			.anyRequest().authenticated();
		
		
		
		
	}
	

	
}
