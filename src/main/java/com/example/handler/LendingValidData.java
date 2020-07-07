package com.example.handler;

public class LendingValidData {
	
	BasicChecker checker = new BasicChecker();
	String msg = null;
	
	public String getMsg() {
		return this.msg;
	}
	
	public LendingValidData(String bookId) {
		checkBookId(bookId);
	}
	
	public LendingValidData(String bookId, String memberId) {
		checkBookIdAndMemberId(bookId, memberId);
	}
	
	public void checkBookId(String bookId) {
		if(bookId.isEmpty()) {
			msg = "本ID を入力してください。";
		}else if(checker.isAlphanumberic(bookId) == false) {
			msg = "本IDは半角英数字で入力してください。";
		}
	}
	
	public void checkBookIdAndMemberId(String bookId, String memberId) {
		if(bookId.isEmpty()) {
			msg = "本ID を入力してください。";
		}else if(checker.isAlphanumberic(bookId) == false) {
			msg = "本IDは半角英数字で入力してください。";
		}else if(memberId.isEmpty()) {
			msg = "会員ID を入力してください。";
		}else if(checker.isAlphanumberic(memberId) == false) {
			msg = "会員IDは半角英数字で入力してください。";
		}
	}
}
