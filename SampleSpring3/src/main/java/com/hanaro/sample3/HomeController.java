package com.hanaro.sample3;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanaro.sample3.dto;

@Controller
public class HomeController {

	@Autowired 
	private dao da;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("MYBATIS START3");
		try {
	
			List<dto> list = da.selectAll();
			System.out.println("id : "+list.get(0).getID());
			model.addAttribute("list",list);

		} catch (Exception e) {
			System.out.println("Exception is "+e);// TODO: handle exception
		}
		
		return "home";
	}
	
	@RequestMapping(value="/login")
	public String page() throws Exception {
		return "/page/login";
	}
	
	@RequestMapping(value="/page")
	public String page2() throws Exception {
		return "page";
	}
	
	@RequestMapping(value="/loginAction")
	public String loginAction() {
		return "home";			
	}
	
	@RequestMapping(value="/user/page")
	public String userPage() throws Exception {
		return "/user/userPage";
	}
	
	@RequestMapping(value="/member/page")
	public String memberPage() throws Exception {
		return "/member/memberPage";
	}
	
	@RequestMapping(value="/admin/page")
	public String adminPage() throws Exception {
		return "/admin/adminPage";
	}
	
	
}
