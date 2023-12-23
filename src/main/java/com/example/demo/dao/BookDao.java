package com.example.demo.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.model.User;


@Component
public class BookDao {
	private JdbcTemplate jdbcTemplate;
	public BookDao() {
		DriverManagerDataSource dataSource=new  DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bookstore?serverTimezone=GMT");
		dataSource.setUsername("root");
		dataSource.setPassword("amnay.mou2002");
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public List<Book> getAllbooks(){
		String sql="select * from book";
		List<Book> books=jdbcTemplate.query(sql, new BookMapper());
		return books;
	}
	
	public int addNewBook(Book b) {
	    String sql = "INSERT INTO bookstore.book ( `bookname`, `author`, `update`, `pic`, `price`, `details`, `category`, `comment`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
	    Object params[] = { b.getBookname(), b.getAuthor(), b.getUpdate(), b.getPic(), b.getPrice(),
	    		b.getDetails(), b.getCategory(), b.getComment()};
	    return jdbcTemplate.update(sql, params);
	}
	
	public List<Book> getbook(int id){
		String sql="select * from book where bookid="+id;
		List<Book> books=jdbcTemplate.query(sql, new BookMapper());
		return books;
	}
	
	public List<Book> getbookcatgory(int ctg){
		String sql="select * from book where category="+ctg;
		List<Book> books=jdbcTemplate.query(sql, new BookMapper());
		return books;
	}
	
	public int addanewUser(User u) {
		String sql="insert into user(Email, password, firstname, lastname, role) values(?, ?, ?, ?, 1)";
		Object params[] = {u.getEmail(), u.getPassword(), u.getFirstname(), u.getLastname()};
		return jdbcTemplate.update(sql, params);
	}
	
	public int updateid(int id, float price) {
	    String sql = "update book set price = ? where bookid = ?";
	    Object params[] = {price, id};
	    return jdbcTemplate.update(sql, params);
	}
	
	public int deleteById(int id) {
		String sql="delete from book where bookid=?";
		Object params[]= {id};
		return jdbcTemplate.update(sql,params);
	}
	
	public List<Book> GetID(int id){
		String sql="select * from book where bookid="+id;
		List<Book> books=jdbcTemplate.query(sql, new BookMapper());
		return books;
	}
	
	public int updateBookbyid(Book b) {
	    String sql = "update book set bookname = ?, author = ?, `update`= ?, pic = ?, price = ?, details = ?, category = ?, comment = ? where bookid = ?";
	    Object params[] = {b.getBookname(), b.getAuthor(), b.getUpdate(), b.getPic(), b.getPrice(), b.getDetails(), b.getCategory(), b.getComment() ,b.getBookid()};
	    return jdbcTemplate.update(sql, params);
	}

}













