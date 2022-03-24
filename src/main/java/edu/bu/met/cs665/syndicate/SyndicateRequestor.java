package edu.bu.met.cs665.syndicate;

import edu.bu.met.cs665.distribution.DriverBase;

public interface SyndicateRequestor {

  void subscribe(DriverBase o);

  void unsubscribe(DriverBase o);

  void notifyDispatcher();
}
