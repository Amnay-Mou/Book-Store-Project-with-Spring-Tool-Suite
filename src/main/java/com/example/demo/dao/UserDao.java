package com.example.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Component
public class UserDao {
	private JdbcTemplate jdbcTemplate;
	public UserDao() {
		DriverManagerDataSource dataSource=new  DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bookstore?serverTimezone=GMT");
		dataSource.setUsername("root");
		dataSource.setPassword("amnay.mou2002");
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public int checkUser(User user) {
	    String sql = "SELECT * FROM user WHERE Email='" + user.getEmail() + "' AND password='" + user.getPassword() + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    
	    if (users.isEmpty()) {
	        return 2; // User is not in the database
	    } else {
	        User firstUser = users.get(0);
	        if (firstUser.getRole() == 1) {
	            return 1; // Ordinary user
	        } else {
	            return 0; // Admin user
	        }
	    }
	}
	public int deleteusr(int id) {
		String sql="delete from user where Num=?";
		Object params[]= {id};
		return jdbcTemplate.update(sql, params);
	} 
	
	public List<User> getalluser(){
		String sql="select * from user";
		List<User> user=jdbcTemplate.query(sql, new UserMapper());
		return user;
	}
}
