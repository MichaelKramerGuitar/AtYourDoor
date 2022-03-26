package edu.bu.met.cs665;

import edu.bu.met.cs665.distribution.Driver;
import edu.bu.met.cs665.syndicate.Store;

/**
 * The purpose of this class is to give a simulation of the Observer Pattern
 * implemented to fulfill the assignment requirements.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Main {

  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) {

    // Sample orders to choose at random
    String[] costcoOrders = new String[]{"groceries, tv, washing machine",
                                         "cleaning supplies, bottled water",
                                         "party try sandwiches, chips, guacamole",
                                         "gardening tools, mop, dust-pan"};

    // create a store
    Store costco = new Store("costco");

    // create 20 drivers for costco orders
    int driversOnDuty = 20;
    // int selected_driver = (int) (Math.random() * (driversOnDuty - 1) + 1);
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, costco);
    }
    // get a random costco order and assign a driver
    costco.setDeliveryRequest(
        costcoOrders[(int) (Math.random() * (costcoOrders.length - 1) + 1)]);
    System.out.println();

    String[] wholefoodsOrders = new String[]{"quinoa, tomatos, avocados",
      "ice-cream, beer, bacon",
      "kombucha, sparkling-water, lemons",
      "peaches, arugula, barbeque sauce",
      "blackberries, bananas, milk, honey"};

    Store wholeFoods = new Store("wholefoods");
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, wholeFoods);
    }
    // now give drivers whole foods order and assign a driver
    wholeFoods.setDeliveryRequest(
        wholefoodsOrders[(int) (Math.random() * (wholefoodsOrders.length - 1) + 1)]);
    System.out.println();

    String[] homeDepotOrders = new String[]{"wrench, drywall, screw driver",
      "paint, rollers, smock",
      "mulch, shovel, sand",
      "bleach, mop, bucket, gloves",
      "insulation, gaskets, metal trimmers, sealant"};

    Store homeDepot = new Store("home depot");
    for (int i = 0; i < driversOnDuty; i++) {
      new Driver("Driver #" + i, homeDepot);
    }
    // now give drivers whole foods order and assign a driver
    homeDepot.setDeliveryRequest(
        homeDepotOrders[(int) (Math.random() * (homeDepotOrders.length - 1) + 1)]);
  }
}
