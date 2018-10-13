/**
 * 
 */
package com.nslangde.productsalenotifier.process;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.nslangde.productsalenotifier.common.Adjustment;
import com.nslangde.productsalenotifier.common.Message;
import com.nslangde.productsalenotifier.common.Sale;
import com.nslangde.productsalenotifier.exception.MaxNotificationReceived;
import com.nslangde.productsalenotifier.sale.memory.Memory;
import com.nslangde.productsalenotifier.type.AdjustmentType;
import com.nslangde.productsalenotifier.type.MessageType;
import com.nslangde.productsalenotifier.type.ProductType;

/**
 * 
 * Test cases for message processing
 * 
 * @author nikhillangde
 *
 */
public class ProcessMessageTest {

	
	private Sale testSaleWithOutQuantity = new Sale(ProductType.APPLE, 20, 1);
	private Sale testSaleWithQuantity = new Sale(ProductType.APPLE, 20, 2);
	
	private Message testType1PositiveMessage = new Message(MessageType.TYPE1, ProductType.APPLE, testSaleWithOutQuantity, null);
	private Message testType2PositiveMessage = new Message(MessageType.TYPE2, ProductType.APPLE, testSaleWithQuantity, null);
	private Message testType3PositiveMessage = new Message(MessageType.TYPE3, ProductType.APPLE, null,
			new Adjustment(AdjustmentType.ADD, ProductType.APPLE, 20));

	/**
	 * 
	 * Reset Memory before each test
	 * 
	 */
	@Before
	public void initTest() {
		//Reset memory to start test
		Memory.resetMemory();
	}
	
	/**
	 * 
	 * Positive test case for Type 1 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type1PositiveMessage() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType1PositiveMessage));
	}

	/**
	 * 
	 * Positive test case for Type 2 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type2PositiveMessage() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType2PositiveMessage));
	}

	/**
	 * 
	 * Positive test case for Type 3 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type3PositiveMessage() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType3PositiveMessage));
	}

	/**
	 * 
	 * Test case for entry in Message memory for Type 1 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type1EntryInMessagesMemory() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType1PositiveMessage));

		assertEquals(1, Memory.messagesMemory.size());
	}

	/**
	 * 
	 * Test case for entry in Message memory for Type 2 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type2EntryInMessagesMemory() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType2PositiveMessage));

		assertEquals(1, Memory.messagesMemory.size());
	}

	/**
	 * 
	 * Test case for entry in Message memory for Type 3 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type3EntryInMessagesMemory() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType3PositiveMessage));

		assertEquals(1, Memory.messagesMemory.size());
	}
	
	/**
	 * 
	 * Test case for entry in sales memory for Type 1 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type1MessageEntryInSalesMemory() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType1PositiveMessage));

		assertEquals(1, Memory.messagesMemory.size());

		assertEquals(1, Memory.saleMemory.size());
	}

	/**
	 * 
	 * Test case for entry in sales memory for Type 2 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type2MessageEntryInSalesMemory() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType2PositiveMessage));

		assertEquals(1, Memory.messagesMemory.size());

		assertEquals(1, Memory.saleMemory.size());
	}
	
	/**
	 * 
	 * Test case for entry in product sales memory for Type 3 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type3MessageEntryInSalesMemory() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType3PositiveMessage));

		assertEquals(1, Memory.messagesMemory.size());

		assertEquals(0, Memory.saleMemory.size());
	}

	/**
	 * 
	 * Test case for entry in product sales memory for Type 1 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type1MessageEntryInProductSalesMemory() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType1PositiveMessage));

		assertEquals(1, Memory.messagesMemory.size());
		
		assertEquals(1, Memory.saleMemory.size());

		assertEquals(1, Memory.productSalesMemory.size());
	}

	/**
	 * 
	 * Test case for entry in product sales memory for Type 2 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type2MessageEntryInProductSalesMemory() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType2PositiveMessage));

		assertEquals(1, Memory.messagesMemory.size());
		
		assertEquals(1, Memory.saleMemory.size());

		assertEquals(1, Memory.productSalesMemory.size());
	}
	
	/**
	 * 
	 * Test case for entry in product sales memory for Type 3 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_type3MessageEntryInProductSalesMemory() throws MaxNotificationReceived {
		assertTrue(ProcessMessage.processMessageAsPerType(testType3PositiveMessage));

		assertEquals(1, Memory.messagesMemory.size());
		
		assertEquals(0, Memory.saleMemory.size());

		assertEquals(0, Memory.productSalesMemory.size());
	}

	/**
	 * 
	 * Test case for entry in adjustments memory for Type 3 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test
	public void testProcessMessageAsPerType_testRandomLessThan50MessageEntryInMemory() throws MaxNotificationReceived {
		int entriesToProcess = new Random().nextInt(50) + 1;

		int adjustmentsCount = processRandomNumberOfNotifications(entriesToProcess);

		assertEquals(entriesToProcess, Memory.messagesMemory.size());

		assertEquals(adjustmentsCount, Memory.adjustmentsMemory.size());
	}

	/**
	 * 
	 * Test case for entry in adjustments memory for Type 3 Message
	 * 
	 * Test method for
	 * {@link com.nslangde.productsalenotifier.process.ProcessMessage#processMessageAsPerType(com.nslangde.productsalenotifier.common.Message)}.
	 * 
	 * @throws MaxNotificationReceived
	 */
	@Test(expected = MaxNotificationReceived.class)
	public void testProcessMessageAsPerType_testRandomMoreThan50MessageEntryInMemory() throws MaxNotificationReceived {
		int entriesToProcess = new Random().nextInt(60 - 50) + 50;

		int adjustmentsCount = processRandomNumberOfNotifications(entriesToProcess);

		assertEquals(entriesToProcess, Memory.messagesMemory.size());

		assertEquals(adjustmentsCount, Memory.adjustmentsMemory.size());
	}

	/**
	 * 
	 * This will process multiple number of notification
	 * 
	 * @param entriesToProcess
	 * @return adjustmentsCount
	 * @throws MaxNotificationReceived 
	 */
	private int processRandomNumberOfNotifications(int entriesToProcess) throws MaxNotificationReceived {

		int adjustmentsCount = 0;

		for (int i = 1; i <= entriesToProcess; i++) {

			int randomTypeOfMessage = new Random().nextInt(3) + 1;

			switch (randomTypeOfMessage) {
			case 1:
				ProcessMessage.processMessageAsPerType(testType1PositiveMessage);
				break;
			case 2:
				ProcessMessage.processMessageAsPerType(testType2PositiveMessage);
				break;
			case 3:
				ProcessMessage.processMessageAsPerType(testType3PositiveMessage);
				adjustmentsCount++;
				break;

			}

		}

		return adjustmentsCount;
	}

}
