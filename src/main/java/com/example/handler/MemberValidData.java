package com.example.handler;

import java.text.ParseException;

import com.example.web.form.MemberForm;

public class MemberValidData {
	BasicChecker checker = new BasicChecker();
	Handler handler = new Handler();
	MemberForm mem;
	String message = null;
	
	public String getMessage() {
		return message;
	}

//	final String ID_EMPTY = "会員ID を入力してください。";
//	final String ID_NOT_ANPHANUMBERIC = "会員IDは半角英数字で入力してください。";
//	final String FAMILY_NAME_EMPTY = "会員氏(漢字)を入力してください。";
//	final String FAMILY_NAME_NOT_KANJI = "会員氏(漢字)は漢字で入力してください。";

	public MemberValidData(MemberForm mem) {
		this.mem = mem;
	}
	
	public void checkData() {
		boolean idEmpty = mem.getMemberId().isEmpty();
		boolean idIsAlphanumberic = checker.isAlphanumberic(mem.getMemberId());
		
		boolean familyNameEmpty = mem.getFamilyName().isEmpty();
		boolean familyNameIsKanji = checker.isKanji(mem.getFamilyName());		
		boolean familyNameIsKana = checker.isKatakana(mem.getFamilyNameKana());
		boolean familyNameKanaEmpty = mem.getFamilyNameKana().isEmpty();
		
		boolean fisrtNameEmpty = mem.getFirstName().isEmpty();
		boolean fisrtNameIsKanji = checker.isKanji(mem.getFirstName());
		boolean fisrtNameKanaEmpty = mem.getFirstNameKana().isEmpty();
		boolean fisrtNameIsKana = checker.isKatakana(mem.getFirstNameKana());
		
		boolean addressEmpty = mem.getAddress().isEmpty();
		
		boolean birthYearEmpty = mem.getBirthYear().isEmpty();
		boolean birthYearIsNumber = checker.isNumber(mem.getBirthYear());
		
		boolean birthMonthEmpty = mem.getBirthMonth().isEmpty();
		boolean birthMonthIsNumber = checker.isNumber(mem.getBirthMonth());
		
		boolean birthDateEmpty = mem.getBirthDate().isEmpty();
		boolean birthDateIsNumber = checker.isNumber(mem.getBirthDate());
		
		if(idEmpty == true) {
			message = "会員IDを入力してください。";
		}else if(idIsAlphanumberic == false) {
			message = "会員IDは半角英数字で入力してください。";
		}else
		
		if(familyNameEmpty == true) {
			message = "会員氏(漢字)を入力してください。";
		}else if(familyNameIsKanji == false) {
			message = "会員氏(漢字)は漢字で入力してください。";
		}else
		
		if(familyNameKanaEmpty == true) {
			message = "会員氏(カナ)を入力してください。";
		}else if(familyNameIsKana == false) {
			message = "会員氏(カナ)はカナ字で入力してください。";
		}else
		
		if(fisrtNameEmpty == true) {
			message = "会員名(漢字)を入力してください。";
		}else if(fisrtNameIsKanji == false) {
			message = "会員氏(漢字)は漢字で入力してください。";
		}else
		
		if(fisrtNameKanaEmpty == true) {
			message = "会員名(カナ)を入力してください。";
		}else if(fisrtNameIsKana == false) {
			message = "会員名(カナ)はカナ字で入力してください。";
		}else
		
		if(addressEmpty == true) {
			message = "住所を入力してください。";
		}else
		
		if(birthYearEmpty == true) {
			message = "生年月日(年)を入力してください。";
		}else if(birthYearIsNumber == false) {
			message = "生年月日(年)は半角数字で入力してください。";
		}else if(birthMonthEmpty == true) {
			message = "生年月日(月)を入力してください。";
		}else if(birthMonthIsNumber == false) {
			message = "生年月日(月)は半角数字で入力してください。";
		}else if(birthDateEmpty == true) {
			message = "生年月日(日)を入力してください。";
		}else if(birthDateIsNumber == false) {
			message = "生年月日(日)は半角数字で入力してください。";
		}else {
			String birthday = mem.getBirthYear() + "-" + mem.getBirthMonth() + "-" + mem.getBirthDate();
			try {
				handler.convertStringToSqlDate(birthday);
			} catch (ParseException e) {
				message = "生年月日....";
			}
		}
		
		
	}
}
