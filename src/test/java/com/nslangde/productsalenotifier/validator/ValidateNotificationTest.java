/**
 * 
 */
package com.nslangde.productsalenotifier.validator;

import static org.junit.Assert.*;

import org.junit.Test;

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
 * 
 * Test cases for Validation of messages and their formats.
 * 
 * @author nikhillangde
 *
 */
public class ValidateNotificationTest {

	private String type1PositiveMessage = "TYPE1 APPLE 20";
	private String type2PositiveMessage = "TYPE2 APPLE 20 2";
	private String type3PositiveMessage = "TYPE3 APPLE ADD 20";
	
	private String unsupportedNotificationFormatMessage1 = "TYPE4 APPLE ADD 20";
	private String unsupportedNotificationFormatMessage2 = "ABCD APPLE ADD 20";
	
	private String type1NegativeMessageExtraParameter = "TYPE1 APPLE 20 2";
	private String type1NegativeMessageLessParameter = "TYPE1 APPLE";
	private String type1NegativeMessageInvalidPriceParameter = "TYPE1 APPLE AA";
	private String type1NegativeMessageInvalidProductParameter = "TYPE1 AA 20";
	
	private String type2NegativeMessageExtraParameter = "TYPE2 APPLE 20 2 2";
	private String type2NegativeMessageLessParameter = "TYPE2 APPLE 20";
	private String type2NegativeMessageInvalidPriceParameter = "TYPE2 APPLE AA 2";
	private String type2NegativeMessageInvalidProductParameter = "TYPE1 AA 20 2";
	private String type2NegativeMessageInvalidQuantityParameter = "TYPE1 APPLE 20 A";
	
	private String type3NegativeMessageExtraParameter = "TYPE3 APPLE ADD 20 2";
	private String type3NegativeMessageLessParameter = "TYPE3 APPLE ADD";
	private String type3NegativeMessageInvalidProductParameter = "TYPE3 AA ADD 20";
	private String type3NegativeMessageInvalidAdjustmentTypeParameter = "TYPE3 APPLE DIVIDE 20";
	private String type3NegativeMessageInvalidAdjustmentFactorParameter = "TYPE3 APPLE ADD AA";
	
	private Message actualMesssage;
	private Message testType1PositiveMessage = new Message(MessageType.TYPE1, ProductType.APPLE, new Sale(ProductType.APPLE, 20, 1), null);
	private Message testType2PositiveMessage = new Message(MessageType.TYPE2, ProductType.APPLE, new Sale(ProductType.APPLE, 20, 2), null);
	private Message testType3PositiveMessage = new Message(MessageType.TYPE3, ProductType.APPLE, null, 
			new Adjustment(AdjustmentType.ADD, ProductType.APPLE, 20));
	
	/**
	 * 
	 * Negative test for Empty message
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = EmptyNotificationException.class)
	public void testValidateTypeOfMessage_EmptyNotification() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		ValidateNotification.validateTypeOfMessage("");
		
	}
	
	/**
	 * 
	 * Positive test case for Type 1 Message
	 * Format 1 : $MSG_TYPE $PRODUCT $PRICE
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test
	public void testValidateTypeOfMessage_successApproachType1Message() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type1PositiveMessage);
		
		assertNotNull(actualMesssage);
		
		assertEquals(testType1PositiveMessage, actualMesssage);
	}
	
	/**
	 * 
	 * Positive test case for Type 2 Message
	 * Format 2 : $MSG_TYPE $PRODUCT $PRICE $QUANTITY
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test
	public void testValidateTypeOfMessage_successApproachType2Message() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type2PositiveMessage);
		
		assertNotNull(actualMesssage);
		
		assertEquals(testType2PositiveMessage, actualMesssage);
	}
	
	/**
	 * 
	 * Positive test case for Type 3 Message
	 * Format 3 : $MSG_TYPE $PRODUCT $ADJUSTMENT_TYPE $ADJUSTMENT_FACTOR
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test
	public void testValidateTypeOfMessage_successApproachType3Message() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type3PositiveMessage);
		
		assertNotNull(actualMesssage);
		
		assertEquals(testType3PositiveMessage, actualMesssage);
	}

	/**
	 * 
	 * Negative test for unsupported Notification Message Test 1
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = NotificationNotSupportedException.class)
	public void testValidateTypeOfMessage_unsupportedNotificationFormatMessage1() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(unsupportedNotificationFormatMessage1);
		
	}
	
	/**
	 * 
	 * Negative test for unsupported Notification Message Test 2
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = NotificationNotSupportedException.class)
	public void testValidateTypeOfMessage_unsupportedNotificationFormatMessage2() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(unsupportedNotificationFormatMessage2);
		
	}
	
	/**
	 * 
	 * Negative test for Type 1 notification with extra parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type1NegativeMessageExtraParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type1NegativeMessageExtraParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 1 notification with less parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type1NegativeMessageLessParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type1NegativeMessageLessParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 1 notification with invalid price parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type1NegativeMessageInvalidPriceParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type1NegativeMessageInvalidPriceParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 1 notification with invalid product parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type1NegativeMessageInvalidProductParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type1NegativeMessageInvalidProductParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 2 notification with with extra parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type2NegativeMessageExtraParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type2NegativeMessageExtraParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 2 notification with with less parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type2NegativeMessageLessParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type2NegativeMessageLessParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 2 notification with invalid price parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type2NegativeMessageInvalidPriceParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type2NegativeMessageInvalidPriceParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 2 notification with invalid product parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type2NegativeMessageInvalidProductParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type2NegativeMessageInvalidProductParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 2 notification with invalid quantity parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type2NegativeMessageInvalidQuantityParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type2NegativeMessageInvalidQuantityParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 3 notification with with extra parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type3NegativeMessageExtraParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type3NegativeMessageExtraParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 3 notification with with less parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type3NegativeMessageLessParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type3NegativeMessageLessParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 3 notification with invalid product parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type3NegativeMessageInvalidProductParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type3NegativeMessageInvalidProductParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 3 notification with invalid adjustment type parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type3NegativeMessageInvalidAdjustmentTypeParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type3NegativeMessageInvalidAdjustmentTypeParameter);
		
	}
	
	/**
	 * 
	 * Negative test for Type 3 notification with invalid adjustment factor parameter
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.validator.ValidateNotification#validateTypeOfMessage(java.lang.String)}.
	 * @throws NotificationNotSupportedException 
	 * @throws InvalidFormattedNotificationException 
	 * @throws EmptyNotificationException 
	 */
	@Test(expected = InvalidFormattedNotificationException.class)
	public void testValidateTypeOfMessage_type3NegativeMessageInvalidAdjustmentFactorParameter() throws EmptyNotificationException, InvalidFormattedNotificationException, NotificationNotSupportedException {
		
		actualMesssage = ValidateNotification.validateTypeOfMessage(type3NegativeMessageInvalidAdjustmentFactorParameter);
		
	}
}
