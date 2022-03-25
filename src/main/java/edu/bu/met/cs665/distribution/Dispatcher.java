package edu.bu.met.cs665.distribution;

import edu.bu.met.cs665.syndicate.Store;
import java.util.ArrayList;

/**
 * The purpose of this class is to augment the observer pattern slightly by
 * filtering the "subscriber" base (the Driver class) per order just as a
 * dispatcher would pool available drivers (subscribers) and assign only
 * one.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Dispatcher {

  private Store requestor;
  // Drivers implement Dispatcher
  private ArrayList<DriverBase> driverList;

  // Constructor
  public Dispatcher(Store store, ArrayList<DriverBase> driversList) {
    this.requestor = store;
    this.driverList = driversList;
  }

  // getters
  public ArrayList<DriverBase> getDriverList() {
    return driverList;
  }

  /**
   * The purpose of this method is to pool the available drivers and assign a
   * driver to a particular order.
   * @return and int representing a driver id
   */
  public int dispatch() {
    int driver = (int) (Math.random() * (driverList.size() - 1) + 1);
    System.out.println("Copy " + requestor.getName().toUpperCase() + "..."
                       + "Dispatcher assigning Driver #" + driver
                       + ". Driver confirm assignment...");
    return driver;
  }

}
