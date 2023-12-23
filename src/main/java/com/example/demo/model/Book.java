package com.example.demo.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Book {
			private Integer bookid;
			private String bookname;
			private String author;
			private Date update;
			private String pic;
			private float price;
			private String details;
			private Integer category;
			private Integer comment;
			
			public Integer getBookid() {
				return bookid;
			}
			public void setBookid(Integer bookid) {
				this.bookid = bookid;
			}
			public String getBookname() {
				return bookname;
			}
			public void setBookname(String bookname) {
				this.bookname = bookname;
			}
			public String getAuthor() {
				return author;
			}
			public void setAuthor(String author) {
				this.author = author;
			}
			public Date getUpdate() {
				return update;
			}
			public void setUpdate(Date update) {
				this.update = update;
			}
			public String getPic() {
				return pic;
			}
			public void setPic(String pic) {
				this.pic = pic;
			}
			public float getPrice() {
				return price;
			}
			public void setPrice(float price) {
				this.price = price;
			}
			public String getDetails() {
				return details;
			}
			public void setDetails(String details) {
				this.details = details;
			}
			public Integer getCategory() {
				return category;
			}
			public void setCategory(Integer category) {
				this.category = category;
			}
			public Integer getComment() {
				return comment;
			}
			public void setComment(Integer comment) {
				this.comment = comment;
			}
			

			@Override
			public String toString() {
				return "Book [bookid=" + bookid + ", bookname=" + bookname + ", Author=" + author + ", UpDate=" + update
						+ ", Pic=" + pic + ", Price=" + price + ", Details=" + details + ", category=" + category
						+ ", comment=" + comment + "]";
			}
}
