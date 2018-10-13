/**
 * 
 */
package com.nslangde.productsalenotifier.process;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
 * Test cases for sales adjustments.
 * 
 * @author nikhillangde
 *
 */
public class AdjustSaleTest {
	
	private Adjustment testAddAdjustment = new Adjustment(AdjustmentType.ADD, ProductType.APPLE, 20);
	private Adjustment testSubtractAdjustment = new Adjustment(AdjustmentType.SUBTRACT, ProductType.APPLE, 10);
	private Adjustment testMultiplyAdjustment = new Adjustment(AdjustmentType.MULTIPLY, ProductType.APPLE, 2);
	
	AdjustSale adjustSale = new AdjustSale();
	
	Map<ProductType, ArrayList<Sale>> expectedProductSalesMemory = null;
	
	/**
	 * 
	 * Reset Memory before each test
	 * And process few messages for adjustment tests
	 * 
	 * @throws MaxNotificationReceived 
	 * 
	 */
	@Before
	public void initTest() throws MaxNotificationReceived {
		//Reset memory to start test
		Memory.resetMemory();
		
		//Process test messages 
		ProcessMessage.processMessageAsPerType(new Message(MessageType.TYPE1, ProductType.APPLE, new Sale(ProductType.APPLE, 20, 1), null));
		ProcessMessage.processMessageAsPerType(new Message(MessageType.TYPE1, ProductType.PAPAYA, new Sale(ProductType.PAPAYA, 20, 2), null));
		ProcessMessage.processMessageAsPerType(new Message(MessageType.TYPE1, ProductType.APPLE, new Sale(ProductType.APPLE, 30, 2), null));
		
		//For adjustments test
		expectedProductSalesMemory = new HashMap<ProductType, ArrayList<Sale>>();
	}
	
	/**
	 * 
	 * Test memory for adjustments to add sales
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.process.AdjustSale#adjustSale(com.nslangde.productsalenotifier.common.Adjustment)}.
	 */
	@Test
	public void testAdjustSale_testAddAdjustment() {
		
		adjustSale.adjustSale(testAddAdjustment);
		
		//Test entry in adjustment memory
		assertEquals(1, Memory.adjustmentsMemory.size());
		
		//Test No change in Message and Sales Memory
		assertEquals(3, Memory.messagesMemory.size());
		assertEquals(3, Memory.saleMemory.size());
		assertEquals(2, Memory.productSalesMemory.size());
	
	}
	
	/**
	 * 
	 * Test memory for adjustments to subtract sales
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.process.AdjustSale#adjustSale(com.nslangde.productsalenotifier.common.Adjustment)}.
	 */
	@Test
	public void testAdjustSale_testSubtractAdjustment() {
		
		adjustSale.adjustSale(testSubtractAdjustment);
		
		//Test entry in adjustment memory
		assertEquals(1, Memory.adjustmentsMemory.size());
		
		//Test No change in Message and Sales Memory
		assertEquals(3, Memory.messagesMemory.size());
		assertEquals(3, Memory.saleMemory.size());
		assertEquals(2, Memory.productSalesMemory.size());
	
	}
	
	/**
	 * 
	 * Test memory for adjustments to multiply sales
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.process.AdjustSale#adjustSale(com.nslangde.productsalenotifier.common.Adjustment)}.
	 */
	@Test
	public void testAdjustSale_testMultiplyAdjustment() {
		
		adjustSale.adjustSale(testMultiplyAdjustment);
		
		//Test entry in adjustment memory
		assertEquals(1, Memory.adjustmentsMemory.size());
		
		//Test No change in Message and Sales Memory
		assertEquals(3, Memory.messagesMemory.size());
		assertEquals(3, Memory.saleMemory.size());
		assertEquals(2, Memory.productSalesMemory.size());
	
	}
	
	/**
	 * 
	 * Test total product sale after added adjustments
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.process.AdjustSale#adjustSale(com.nslangde.productsalenotifier.common.Adjustment)}.
	 */
	@Test
	public void testAdjustSale_testTotalSaleAddAdjustment() {
		
		adjustSale.adjustSale(testAddAdjustment);
		
		ArrayList<Sale> expectedProductAppleSale = new ArrayList<Sale>();
		expectedProductAppleSale.add(new Sale(ProductType.APPLE, 20 + 20, 1));
		expectedProductAppleSale.add(new Sale(ProductType.APPLE, 30 + 20, 2));
		
		ArrayList<Sale> expectedProductPapayaSale = new ArrayList<Sale>();
		expectedProductPapayaSale.add(new Sale(ProductType.PAPAYA, 20, 2));
		
		//Test entry in adjustment memory
		assertEquals(1, Memory.adjustmentsMemory.size());
		
		expectedProductSalesMemory.put(ProductType.APPLE, expectedProductAppleSale);
		expectedProductSalesMemory.put(ProductType.PAPAYA, expectedProductPapayaSale);
		
		assertEquals(expectedProductSalesMemory, Memory.productSalesMemory);
	
	}
	
	/**
	 * 
	 * Test total product sale after subtracted adjustments
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.process.AdjustSale#adjustSale(com.nslangde.productsalenotifier.common.Adjustment)}.
	 */
	@Test
	public void testAdjustSale_testTotalSaleSubtractAdjustment() {
		
		adjustSale.adjustSale(testSubtractAdjustment);
		
		ArrayList<Sale> expectedProductAppleSale = new ArrayList<Sale>();
		expectedProductAppleSale.add(new Sale(ProductType.APPLE, 20 - 10, 1));
		expectedProductAppleSale.add(new Sale(ProductType.APPLE, 30 - 10, 2));
		
		ArrayList<Sale> expectedProductPapayaSale = new ArrayList<Sale>();
		expectedProductPapayaSale.add(new Sale(ProductType.PAPAYA, 20, 2));
		
		//Test entry in adjustment memory
		assertEquals(1, Memory.adjustmentsMemory.size());
		
		expectedProductSalesMemory.put(ProductType.APPLE, expectedProductAppleSale);
		expectedProductSalesMemory.put(ProductType.PAPAYA, expectedProductPapayaSale);
		
		assertEquals(expectedProductSalesMemory, Memory.productSalesMemory);
	
	}
	
	/**
	 * 
	 * Test total product sale after multiplied adjustments
	 * 
	 * Test method for {@link com.nslangde.productsalenotifier.process.AdjustSale#adjustSale(com.nslangde.productsalenotifier.common.Adjustment)}.
	 */
	@Test
	public void testAdjustSale_testTotalSaleMultiplyAdjustment() {
		
		adjustSale.adjustSale(testMultiplyAdjustment);
		
		ArrayList<Sale> expectedProductAppleSale = new ArrayList<Sale>();
		expectedProductAppleSale.add(new Sale(ProductType.APPLE, 20 * 2, 1));
		expectedProductAppleSale.add(new Sale(ProductType.APPLE, 30 * 2, 2));
		
		ArrayList<Sale> expectedProductPapayaSale = new ArrayList<Sale>();
		expectedProductPapayaSale.add(new Sale(ProductType.PAPAYA, 20, 2));
		
		
		//Test entry in adjustment memory
		assertEquals(1, Memory.adjustmentsMemory.size());
		
		expectedProductSalesMemory.put(ProductType.APPLE, expectedProductAppleSale);
		expectedProductSalesMemory.put(ProductType.PAPAYA, expectedProductPapayaSale);
		
		assertEquals(expectedProductSalesMemory, Memory.productSalesMemory);
	
	}

}
