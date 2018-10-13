package com.nslangde.productsalenotifier.process;

import java.util.ArrayList;

import com.nslangde.productsalenotifier.common.Message;
import com.nslangde.productsalenotifier.common.Sale;
import com.nslangde.productsalenotifier.exception.MaxNotificationReceived;
import com.nslangde.productsalenotifier.reporting.SalesReport;
import com.nslangde.productsalenotifier.sale.memory.Memory;
import com.nslangde.productsalenotifier.type.ProductType;

/**
 * 
 * Message processor.
 * 
 * @author nikhillangde
 *
 */
public class ProcessMessage {
	
	private static final int MAX_MESSAGES = 50;
	private static final int SALES_REPORT_COUNTER = 10;
	
	public static boolean processMessageAsPerType(Message message) throws MaxNotificationReceived {
		
		ProductType productType = message.getProductType();
		
		switch (message.getMsgType()) {
			//For Type 1 an Type 2 messages process is same as these differ only in quantity of sale
			case TYPE1:
			case TYPE2:
				// Add sale entry as Type 1 and 2 messages are sale messages
				Memory.saleMemory.add(message.getSale());
				
				//If product sale already recorded for this product in product sale, 
				//update product sale other wise add new product sale entry.
				if(Memory.productSalesMemory.containsKey(productType)) {
					ArrayList<Sale> existingSales = Memory.productSalesMemory.get(productType);
					existingSales.add(message.getSale());
					Memory.productSalesMemory.replace(productType, existingSales);
				} else {
					ArrayList<Sale> newSale = new ArrayList<Sale>();
					newSale.add(message.getSale());
					Memory.productSalesMemory.put(productType, newSale);
				}
				
				break;
			
			//For Type 3 messages adjust sales in Sales store
			case TYPE3:
				new AdjustSale().adjustSale(message.getAdjustment());
				break;
		}
		
		// Add entry in message store
		Memory.messagesMemory.add(message);
		
		if(Memory.messagesMemory.size() % SALES_REPORT_COUNTER == 0) {
			
			// Sales report after every tenth message
			SalesReport.generateSalesReport();

			if (Memory.messagesMemory.size() == MAX_MESSAGES) {
				throw new MaxNotificationReceived("Received " + MAX_MESSAGES + " messages. Stop notifier.");
			}
		}
		return true;
	}
	
}
