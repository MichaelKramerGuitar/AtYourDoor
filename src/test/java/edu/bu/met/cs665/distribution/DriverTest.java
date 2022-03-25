package edu.bu.met.cs665.distribution;

import edu.bu.met.cs665.syndicate.Store;
import org.junit.Assert;
import org.junit.Test;

/**
 * The purpose of this class is to test the non-trivial methods of the
 * Driver class.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class DriverTest {

  // Constructor
  public DriverTest() {}

  /**
   * Test the Driver is instantiated properly.
   */
  @Test
  public void TestDriverConstructor() {
    Store costco = new Store("costco");
    new Driver("Driver #0", costco);
    String defaultName = "Driver #1";
    Driver defaultDriver = new Driver(defaultName, costco);
    Assert.assertEquals(defaultName, defaultDriver.getName());


  }

  /**
   * Test the Driver receives the delivery request.
   */
  @Test
  public void TestDriverReceivesDeliveryRequest() {
    Store costco = new Store("costco");
    new Driver("Driver #0", costco);
    /*
    because of how the dispatcher works, element 0 in the driverList will
    never be chosen. We can count on element 1 when there are only two drivers in list
     */
    Driver defaultDriver = new Driver("Driver #1", costco);
    String defaultRequest = costco.getDeliveryRequest();
    costco.notifyDispatcher();
    Assert.assertEquals(defaultRequest, defaultDriver.getDeliveryRequest());
  }

}