package edu.bu.met.cs665.syndicate;

import edu.bu.met.cs665.distribution.DriverBase;

/**
 * The purpose of this class is to serve as the PublisherBase Interface in the
 * Observer Design Pattern. Classes that implement this interface will be Store
 * objects that need to push delivery requests to a Dispatcher who will assign
 * from a DriverBase listening for these notifications.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public interface SyndicateRequestor {

  /**
   * The purpose of this method is to add DriverBase objects to listen for
   * notifications.
   * @param o A DriverBase object
   */
  void subscribe(DriverBase o);

  /**
   * The purpose of this method is to take a particular DriverBase object off
   * the list of objects listening for notifications.
   * @param o A DriverBase object
   */
  void unsubscribe(DriverBase o);

  /**
   * The purpose of this method is to notify the dispatcher when an order needs
   * to be delivered.
   */
  void notifyDispatcher();
}
