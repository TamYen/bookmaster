package com.example.handler;

public class MessageInfo {
	public String showIdFoudMsg() {
		return "本が見つかりました。";
	}
	
	public String showIdNotFoundMsg(String idBook) {
		return "本ID" + idBook + "が見つかりません。";
	}
	
	public String showDbErrorMsg() {
		return "サーバー処理で例外が発生しました。";
	}
	
	public String showInvalidDateMsg() {
		return "出版年月日が不正です。";
	}
	
	public String showDeleteSuccessMsg(String idBook) {
		return "本ID"+ idBook +" を削除しました。";
	}
	
	public String showUpdateSuccessMsg() {
		return "本を更新しました。";
	}
	
	public String showAddSuccessMsg() {
		return "本を登録しました。";
	}
	
	public String showAddFailureMsg(String idBook) {
		return "本ID" + idBook + "は登録されています。別のIDを入力してください。";
	}

	public String showPubDateIsAfterCurrentDateMsg() {
		return "出版年月日は現在の日付より後です。";
	}
}
