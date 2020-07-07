package com.example.handler;

public class BasicChecker {
	
	public boolean isAlphanumberic(String string) {
		String regex = "[a-zA-Z0-9]+$";
		return string.matches(regex);
	}
	
	public boolean isKanji(String string) {
		String regex = "[\\u4e00-\\u9fff]+$";
		return string.matches(regex);
	}
	
	public boolean isKatakana(String string) {
		String regex = "[\\u30A0-\\u30FF]+$";
		return string.matches(regex);
	}
	
	public boolean isNumber(String string) {
		String regex = "[0-9]+$";
		return string.matches(regex);
	}
}
