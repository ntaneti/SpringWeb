package com.naveen.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.naveen.beans.Emp;

@Controller
public class EmpController {
	
	@RequestMapping("/empform")
	public ModelAndView showform(){
		return new ModelAndView("empform","command",new Emp());
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp")Emp emp){
		System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getDesignation());
		return new ModelAndView("redirect:/viewemp");
		
	}
	
	@RequestMapping("/viewemp")
	public ModelAndView viewemp(){
		
		List<Emp> list=new ArrayList<Emp>();
		list.add(new Emp(1,"naveen",25000f,"Engineer"));
		list.add(new Emp(2,"kumar",30000f,"J.Engineer"));
		list.add(new Emp(3,"taneti",40000f,"S.Engineer"));
		return new ModelAndView("viewemp","list",list);
		
		
	}
	
	

}
