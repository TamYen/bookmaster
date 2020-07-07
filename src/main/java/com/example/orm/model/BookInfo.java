package com.example.orm.model;

public class BookInfo {
	
	private String bookId;
	private String bookTitle;
	private String authorName;
	private String publisher;
	private String publicationDay;
	private String insertDay;
	private String updateDay;
	
	public BookInfo(String bookId, String bookTitle, String authorName, String publisher, String publicationDay) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.publisher = publisher;
		this.publicationDay = publicationDay;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublicationDay() {
		return publicationDay;
	}
	public void setPublicationDay(String publicationDay) {
		this.publicationDay = publicationDay;
	}
	public String getInsertDay() {
		return insertDay;
	}
	public void setInsertDay(String insertDay) {
		this.insertDay = insertDay;
	}
	public String getUpdateDay() {
		return updateDay;
	}
	public void setUpdateDay(String updateDay) {
		this.updateDay = updateDay;
	}
	
}
