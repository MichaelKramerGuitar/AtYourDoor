package edu.bu.met.cs665.distribution;

/**
 * The purpose of this class is to implement the SubriberBase interface in the
 * Observer Pattern. Driver objects will implement this interface to be amongst
 * the pool of listeners for incoming store orders and will be selected individually
 * if available to deliver an order by the Dispatcher.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public interface DriverBase {

  /**
   * The purpose of this method is to pass oneself a delivery request.
   * @param message A String delivery request.
   */
  void updateSelf(String message);

}
