package com.nslangde.productsalenotifier.reporting;

import com.nslangde.productsalenotifier.common.Adjustment;
import com.nslangde.productsalenotifier.sale.memory.Memory;

/**
 * 
 * To generate adjustments report after every fiftieth message.
 * 
 * @author nikhillangde
 *
 */
public class AdjustmentsReport {

	/**
	 * 
	 * This method will print adjustments report in console.
	 * 
	 */
	public static void generateAdjustmentsReport() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("---------------------------Adjustments Details---------------------------");
		System.out.println("-------------------------------------------------------------------------");
		
		for (Adjustment adjustment: Memory.adjustmentsMemory) {
			
			System.out.println(adjustment);
		}
		
		System.out.println("-------------------------------------------------------------------------");
	}

}
