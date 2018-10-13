package com.nslangde.productsalenotifier;

import com.nslangde.productsalenotifier.reporting.AdjustmentsReport;

/**
 * 
 * To log that it is pausing and stop accepting new messages.
 * 
 * @author nikhillangde
 *
 */
public class PauseAndStopAcceptingNotification {

	private static final int EXIT_SUCCESS = 0;

	/**
	 * 
	 * This method is to Log notification processor is pausing, and stop accepting
	 * new messages and log a report of the adjustments recorded.
	 * 
	 */
	public static void handleAfterMaxNotificationReceived() {

		System.out.println("-------------------------------------------------------------------------");
		System.out.println("----------------------------Notifier stopping----------------------------");
		System.out.println("-------------------------------------------------------------------------");

		AdjustmentsReport.generateAdjustmentsReport();

		System.exit(EXIT_SUCCESS);
	}
}
