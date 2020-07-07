package com.example.web.form;

public class BookForm {
	private String bookId;
	private String bookTitle;
	private String authorName;
	private String publisher;
	private String pubYear;
	private String pubMonth;
	private String pubDate;
	
	public BookForm() {
		super();
	}
	
	public BookForm(String bookId, String bookTitle, String authorName, String publisher, String pubYear,
			String pubMonth, String pubDate) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.pubMonth = pubMonth;
		this.pubDate = pubDate;
	}
	
	public void setOnlyId() {
		this.bookTitle = null;
		this.authorName = null;
		this.publisher = null;
		this.pubYear = null;
		this.pubMonth = null;
		this.pubDate = null;
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
	public String getPubYear() {
		return pubYear;
	}
	public void setPubYear(String pubYear) {
		this.pubYear = pubYear;
	}
	public String getPubMonth() {
		return pubMonth;
	}
	public void setPubMonth(String pubMonth) {
		this.pubMonth = pubMonth;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
}
