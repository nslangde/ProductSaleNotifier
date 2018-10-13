package com.nslangde.productsalenotifier.exception;

/**
 * 
 * An exception that defines invalid formatted notification message received
 * 
 * @author nikhillangde
 *
 */
public class NotificationNotSupportedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotificationNotSupportedException(String message) {
		super(message);
	}
}
