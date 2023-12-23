package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/deallogin")
	public String deallogin(User user) {
		int role = userDao.checkUser(user);
		if(role==0)
			return "/adminconfigue";
		else if(role==1)
			return "/home";
		else
			return "/loginerror";
	}
	
	@RequestMapping("/register")
	public String addUser(User u) {
		bookDao.addanewUser(u);
		return "/login";
	}
	
	@RequestMapping("/allusers")
	public String backCfg() {
		return "/admin/allusers";
	}
	
	@RequestMapping("/seealluser")
	public String getAllUsers(Model m) {
		m.addAttribute("alluser", userDao.getalluser());
		return "/admin/allusers";
	}
	
	@RequestMapping("/deleteuser")
	public String dltUser(int id) {
		userDao.deleteusr(id);
		return "/admin/userdelete";
	}
	
	
	
}






























