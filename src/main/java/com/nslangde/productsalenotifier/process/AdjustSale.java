package com.nslangde.productsalenotifier.process;

import java.util.ArrayList;

import com.nslangde.productsalenotifier.common.Adjustment;
import com.nslangde.productsalenotifier.common.Sale;
import com.nslangde.productsalenotifier.sale.memory.Memory;
import com.nslangde.productsalenotifier.type.ProductType;

/**
 * 
 * This is to make Adjustments on current sale.
 * 
 * @author nikhillangde
 *
 */
public class AdjustSale {

	private ArrayList<Sale> existingSales;

	/**
	 * 
	 * This is to adjust sales with adjustment type and factor.
	 * 
	 * @param adjustment
	 */
	public void adjustSale(Adjustment adjustment) {

		ProductType productType = adjustment.getProductType();

		existingSales = Memory.productSalesMemory.get(productType);

		if (null != existingSales) {

			ArrayList<Sale> updatedSales = new ArrayList<Sale>();

			switch (adjustment.getAdjustmentType()) {
			case ADD:
				addSale(updatedSales, adjustment.getAdjustmentFactor());
				break;
			case SUBTRACT:
				subtractSale(updatedSales, adjustment.getAdjustmentFactor());
				break;
			case MULTIPLY:
				multiplySale(updatedSales, adjustment.getAdjustmentFactor());
				break;
			}

			// Update Sales store with new sales details
			Memory.productSalesMemory.replace(productType, updatedSales);
		}

		// As adjustment completed add entry in adjustment store
		Memory.adjustmentsMemory.add(adjustment);

	}

	/**
	 * 
	 * This method is to update sale from store with addition of adjustments.
	 * 
	 * @param updatedSales
	 * @param adjustmentFactor
	 */
	private void addSale(ArrayList<Sale> updatedSales, int adjustmentFactor) {
		for (Sale sale : existingSales) {
			int currentPrice = sale.getPricePerProduct();
			sale.setPricePerProduct(currentPrice + adjustmentFactor);
			updatedSales.add(sale);
		}
	}

	/**
	 * 
	 * This method is to update sale from store with subtraction of adjustments.
	 * 
	 * @param updatedSales
	 * @param adjustmentFactor
	 */
	private void subtractSale(ArrayList<Sale> updatedSales, int adjustmentFactor) {
		for (Sale sale : existingSales) {
			int currentPrice = sale.getPricePerProduct();
			sale.setPricePerProduct(currentPrice - adjustmentFactor);
			updatedSales.add(sale);
		}
	}

	/**
	 * 
	 * This method is to update sale from store with multiplication of adjustments.
	 * 
	 * @param updatedSales
	 * @param adjustmentFactor
	 */
	private void multiplySale(ArrayList<Sale> updatedSales, int adjustmentFactor) {
		for (Sale sale : existingSales) {
			int currentPrice = sale.getPricePerProduct();
			sale.setPricePerProduct(currentPrice * adjustmentFactor);
			updatedSales.add(sale);
		}
	}
}
