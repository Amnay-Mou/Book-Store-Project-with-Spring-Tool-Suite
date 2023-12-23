package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;

@Controller
public class BookController {
	
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/homeadmin")
	public String getAllBook(Model m) {
		m.addAttribute("allbooks", bookDao.getAllbooks());
		return "/admin/homead";
	}
	
	@RequestMapping("/allhome")
	public String HOME(Model m) {
		m.addAttribute("allbks", bookDao.getAllbooks());
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/addnewbk")
	public String AddBooks(Book b) {
		return "/admin/addbook";
	}
	
	@RequestMapping("/addnewbook")
	public String AddBook(Book b) {
		bookDao.addNewBook(b);
		return "/adminconfigue";
	}
	
	@RequestMapping("/registepage")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/admin/delete")
	public String dlt(int id) {
		bookDao.deleteById(id);
		return "/admin/delete";
	}
	
	@RequestMapping("/admin/update")
	public String upd(int id, float price) {
		bookDao.updateid(id, price);
		return "/admin/update";
	}
	
	@RequestMapping("/getid")
	public String getBookById(int id) {
		return "/bookdetails";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/pgaboutws")
	public String aboutWebsite() {
		return "aboutws";
	}
	
	@RequestMapping("/getidd")
	public String GetIDs(Model m,int id) {
		m.addAttribute("numbook", bookDao.getbook(id));
		//--------------------------------------------
		bookDao.GetID(id);
		return "/admin/update";
	}
	
	@RequestMapping("/updt")
	public String UpdateeBook(Book b) {
		//--------------------------------------------
		bookDao.updateBookbyid(b);
		return "/admin/homead";
	}
	@RequestMapping("/test")
	public String test(Model m) {
		m.addAttribute("allbks", bookDao.getAllbooks());
		return "index";
	}
}
