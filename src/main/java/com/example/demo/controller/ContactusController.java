package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.ContactusDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.Contactus;

@Controller
public class ContactusController {
	@Autowired
	private ContactusDao contactusDao;
	
	@RequestMapping("/pgcontacts")
	public String contactUs() {
		return "contactus";
	}
	
	@RequestMapping("/contact")
	public String addMessg(Contactus c) {
		contactusDao.addaMessage(c);
		return "home";
	}
	@RequestMapping("/seemessages")
	public String getAllmessgs(Model m) {
		m.addAttribute("allcontact", contactusDao.getallContact());
		return "/admin/allmessages";
	}
	
	@RequestMapping("/deletemssg")
	public String dltmssg(int id) {
		contactusDao.deletemssgId(id);
		return "/admin/userdelete";
	}
}
