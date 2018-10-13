package com.nslangde.productsalenotifier.reporting;

import java.util.ArrayList;

import com.nslangde.productsalenotifier.common.Sale;
import com.nslangde.productsalenotifier.sale.memory.Memory;

/**
 * 
 * To generate sales report after every tenth message.
 * 
 * @author nikhillangde
 *
 */
public class SalesReport {

	/**
	 * 
	 * This method calculates total sales and total price of particular product
	 * from sales store and print the report in console.
	 * 
	 */
	public static void generateSalesReport() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("------------------------------Sales Details------------------------------");
		System.out.println("-------------------------------------------------------------------------");

		Memory.productSalesMemory
				.forEach((productType, sales) -> System.out.println("Product : " + productType + " with total sale : "
						+ computeTotalQuantity(sales) + " and total value : " + computeTotalPrice(sales) + "p."));

		System.out.println("-------------------------------------------------------------------------");
	}

	/**
	 * 
	 * This is to calculate total price of sale for particular product.
	 * 
	 * @param sales
	 * @return totalPrice
	 */
	private static int computeTotalPrice(ArrayList<Sale> sales) {

		int totalPrice = 0;

		for (Sale sale : sales) {
			totalPrice += sale.getPricePerProduct() * sale.getQuantity();
		}

		return totalPrice;
	}

	/**
	 * 
	 * This is to calculate total quantity of sale for particular product.
	 * 
	 * @param sales
	 * @return totalQuantity
	 */
	private static int computeTotalQuantity(ArrayList<Sale> sales) {

		int totalQuantity = 0;

		for (Sale sale : sales) {
			totalQuantity += sale.getQuantity();
		}

		return totalQuantity;
	}

}
