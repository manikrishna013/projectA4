package com.developers.projectA4.Exception;

public class DuplicateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicateException(String message){
		super(String.format(message+ "already Exists"));
	}
	

}
