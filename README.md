# 1 Application Description: AtYourDoor

_A consortium of shops in a large city has established an agreement with local independent van and
taxi drivers to deliver products from city shops to customer destinations.
In this assignment, you will implement a notification system to send notifications about delivery
requests to drivers. When a store gets a product delivery orders should be created at store and a
delivery request should be broadcasted to all drivers._

# 1.1 Implementation Details

_Your implementation should include the following functionalities:_

- Your implementation should include classes for Shop, Delivery Request and Driver.
- For testing purpose create a Shop object, delivery requests and driver objects.
- For testing purposes send out a single delivery request and notify all drivers regarding the
  delivery request. You can assign the delivery request based on some random assignment or
  based on first come first served principles.

_**Note: In this assignment, you should apply “at least one" of the design patterns that we learned
in our class. We do not mention which one of the design patterns is suitable for this scenario. This
would be your task as a software engineer to find it out.**_

_**Note: The given application scenario can be implemented in different ways and with different
implementation details. There is not only one single correct design and implementation for
the above application scenario. Each software developer might consider different assumptions and
design the software based on them. In this assignment you are free to have your own detail assumptions
and implement the details in your own way based on your own ideas. You should document
your assumptions very well in your README.md file of your project and consider them in your
UML diagrams.**_

# 2.1 Task 1: Implementation Description

- The approach implemented is a slightly modified Observer Pattern.
  - The PublisherBase Interface is syndicate/SyndicateRequestor
  - The Concrete Publishers are the syndicate/Store
  - The SubscriberBase Interface is distribution/DriverBase
  - The concrete subscribers are distribution/Driver
  - The modification to the Observer Pattern in the additional distribution/Dispatcher
    which chooses from the list of subscribers (Drivers) and assigns one to the delivery request
    made by the Store.

_**How is the flexibility, of your implementation, e.g., how you add or remove in future new
types?**_

- Being that the Observer Pattern is fairly closely adhered to, this design satisfies
  the characteristic of loose coupling which implies great flexibility. In order to add
  Publishers (classes like Store which would need to notify a Dispatcher) all we would need
  to do is implement the PublisherBase interface and implement the methods therein. Similarly,
  in order to add more Subscribers, let's say for example we wanted to loop the Customer into
  the equation such that they could receive status of their order, all we need to do is
  implement the DriverBase interface (which we might consider renaming to suggest a more
  general usage as is implied by the Observer Pattern of "SubscriberBase"). In this way
  a Customer could simply .updateSelf() accordingly.

_**How is the simplicity and understandability of your implementation?**_

- The Application as implemented here is using #1) a pattern that is quite common in modern
  software applications such as all social media, Uber/Lyft, AmazonPrime, Weather Applications
  and the list is seemingly endless truly. In this way, it seems quite easy to relate this
  system of an entity that creates an "order" and "notifies" a "subscriber base" as needed with
  the additional feature of having a "middle man" Dispatcher who chooses which subscriber
  makes the delivery. We might imagine expanding this idea to incorporating the idea that
  an active driver cannot receive an assignment from the dispatcher, or even more interesting
  incorporating the idea of a route and in general the idea of location such that each driver
  has a location and the dispatcher assigns drivers based on that instead of at random. These
  concepts and additional ideas are so common in the current marketplace that it seems their
  understandability and perhaps more aptly, their relatability, is quite high. To this end,
  there are quite few moving parts in this pattern and implementation such that the simplicity
  and elegance seems to be high as well.

_**How you avoided duplicated code?**_

- Running the risk of redundancy, simply by adhering quite strictly to the Observer Pattern
  and deviating only to satisfy the additional requirements of the assignment such that
  only one Driver is assigned per order.  By adhering to the pattern there is virtually no
  repetition in code and yet the preconditions are elegantly satisfied thusly exposing the
  power of the pattern in the context of the outlined requirements.

# How to compile the project

We use Apache Maven to compile and run this project.

You need to install Apache Maven (https://maven.apache.org/)  on your system.

Type on the command line:

```bash
mvn clean compile
```

# How to create a binary runnable package


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

# Run all the unit test classes.


```bash
mvn clean compile test checkstyle:check  spotbugs:check
```

# Using Spotbugs to find bugs in your project

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using


```bash
mvn spotbugs:gui 
```

or


```bash
mvn spotbugs:spotbugs
```


```bash
mvn spotbugs:check 
```

check goal runs analysis like spotbugs goal, and make the build failed if it found any bugs.


For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html


SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style.
You can change it to other styles like sun checkstyle.

To analyze this example using CheckStyle run

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser.

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```