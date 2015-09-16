package com.firststep.controller;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HelloWorldController {
	@RequestMapping(value="getmsg",method=RequestMethod.GET)
	public ModelAndView getMessage(){
		System.out.println("gemessage is invoked");
		return new ModelAndView("firstpage","displaymsg","Hello Spring and Maven in Kepler");
	}
}
