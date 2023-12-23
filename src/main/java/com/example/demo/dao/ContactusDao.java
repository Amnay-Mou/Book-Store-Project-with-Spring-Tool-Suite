package com.example.demo.dao;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.example.demo.mapper.ContactusMapper;
import com.example.demo.model.Contactus;

@Component
public class ContactusDao {
	private JdbcTemplate jdbcTemplate;
	public ContactusDao() {
		DriverManagerDataSource dataSource=new  DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bookstore?serverTimezone=GMT");
		dataSource.setUsername("root");
		dataSource.setPassword("amnay.mou2002");
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public List<Contactus> getallContact(){
		String sql="select * from contactus";
		List<Contactus> contact=jdbcTemplate.query(sql, new ContactusMapper());
		return contact;
	}
	public int addaMessage(Contactus c) {
		String sql="insert into contactus(username, problem, message) values(?, ?, ?)";
		Object params[] = {c.getUsername(), c.getProblem(), c.getMessage()};
		return jdbcTemplate.update(sql, params);
	}
	public int deletemssgId(int id) {
		String sql="delete from contactus where num=?";
		Object params[]= {id};
		return jdbcTemplate.update(sql,params);
	}
}
