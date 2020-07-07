package com.example.secutity;

import org.springframework.security.core.AuthenticationException;

public class CannotConnectDBException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4305880008290334906L;

	public CannotConnectDBException(String msg) {
		super(msg);
	}
	
	public CannotConnectDBException(String msg, Throwable t) {
		super(msg, t);
	}

}
