package edu.bu.met.cs665.syndicate;

import edu.bu.met.cs665.distribution.Driver;
import edu.bu.met.cs665.distribution.DriverBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * The purpose of this class is to test the non-trivial methods of the Store
 * class.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class StoreTest {

  // Constructor
  public StoreTest() {}

  // To test system output
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  /**
   * Test that drivers on duty are concrete subscribers in the Observer Pattern.
   */
  @Test
  public void TestSubscribeToStore() {
    Store costco = new Store("costco");
    int driversOnDuty = 20;
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, costco); // drivers listening for costco orders
    }
    Assert.assertTrue(
      costco.getDriverList().size() > -1 && costco.getDriverList().size() <= driversOnDuty);
    // get a random driver
    DriverBase randomDriver = costco.getDriverList().get((int) (Math.random() * (driversOnDuty - 1) + 1));
    // ensure that object matches one from the subscriber base
    Assert.assertTrue(costco.getDriverList().contains(randomDriver));
  }

  /**
   * Test Drivers can be unsubscribed.
   */
  @Test
  public void TestUnsubscribeToStore() {
    Store starbucks = new Store("starbucks");
    int driversOnDuty = 20;
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, starbucks); // drivers listening for starbucks orders
    }

    // get a random driver
    DriverBase randomDriver = starbucks.getDriverList().get((int) (Math.random() * (driversOnDuty - 1) + 1));
    // unsubscribe this driver from starbucks notifications
    starbucks.unsubscribe(randomDriver);
    // ensure that object removed from the subscriber base
    Assert.assertFalse(starbucks.getDriverList().contains(randomDriver));
  }

  /**
   * Test Store can appropriately notify the Dispatcher to assign a driver
   * to delivery an order/deliveryRequest.
   */
  @Test
  public void TestSetDeliveryAndNotifyDispatcher() {
    Store costco = new Store("costco");
    new Driver("Driver", costco); // driver listening for costco orders
    new Driver("Driver", costco); // driver listening for costco orders

    String expected = "COSTCO contacting Dispatcher to assign the following delivery request: GROCERIES, TV, WASHING MACHINE\r\n" +
      "Copy COSTCO...Dispatcher assigning Driver #1. Driver confirm assignment...\r\n" +
      "10-4 Dispatch. Delivery request was received by driver Driver: GROCERIES, TV, WASHING MACHINE\r\n";
    costco.setDeliveryRequest("groceries, tv, washing machine");
    Assert.assertEquals(
      expected.replaceAll("\n", "").replaceAll("\r", ""),
      outContent.toString().replaceAll("\n", "").replaceAll("\r", ""));
  }

  /**
   * Test that the delivery request is set properly.
   */
  @Test
  public void TestSetDeliveryRequest() {
    Store costco = new Store("costco");
    new Driver("Driver", costco); // driver listening for costco orders
    new Driver("Driver", costco); // driver listening for costco orders
    String deliveryRequest = "groceries, tv, washing machine";
    costco.setDeliveryRequest(deliveryRequest);
    Assert.assertEquals(deliveryRequest, costco.getDeliveryRequest());
  }
}