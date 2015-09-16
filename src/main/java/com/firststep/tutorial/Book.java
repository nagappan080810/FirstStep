package com.firststep.tutorial;
import java.util.*;
import java.text.*;
public class Book {
	private int bookId;
	private String bookName;
	private Date publishedDate;
	private String author;
	private double price;
	public Book(){}
	public Book(int bookId, String bookName, Date publishedDate, String author, double price){
		this.bookId = bookId;
		this.bookName = bookName;
		this.publishedDate = publishedDate;
		this.author = author;
		this.price = price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", publishedDate=" + publishedDate + ", author=" + author
				+ ", price=" + price + "]";
	}

}
