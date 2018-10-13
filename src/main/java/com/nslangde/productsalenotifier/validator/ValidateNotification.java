package com.nslangde.productsalenotifier.validator;

import com.nslangde.productsalenotifier.common.Adjustment;
import com.nslangde.productsalenotifier.common.Message;
import com.nslangde.productsalenotifier.common.Sale;
import com.nslangde.productsalenotifier.exception.EmptyNotificationException;
import com.nslangde.productsalenotifier.exception.InvalidFormattedNotificationException;
import com.nslangde.productsalenotifier.exception.NotificationNotSupportedException;
import com.nslangde.productsalenotifier.type.AdjustmentType;
import com.nslangde.productsalenotifier.type.MessageType;
import com.nslangde.productsalenotifier.type.ProductType;

/**
 * @author nikhillangde
 *
 */
public class ValidateNotification {

	/**
	 * 
	 * This method will validate the message and convert it to Message object on
	 * successful validation.
	 * 
	 * @param saleMessage
	 * @return Message
	 * @throws EmptyNotificationException
	 * @throws InvalidFormattedNotificationException
	 * @throws NotificationNotSupportedException
	 */
	public static Message validateTypeOfMessage(String saleMessage) throws EmptyNotificationException,
			InvalidFormattedNotificationException, NotificationNotSupportedException {

		Message message;

		if (saleMessage != null && !saleMessage.trim().isEmpty()) {
			if (saleMessage.startsWith(MessageType.TYPE1.toString() + " ")) {
				message = new ValidateNotification().formatType1Message(saleMessage);
			} else if (saleMessage.startsWith(MessageType.TYPE2.toString() + " ")) {
				message = new ValidateNotification().formatType2Message(saleMessage);
			} else if (saleMessage.startsWith(MessageType.TYPE3.toString() + " ")) {
				message = new ValidateNotification().formatType3Message(saleMessage);
			} else {
				throw new NotificationNotSupportedException("This type of notification is not yet supported.");
			}

		} else {
			throw new EmptyNotificationException("Empty notification received.");
		}

		return message;

	}

	/**
	 * 
	 * Validate and format message for type 1 notification.
	 * 
	 * Format 1 : $MSG_TYPE $PRODUCT $PRICE
	 * 
	 * @param saleMessage
	 * @return Message
	 * @throws InvalidFormattedNotificationException
	 */
	private Message formatType1Message(String saleMessage) throws InvalidFormattedNotificationException {

		String[] messages = splitMessageWithSpace(saleMessage);

		InvalidFormattedNotificationException exception = new InvalidFormattedNotificationException(
				"Type1 message not properly formatted.");

		if (messages.length == 3) {
			try {

				int price = Integer.parseInt(messages[2]);

				Sale sale = new Sale(ProductType.valueOf(messages[1]), price, 1);

				return new Message(MessageType.TYPE1, ProductType.valueOf(messages[1]), sale, null);

			} catch (IllegalArgumentException e) {
				throw exception;
			}
		} else {
			throw exception;
		}

	}

	/**
	 * 
	 * Validate and format message for type 2 notification.
	 * 
	 * Format 2 : $MSG_TYPE $PRODUCT $PRICE $QUANTITY
	 * 
	 * @param saleMessage
	 * @return Message
	 * @throws InvalidFormattedNotificationException
	 */
	private Message formatType2Message(String saleMessage) throws InvalidFormattedNotificationException {

		String[] messages = splitMessageWithSpace(saleMessage);

		InvalidFormattedNotificationException exception = new InvalidFormattedNotificationException(
				"Type2 message not properly formatted.");

		if (messages.length == 4) {
			try {

				int price = Integer.parseInt(messages[2]);

				int quantity = Integer.parseInt(messages[3]);

				Sale sale = new Sale(ProductType.valueOf(messages[1]), price, quantity);

				return new Message(MessageType.TYPE2, ProductType.valueOf(messages[1]), sale, null);

			} catch (IllegalArgumentException e) {
				throw exception;
			}
		} else {
			throw exception;
		}

	}

	/**
	 * 
	 * Validate and format message for type 3 notification.
	 * 
	 * Format 3 : $MSG_TYPE $PRODUCT $ADJUSTMENT_TYPE $ADJUSTMENT_FACTOR
	 * 
	 * @param saleMessage
	 * @return Message
	 * @throws InvalidFormattedNotificationException
	 */
	private Message formatType3Message(String saleMessage) throws InvalidFormattedNotificationException {

		String[] messages = splitMessageWithSpace(saleMessage);

		InvalidFormattedNotificationException exception = new InvalidFormattedNotificationException(
				"Type3 message not properly formatted.");

		if (messages.length == 4) {
			try {
				
				int adjustmentFactor = Integer.parseInt(messages[3]);

				Adjustment adjustment = new Adjustment(AdjustmentType.valueOf(messages[2]),
						ProductType.valueOf(messages[1]), adjustmentFactor);

				return new Message(MessageType.TYPE3, ProductType.valueOf(messages[1]), null, adjustment);
			
			} catch (IllegalArgumentException e) {
				throw exception;
			}
		} else {
			throw exception;
		}

	}

	/**
	 * 
	 * This method is to split notification message with space as delimiter.
	 * 
	 * @param saleMessage
	 * @return
	 */
	private String[] splitMessageWithSpace(String line) {
		return line.split(" ");
	}

}
