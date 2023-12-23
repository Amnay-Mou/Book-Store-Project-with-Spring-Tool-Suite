package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Contactus;

public class ContactusMapper implements RowMapper<Contactus>{

	@Override
	public Contactus mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Contactus contact = new Contactus();
		contact.setNum(arg0.getInt("num"));
		contact.setUsername(arg0.getString("username"));
		contact.setProblem(arg0.getString("problem"));
		contact.setMessage(arg0.getString("message"));
		return contact;
	}
	
}