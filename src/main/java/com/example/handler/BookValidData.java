package com.example.handler;

import com.example.web.form.BookForm;

public class BookValidData {
	private String msg;
	BasicChecker checker = new BasicChecker();
	
	public String getMsg() {
		return msg;
	}

	public BookValidData(BookForm book) {
		if(book.getBookId().isEmpty()) {
			msg = "本IDを入力してください。";
		}else if(checker.isAlphanumberic(book.getBookId()) == false) {
			msg = "本IDは半角英数字で入力してください。";
		}else if(book.getBookTitle().isEmpty()) {
			msg = "本タイトルを入力してください。";
		}else if(book.getAuthorName().isEmpty()) {
			msg = "著者名を入力してください。";
		}else if(book.getPublisher().isEmpty()) {
			msg = "出版社を入力してください。";
		}else if(book.getPubYear().isEmpty()) {
			msg = "出版年月日(年)を入力してください。";
		}else if(checker.isNumber(book.getPubYear()) ==  false) {
			msg = "出版年月日(年)は半角数字で入力してください。";
		}else if(book.getPubMonth().isEmpty()) {
			msg = "出版年月日(月)を入力してください。";
		}else if(checker.isNumber(book.getPubMonth()) ==  false) {
			msg = "出版年月日(月)は半角数字で入力してください。";
		}else if(book.getPubDate().isEmpty()) {
			msg = "出版年月日(日)を入力してください。";
		}else if(checker.isNumber(book.getPubDate()) ==  false) {
			msg = "出版年月日(日)は半角数字で入力してください。";
		}
	}
}
