/**
 * 
 */
package com.nslangde.productsalenotifier;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.nslangde.productsalenotifier.process.AllProcessMessageTests;
import com.nslangde.productsalenotifier.validator.AllValidateNotificationTests;

/**
 * 
 * To run all the test cases defined.
 * 
 * @author nikhillangde
 *
 */
public class TestRunner {

	private static Result result;

	public static void main(String[] args) {
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("----------------------------Validation Tests-----------------------------");
		
		result = JUnitCore.runClasses(AllValidateNotificationTests.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure for notification validation tests : " + failure.toString());
		}

		System.out.println("Result for all notification validation tests : " + result.wasSuccessful());
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("-------------------------Process Messages Tests--------------------------");
		
		result = JUnitCore.runClasses(AllProcessMessageTests.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Failure for notification Process Message tests : " + failure.toString());
		}

		System.out.println("Result for all notification Process Message tests : " + result.wasSuccessful());
		
		System.out.println("-------------------------------------------------------------------------");
	}
}
