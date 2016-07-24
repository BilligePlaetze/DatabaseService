package com.tagcloud.persistence.exception;

/**
 * Exception for unsupported requests.
 * 
 * @author kkalmus
 */
public class UnsupportedRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnsupportedRequestException(String exceptionCode) {
		super(exceptionCode);
	}
	
}