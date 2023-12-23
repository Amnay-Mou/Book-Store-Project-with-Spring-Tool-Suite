package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.BookDao;

@Controller
public class HomeBookController {
	
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/bookdtls")
	public String getBookbyId(Model m, int id) {
		m.addAttribute("numbook", bookDao.getbook(id));
		return "/bookdetails";
	}
	
	@RequestMapping("/bookdctg")
	public String getcartBook(Model m) {
		m.addAttribute("numbookcat", bookDao.getbookcatgory(1));
		return "/home1";
	}
	
	@RequestMapping("/bookdctg2")
	public String getcart2Book(Model m) {
		m.addAttribute("numbookcat", bookDao.getbookcatgory(2));
		return "/home1";
	}
	
	@RequestMapping("/bookdctg3")
	public String getcart3Book(Model m) {
		m.addAttribute("numbookcat", bookDao.getbookcatgory(3));
		return "/home1";
	}
}
