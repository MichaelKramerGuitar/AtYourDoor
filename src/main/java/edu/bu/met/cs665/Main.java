package edu.bu.met.cs665;

import edu.bu.met.cs665.distribution.Driver;
import edu.bu.met.cs665.example1.Person;
import edu.bu.met.cs665.syndicate.Store;
import org.apache.log4j.Logger;

import java.util.Random;
// import org.apache.log4j.PropertyConfigurator;

public class Main {

  private static Logger logger = Logger.getLogger(Main.class);


  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) {

    // This configuration is for setting up the log4j properties file.
    // It is better to set this using java program arguments.
    // PropertyConfigurator.configure("log4j.properties");

    // Let us create an object of the Main class.
    //Main m = new Main();
    String[] costco_orders = new String[]{"groceries, tv, washing machine",
                                          "cleaning supplies, bottled water",
                                          "party try sandwiches, chips, guacamole",
                                          "gardening tools, mop, dust-pan"};

    String[] wholefoods_orders = new String[]{"quinoa, tomatos, avocados",
                                              "ice-cream, beer, bacon",
                                              "kombucha, sparkling-water, lemons",
                                              "peaches, arugula, barbeque sauce",
                                              "blackberries, bananas, milk, honey"};
    // create a store
    Store costco = new Store("costco");

    Store wholeFoods = new Store("wholefoods");

    // create 20 drivers for costco orders
    int driversOnDuty = 20;
//    int selected_driver = (int) (Math.random() * (driversOnDuty - 1) + 1);
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, costco);
    }
    // get a random costco order and assign a driver
    costco.setDeliveryRequest(costco_orders[(int) (Math.random() * (costco_orders.length - 1) + 1)]);
    System.out.println();
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, wholeFoods);
    }
    // now give drivers whole foods order and assign a driver
    wholeFoods.setDeliveryRequest(wholefoods_orders[(int) (Math.random() * (wholefoods_orders.length - 1) + 1)]);

    //logger.info(m.doIt());

//    logger.trace("Trace Message!");
//    logger.debug("Debug Message!");
//    logger.info("Info Message!");
//    logger.warn("Warn Message!");
//    logger.error("Error Message!");
//    logger.fatal("Fatal Message!");

  }



  private String doIt() {
    Person student = new Person("John", "Doe");
    return student.getLastName() + ',' + student.getLastName();
  }

}
