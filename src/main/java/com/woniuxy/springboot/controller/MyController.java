package com.woniuxy.springboot.controller;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.woniuxy.springboot.po.Dep;
import com.woniuxy.springboot.po.Emp;
@Controller
public class MyController {
	@RequestMapping("/toIndex")
	public String toIndex() {
		System.out.println("toIndex");
		return "index";
	}
	@RequestMapping("/user/login")
	public String dologin(String username,String password,
			HttpSession session,Model model) {
		//System.out.println(username+":"+password);
		if(!StringUtils.isEmpty(username) && "aaa".equals(password)) {
			session.setAttribute("user",username );	
			return "index";
		}else {
			model.addAttribute("msg", "登录失败");
			return "login";
		}	
	}
	@RequestMapping("/emps")
	public String dolist(Model model) {
		List<Emp> emps = new ArrayList<Emp>();
		emps.add(new Emp(1, "zs", new Date(), new Dep(1, "d001")));
		emps.add(new Emp(2, "ls", new Date(), new Dep(2, "d002")));
		model.addAttribute("emps", emps);
		//System.out.println(emps);
		return "emplist";
	}
	@RequestMapping("/emp")
	public String doaddDep(Model model) {
		List<Dep> deps = new ArrayList<Dep>();
		deps.add( new Dep(1, "d001"));
		deps.add( new Dep(2, "d002"));
		model.addAttribute("deps", deps);
		//System.out.println(deps);
		return "empadd";
	}
	@PostMapping("/emp")
	public String doaddEmp(Emp emp) {
		//System.out.println(emp);
		return "redirect:/emps";
	}
	@RequestMapping("/update/{eid}")
	public String doupdate(@PathVariable("eid")Integer eid,Model model) {
		List<Dep> deps=new ArrayList<Dep>();
		deps.add(new Dep(1,"d001"));
		deps.add(new Dep(2,"d002"));
		model.addAttribute("deps", deps);
		Emp emp=null;
		if(eid==1) {
			emp=new Emp(1,"zs",new Date(),new Dep(1,"d001"));
		}else{
			emp=new Emp(2,"ls",new Date(),new Dep(2,"d002"));
		}
		model.addAttribute("emp", emp);
		System.out.println(emp);
		return "update";
	}
	@PutMapping("/emp")
	public String doupdateEmp(Emp emp) {
		System.out.println(emp);
		return "redirect:/emps";
	}
	@RequestMapping("/delete/{eid}")
	public String dodelete(@PathVariable("eid")Integer eid,Model model) {
		System.out.println("删除："+eid);
		return "redirect:/emps";
	}
}
