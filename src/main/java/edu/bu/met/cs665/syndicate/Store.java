package edu.bu.met.cs665.syndicate;

import edu.bu.met.cs665.distribution.Dispatcher;
import edu.bu.met.cs665.distribution.Driver;
import edu.bu.met.cs665.distribution.DriverBase;

import java.util.ArrayList;

public class Store implements SyndicateRequestor {

  private String name;

  private String deliveryRequest;

  // Drivers implement Dispatcher
  private ArrayList<DriverBase> driverList = new ArrayList<>();

  public Store(String name) {
    this.name = name;
    this.deliveryRequest = "Please deliver this cargo.";
  }

  public void setDeliveryRequest(String deliveryRequest) {
    this.deliveryRequest = deliveryRequest;
    this.notifyDispatcher();
  }


  public void subscribe(DriverBase o) {
    this.driverList.add(o);
  }

  public void unsubscribe(DriverBase o) {
    this.driverList.remove(o);
  }

  public String getName() {
    return this.name;
  }

  public String getDeliveryRequest() {
    return this.deliveryRequest;
  }
  public void notifyDispatcher() {

    System.out.println(getName().toUpperCase() + " contacting Dispatcher to "
                       + "assign the following delivery request: " + getDeliveryRequest().toUpperCase());
    Dispatcher dispatcher = new Dispatcher(this, driverList);
    int selected_driver = dispatcher.dispatch();
    DriverBase driver = driverList.get(selected_driver);
    driver.updateSelf(this.deliveryRequest);
//    for (DriverBase o : driverList) {
//      o.updateSelf(this.deliveryRequest);
//    }
  }
}
