package edu.bu.met.cs665.distribution;

import edu.bu.met.cs665.syndicate.Store;

public class Driver implements DriverBase {

  private String name;

  private Store store;

  private String deliveryRequest;

  public Driver(String name, Store store) {
    this.name = name;
    this.store = store;
    this.deliveryRequest = ""; // initially no request
    this.store.subscribe(this); // listen for delivery request
  }

  @Override
  public void updateSelf(String message) {
    this.deliveryRequest = message;

    System.out.println("10-4 Dispatch. Delivery request was received by "
        + "driver " + this.getName() + ": " + getDeliveryRequest().toUpperCase());
  }

  public String getName() {
    return this.name;
  }

  public String getDeliveryRequest() {
    return this.deliveryRequest;
  }
}
