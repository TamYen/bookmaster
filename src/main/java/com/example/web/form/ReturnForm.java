package com.example.web.form;

import java.util.List;

public class ReturnForm {
	private String memberId;
	private List<BookForm> books;
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public List<BookForm> getBooks() {
		return books;
	}

	public void setBooks(List<BookForm> books) {
		this.books = books;
	}
}
