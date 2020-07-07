package com.example.web.form;

public class MemberForm {
	private String memberId;
	private String familyName;
	private String familyNameKana;
	private String firstName;
	private String firstNameKana;
	private String address;
	private String birthYear;
	private String birthMonth;
	private String birthDate;
	
	public MemberForm() {
	}
	
	public MemberForm(String memberId, String familyName, String familyNameKana, String firstName, String firstNameKana,
			String address, String birthYear, String birthMonth, String birthDate) {
		this.memberId = memberId;
		this.familyName = familyName;
		this.familyNameKana = familyNameKana;
		this.firstName = firstName;
		this.firstNameKana = firstNameKana;
		this.address = address;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDate = birthDate;
	}
	
	public void setOnlyId() {
		this.familyName = null;
		this.familyNameKana = null;
		this.firstName = null;
		this.firstNameKana = null;
		this.address = null;
		this.birthYear = null;
		this.birthMonth = null;
		this.birthDate = null;
	}
	
	public MemberForm(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
}
