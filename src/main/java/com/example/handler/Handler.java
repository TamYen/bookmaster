package com.example.handler;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Handler {

	public java.sql.Date convertStringToSqlDate(String string) throws ParseException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		formatter.setLenient(false);
		java.util.Date utilDate = formatter.parse(string);
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
	
	public java.util.Date getCurentDate() {
		java.util.Date utilDate = new java.util.Date();
//	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    return utilDate;
	}

	public Date getSqlCurrentDate() {
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
	
}
