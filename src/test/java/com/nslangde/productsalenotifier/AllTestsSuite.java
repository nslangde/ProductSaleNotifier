/**
 * 
 */
package com.nslangde.productsalenotifier;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.nslangde.productsalenotifier.process.AllProcessMessageTests;
import com.nslangde.productsalenotifier.validator.AllValidateNotificationTests;

/**
 * 
 * All Test suite for Runner
 * 
 * @author nikhillangde
 *
 */
@RunWith(Suite.class)
@SuiteClasses({AllProcessMessageTests.class, AllValidateNotificationTests.class, })
public class AllTestsSuite {

}
