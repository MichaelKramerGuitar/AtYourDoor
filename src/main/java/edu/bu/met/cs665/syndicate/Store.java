package edu.bu.met.cs665.syndicate;

import edu.bu.met.cs665.distribution.Dispatcher;
import edu.bu.met.cs665.distribution.DriverBase;
import java.util.ArrayList;

/**
 * The purpose of this class is to provide the concrete classes implementing the
 * PublisherBase of the Observer Pattern, the Store class.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Store implements SyndicateRequestor {

  private String name;

  private String deliveryRequest;

  // Drivers implement Dispatcher
  private ArrayList<DriverBase> driverList = new ArrayList<>();

  // Constructor
  public Store(String name) {
    this.name = name;
    this.deliveryRequest = "Please deliver this cargo.";
  }

  // Setters
  public void setDeliveryRequest(String deliveryRequest) {
    this.deliveryRequest = deliveryRequest;
    this.notifyDispatcher();
  }

  /**
   * The purpose of this method is to satisfy the contracted of the implemented
   * interface SyndicateRequestor.
   * @param o an object extending the DriverBase Interface form the distribution
   *          package
   */
  public void subscribe(DriverBase o) {
    this.driverList.add(o);
  }

  /**
   * The purpose of this method is to satisfy the contracted of the implemented
   * interface SyndicateRequestor.
   * @param o an object extending the DriverBase Interface form the distribution
   *          package
   */
  public void unsubscribe(DriverBase o) {
    this.driverList.remove(o);
  }

  /**
   * The purpose of this method is to satisfy the contracted of the implemented
   * interface SyndicateRequestor.
   */
  public void notifyDispatcher() {

    System.out.println(getName().toUpperCase() + " contacting Dispatcher to "
        + "assign the following delivery request: " + getDeliveryRequest().toUpperCase());
    Dispatcher dispatcher = new Dispatcher(this, driverList);
    int selectedDriver = dispatcher.dispatch();
    DriverBase driver = driverList.get(selectedDriver);
    driver.updateSelf(this.deliveryRequest);
  }

  // Getters
  public String getName() {
    return this.name;
  }

  public String getDeliveryRequest() {
    return this.deliveryRequest;
  }

  public ArrayList<DriverBase> getDriverList() {
    return this.driverList;
  }
}
