package edu.bu.met.cs665.distribution;

import edu.bu.met.cs665.syndicate.Store;

import java.util.ArrayList;

public class Dispatcher {

  private Store requestor;
  // Drivers implement Dispatcher
  private ArrayList<DriverBase> driverList = new ArrayList<>();

  public Dispatcher(Store store, ArrayList<DriverBase> driversList) {
    this.requestor = store;
    this.driverList = driversList;
  }

  public ArrayList<DriverBase> driverList() {
    return driverList;
  }

  public int dispatch() {
    int driver = (int) (Math.random() * (driverList.size() - 1) + 1);
    System.out.println("Copy " + requestor.getName().toUpperCase() + "..." +
                       "Dispatcher assigning Driver #" + driver
                       + ". Driver confirm assignment...");
    return driver;
  }

}
