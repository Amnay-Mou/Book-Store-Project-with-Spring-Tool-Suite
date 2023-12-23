package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Book;

public class BookMapper implements RowMapper<Book>{

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Book b=new Book();
		b.setBookid(rs.getInt("bookid"));
		b.setBookname(rs.getString("bookname"));
		b.setAuthor(rs.getString("author"));
		b.setUpdate(rs.getDate("update"));
		b.setPic(rs.getString("pic"));
		b.setPrice(rs.getFloat("price"));
		b.setDetails(rs.getString("details"));
		b.setCategory(rs.getInt("category"));
		b.setComment(rs.getInt("Comment"));
		return b;
	}
}
