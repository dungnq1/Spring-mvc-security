package com.dungsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/hello")
	public String home(ModelMap modelMap) {
		modelMap.addAttribute("message", "Chào dũng");
		return "hello";
	}
	
	@GetMapping(value = "/admin")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("Hello Admin");
		return mav;
	}
	
	@GetMapping(value = "/manager")
	public ModelAndView managerPage() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("Hello manager");
		return mav;
	}
	
	@GetMapping(value = "/user")
	public ModelAndView userPage() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("Hello User");
		return mav;
	}
}
