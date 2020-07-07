var idBook, titleBook, authorBook, publisherBook, yearBook, monthBook, dateBook;
var currentURL = window.location;

// msg
var msgIdEmpty = "本IDを入力してください。";
var msgTitleEmpty = "本タイトルを入力してください。";
var msgAuthorEmpty = "著者名を入力してください。";
var msgPublisherEmpty = "出版社を入力してください。";
var msgPublicationDateEmpty = "出版年月日を入力してください。";
var msgYearLength = "year invalid";

var msgIdNotAlphanumeric = "本IDは半角英数字で入力してください。";
var msgDateNaN = "出版年月日は半角数字で入力してください。";

function closeCurrentWindow(){
	window.close();
}

function btnClear(){
	document.getElementById("txtID").value = "";
	document.getElementById("txtTitle").value = "";
	document.getElementById("txtAuthor").value = "";
	document.getElementById("txtPublisher").value = "";
	document.getElementById("txtYear").value = "";
	document.getElementById("txtMonth").value = "";
	document.getElementById("txtDate").value = "";
}

function checkID(){
	var id = document.getElementById('txtID').value;
	if(getInput("txtID") == false)
		alert(msgIdEmpty);
	else{
		var regex = /^[a-z0-9]+$/;
		if(id.match(regex) == null)
			alert(msgIdNotAlphanumeric);
		else 
			idBook = id;
	}
}

function checkTitle(){
	if(getInput("txtTitle") == false)
		alert(msgTitleEmpty);
	else{
		titleBook = getInput("txtTitle");
	}
}
function checkAuthor(){
	if(getInput("txtAuthor") == false)
		alert(msgAuthorEmpty);
	else{
		authorBook = getInput("txtAuthor");
	}
}
function checkPublisher(){
	if(getInput("txtPublisher") == false)
		alert(msgPublisherEmpty);
	else{
		publisherBook = getInput("txtPublisher");
	}
}

function checkYear(){
	var year = document.getElementById("txtYear").value;
	if(getInput("txtYear") == false)
		alert(msgPublicationDateEmpty);
	else{
		var num = parseInt(year);
		if(num != year)
			alert(msgDateNaN);
		else if(validLength("txtYear", 4, 4) == false){
			alert(msgYearLength);
		}else{
			yearBook = getInput("txtYear");
		}
	}
}
function checkMonth(){
	var month = document.getElementById("txtMonth").value;
	if(getInput("txtMonth") == false)
		alert(msgPublicationDateEmpty);
	else{
		var num = parseInt(month);
		if(num != month)
			alert(msgDateNaN);
		else if(validLength("txtMonth", 2, 1) == false){
			alert(msgMonthLength);
		}else{
			monthBook = getInput("txtMonth");
		}
	}
}
function checkDate(){
	var month = document.getElementById("txtDate").value;
	if(getInput("txtDate") == false)
		alert(msgPublicationDateEmpty);
	else{
		var num = parseInt(month);
		if(num != month)
			alert(msgDateNaN);
		else if(validLength("txtDate", 2, 1) == false){
			alert(msgDateLength);
		}else{
			dateBook = getInput("txtDate");
		}
	}
}

function checkFullWidth(input){
    // alert(input.length);
    var isFullWidth = true;
    for (let i = 0; i < input.length; i++) {
        let code = input.charCodeAt(i);
        if ((code >= 0x0020 && code <= 0x1FFF) || (code >= 0xFF61 && code <= 0xFF9F)) { // half
            return isFullWidth = false;
        } else if ((code >= 0x2000 && code <= 0xFF60) || (code >= 0xFFA0)) { // full
            isFullWidth = true;
        } else {
            return isFullWidth = null;
        }
    }
    return isFullWidth;
}

function getInput(element){
	var text = document.getElementById(element).value;
	if(text == "")
		return false;
	return text;
}
function validLength(element, maxLength, minLength){
	var text = document.getElementById(element).value;
	var length = text.length;
	if(length > maxLength || length < minLength){
		document.getElementById(element).focus();
		return false;
	}
	return true;
}

function checkInputIsAlphanumeric(text){
	var regex = /^[a-z0-9A-Z]+$/;
	if(text.match(regex) == null)
		return false;
	return true;
}

function checkInputIsKanji(text){
	var regex = /^[\u4e00-\u9fff]+$/;
	if(text.match(regex) == null)
		return false;
	return true;
}

function checkInputIsKana(text){
	var regex = /^[\u30A0-\u30FF]+$/;
	if(text.match(regex) == null)
		return false;
	return true;
}

function checkInputIsNumber(text){
	var regex = /^[0-9]+$/;
	if(text.match(regex) == null)
		return false;
	return true;
}

function logout(){
	$.post('/logout');
}