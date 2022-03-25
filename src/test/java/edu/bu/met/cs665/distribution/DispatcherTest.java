package edu.bu.met.cs665.distribution;

import edu.bu.met.cs665.syndicate.Store;
import org.junit.Assert;
import org.junit.Test;

/**
 * The purpose of this class is to test the non-trivial functions of the
 * Dispatcher class.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class DispatcherTest {

  // Constructor
  public DispatcherTest() {}

  /**
   * Test that the Dispatcher selects a Driver.
   */
  @Test
  public void TestDispatcherSelectsDriver() {
    Store costco = new Store("costco");
    int driversOnDuty = 20;
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, costco); // drivers listening for costco orders
    }
    Dispatcher dispatcher = new Dispatcher(costco, costco.getDriverList());
    int selectedDriver = dispatcher.dispatch();
    Assert.assertTrue(selectedDriver > -1 && selectedDriver < driversOnDuty);
  }

  /**
   * Test that the Dispatcher works from the requestor stores driver list.
   */
  @Test
  public void TestDispatcherHasProperDriverList() {
    Store homeDepot = new Store("home-depot");
    int driversOnDuty = 20;
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, homeDepot); // drivers listening for costco orders
    }
    Dispatcher dispatcher = new Dispatcher(homeDepot, homeDepot.getDriverList());
    Assert.assertTrue(dispatcher.getDriverList().equals(homeDepot.getDriverList()));
  }

  /**
   * Test the Dispatcher has the proper requestor store.
   */
  @Test
  public void TestDispatcherRequestorStore() {
    Store wegmans = new Store("wegmans");
    int driversOnDuty = 20;
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, wegmans); // drivers listening for costco orders
    }
    Dispatcher dispatcher = new Dispatcher(wegmans, wegmans.getDriverList());
    Assert.assertTrue(dispatcher.getRequestor().equals(wegmans));
  }

}