package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.RegistrationDao;
import com.model.Login;


@Controller
public class MainController {
	
	@Autowired
	private RegistrationDao regDao;
	
	// welcome page
	@RequestMapping("/sign")
	public String welcome(){
		return "login";
	}
	
	@RequestMapping("/")
	public String home(){
		return "success";
	}
	
	@RequestMapping("/failed")
	public String fail(){
		return "failed";
	}
	
	// registration page
	@RequestMapping("/register")
	public String registeration(){
		return "Register";
	}
	
	//registering and navigated to home
		@RequestMapping(value="/processRegister",method=RequestMethod.POST)
		public String handleProduct(@ModelAttribute Login login,HttpServletRequest request){
			System.out.println(login);
			regDao.saveUser(login);
			//RedirectView redirectView = new RedirectView();
			//redirectView.setUrl(request.getContextPath()+"/");
			return "home";
		}
		
		//getall
		@RequestMapping(value="/display")
		public String display(Model m){
			List<Login> login = regDao.getAll();
			m.addAttribute("users",login);
			return "displayusers";
		}
		
		//get check
		@RequestMapping("/login")
		public String check(@RequestParam("name") String name,@RequestParam("password") String password,HttpServletRequest request){
			boolean bool =false;
			List<Login> users = regDao.check();
			for(Login user:users){
				
				System.out.println(user.getName());
				if(user.getName().equals(name) && user.getPassword().equals(password)){
					System.out.println(user.getName());
					System.out.println(name);
					bool =true;
					break;
				}
		}
			if(bool==true){
				
				System.out.println("true");
				return "success";
				
			}
			else{
				System.out.println("fales");
				//RedirectView redirectView = new RedirectView();
				//redirectView.setUrl(request.getContextPath()+"/failed");
				return "failed";
				
			}
			}

}
