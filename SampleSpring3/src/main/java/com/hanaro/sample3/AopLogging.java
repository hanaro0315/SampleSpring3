package com.hanaro.sample3;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



public class AopLogging {
	

	public void beforeAdvice() {
		System.out.println("before hand");
	}
	

	public void afterAdvice() {
		System.out.println("after hand");
	}
	
	
}
