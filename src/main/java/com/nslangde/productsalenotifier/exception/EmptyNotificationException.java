package com.nslangde.productsalenotifier.exception;


/**
 * 
 * An exception that defines empty notification message received
 * 
 * @author nikhillangde
 *
 */
public class EmptyNotificationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyNotificationException(String message) {
		super(message);
	}

}
