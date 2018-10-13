/**
 * 
 */
package com.nslangde.productsalenotifier.exception;

/**
 * 
 * An exception that defines maximum number of notification messages received
 * 
 * @author nikhillangde
 *
 */
public class MaxNotificationReceived extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaxNotificationReceived(String message) {
		super(message);
	}
}
