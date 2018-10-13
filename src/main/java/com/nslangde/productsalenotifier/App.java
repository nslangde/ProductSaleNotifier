package com.nslangde.productsalenotifier;

import com.nslangde.productsalenotifier.common.Message;
import com.nslangde.productsalenotifier.exception.EmptyNotificationException;
import com.nslangde.productsalenotifier.exception.InvalidFormattedNotificationException;
import com.nslangde.productsalenotifier.exception.MaxNotificationReceived;
import com.nslangde.productsalenotifier.exception.NotificationNotSupportedException;
import com.nslangde.productsalenotifier.process.ProcessMessage;
import com.nslangde.productsalenotifier.validator.ValidateNotification;

/**
 * 
 * The ProductSaleNotifier program implements an application that can accept
 * sales notification, process, record and report total sale after every tenth
 * notification. This program will stop accepting new notification after fifty
 * notifications.
 * 
 * @author nikhillangde
 * @version 1.0
 * 
 */
public class App {

	/**
	 * 
	 * This is entry to ProductSaleNotifier program. This method accept sale
	 * notification message as a string in three formats.
	 * 
	 * Format 1 : $MSG_TYPE $PRODUCT $PRICE 
	 * Format 2 : $MSG_TYPE $PRODUCT $PRICE $QUANTITY 
	 * Format 3 : $MSG_TYPE $PRODUCT $ADJUSTMENT_TYPE $ADJUSTMENT_FACTOR
	 * 
	 * Where $MSG_TYPE can be TYPE1, TYPE2, TYPE3
	 * 
	 * @param message
	 * @return Nothing
	 * 
	 */
	public void processSaleNotification(String saleMessage) {

		try {

			// Validate message depending on its type
			Message message = ValidateNotification.validateTypeOfMessage(saleMessage);

			// Process message as per its type
			ProcessMessage.processMessageAsPerType(message);

		} catch (EmptyNotificationException | InvalidFormattedNotificationException | NotificationNotSupportedException ex) {

			// Log the message from Exception object
			System.out.println(ex.getMessage());
			
		} catch (MaxNotificationReceived e) {
			
			// Log notification processor is pausing, 
			// and stop accepting new messages 
			// and log a report of the adjustments recorded
			PauseAndStopAcceptingNotification.handleAfterMaxNotificationReceived();
			
		}

	}

	/**
	 * This is the main method which makes use of processSaleNotification method.
	 * 
	 * @param args Unused.
	 * @return Nothing.
	 * 
	 */
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"Spring-Module.xml");

		App app = new App();
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");

		app.processSaleNotification("TYPE3 APPLE ADD 20");

		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");

		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");

		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");

		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");

		app.processSaleNotification("TYPE1 PAPAYA 30");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");

		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");

		app.processSaleNotification("TYPE1 APPLE 20");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE1 PAPAYA 20");
		
		app.processSaleNotification("TYPE1 APPLE 20");
		
		app.processSaleNotification("TYPE3 PAPAYA MULTIPLY 2");

		app.processSaleNotification("TYPE2 APPLE 20 2");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE1 PAPAYA 20");
		
		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");
		
		app.processSaleNotification("TYPE1 APPLE 20");

		app.processSaleNotification("TYPE2 APPLE 20 2");

	}
}