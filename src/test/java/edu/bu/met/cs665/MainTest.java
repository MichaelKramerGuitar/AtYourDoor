package edu.bu.met.cs665;

import edu.bu.met.cs665.distribution.Driver;
import edu.bu.met.cs665.syndicate.Store;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * The purpose of this class is to test the Main simulations operate as
 * expected.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class MainTest {

  // Constructor
  public MainTest() {}

  // To test output
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
   * Run simulation with Costco order.
   */
  @Test
  public void TestObserverPatternCostco() {
    String costcoOrder = "cleaning supplies, bottled water";

    // create a store
    Store costco = new Store("costco");

    // create 20 drivers for costco orders
    int driversOnDuty = 2;
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, costco);
    }
    // get a random costco order and assign a driver
    costco.setDeliveryRequest(costcoOrder);
    String expected = "COSTCO contacting Dispatcher to assign the following delivery request: " + costcoOrder.toUpperCase() + "\n" +
      "Copy COSTCO...Dispatcher assigning Driver #1. Driver confirm assignment...\n" +
      "10-4 Dispatch. Delivery request was received by driver Driver #1: " + costcoOrder.toUpperCase();
    Assert.assertEquals(
      expected.replaceAll("\n", "").replaceAll("\r", ""),
      outContent.toString().replaceAll("\n", "").replaceAll("\r", ""));
  }

  /**
   * Test simulation with WholeFoods order.
   */
  @Test
  public void TestObserverPatternWholeFoods() {
    String wholeFoodsOrder = "healthy expensive foods";

    // create a store
    Store wholeFoods = new Store("costco");

    // create 20 drivers for costco orders
    int driversOnDuty = 2;
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, wholeFoods);
    }
    // get a random costco order and assign a driver
    wholeFoods.setDeliveryRequest(wholeFoodsOrder);
    String expected = "COSTCO contacting Dispatcher to assign the following delivery request: " + wholeFoodsOrder.toUpperCase() + "\n" +
      "Copy COSTCO...Dispatcher assigning Driver #1. Driver confirm assignment...\n" +
      "10-4 Dispatch. Delivery request was received by driver Driver #1: " + wholeFoodsOrder.toUpperCase();
    Assert.assertEquals(
      expected.replaceAll("\n", "").replaceAll("\r", ""),
      outContent.toString().replaceAll("\n", "").replaceAll("\r", ""));
  }
}