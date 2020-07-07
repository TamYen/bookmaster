package com.example.secutity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String message = "";
		if(exception.getClass()==BadCredentialsException.class) {
			message = "管理者IDまたはパスワードが正しくありません。";
		}
		if(exception.getClass()==CannotConnectDBException.class) {
			message = "DBエラーが発生しました。";
		}
//		message = exception.getLocalizedMessage();
		String path = String.format("/login/failed?message=%s", message);
		request.getRequestDispatcher(path).forward(request, response);
	}
	
}
