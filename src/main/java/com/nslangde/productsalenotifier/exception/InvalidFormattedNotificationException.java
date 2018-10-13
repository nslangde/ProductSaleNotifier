package com.nslangde.productsalenotifier.exception;

/**
 * 
 * An exception that defines invalid formatted notification message received
 * 
 * @author nikhillangde
 *
 */
public class InvalidFormattedNotificationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFormattedNotificationException(String message) {
		super(message);
	}
}
