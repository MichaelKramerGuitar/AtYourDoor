package edu.bu.met.cs665.distribution;

import edu.bu.met.cs665.syndicate.Store;

/**
 * The purpose of this class is to extend the SubscriberBase of the Observer Pattern
 * (The DriverBase Interface) with the concrete subscribers, the Drivers.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Driver implements DriverBase {

  private String name;

  private Store store;

  private String deliveryRequest;

  /**
   * Constructor.
   * @param name The Driver's name as a String.
   * @param store The Store object making the delivery request.
   */
  public Driver(String name, Store store) {
    this.name = name;
    this.store = store;
    this.deliveryRequest = ""; // initially no request
    this.store.subscribe(this); // listen for delivery request
  }

  /**
   * Satisfy the contract of the interface implemented.
   * @param message A String representing a delivery request.
   */
  public void updateSelf(String message) {
    this.deliveryRequest = message;

    System.out.println("10-4 Dispatch. Delivery request was received by "
        + "driver " + this.getName() + ": " + getDeliveryRequest().toUpperCase());
  }

  // Getters
  public String getName() {
    return this.name;
  }

  public String getDeliveryRequest() {
    return this.deliveryRequest;
  }

}
