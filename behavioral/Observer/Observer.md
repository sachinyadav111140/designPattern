# Why
The Observer Design Pattern is used to create a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. This pattern is particularly useful for implementing distributed event-handling systems, ensuring that changes in the subject are propagated to all observers without tightly coupling the objects.

## Real World Examples

1. **User Interface Components**: In graphical user interfaces, various components like buttons, text fields, and sliders can act as subjects. When a user interacts with these components, observers (like event listeners) are notified to handle the events.

2. **Stock Market Ticker**: A stock market ticker system can use the observer pattern to notify all registered observers (e.g., display boards, trading applications) whenever there is a change in stock prices.

3. **Social Media Notifications**: Social media platforms use the observer pattern to notify users about new posts, comments, or likes. When a user posts an update, all followers (observers) are notified.

4. **Weather Monitoring Systems**: Weather stations can act as subjects that notify various display devices (observers) about changes in weather conditions like temperature, humidity, and pressure.

5. **Email Subscription Services**: In email subscription services, users subscribe to newsletters or updates. When new content is available, the service notifies all subscribed users (observers) by sending them an email.


## Java Code Example: Product Availability Notification

Here is a step-by-step example of how to implement the Observer Design Pattern in Java to notify users when a product is back in stock.

### Step 1: Define the Observer Interface

```java
public interface Observer {
    void update(String productName);
}
```

### Step 2: Create the Subject Interface

```java
import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

### Step 3: Implement the Concrete Subject

```java
public class Product implements Subject {
    private List<Observer> observers;
    private String name;
    private boolean inStock;

    public Product(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
        this.inStock = false;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
        if (inStock) {
            notifyObservers();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(name);
        }
    }
}
```

### Step 4: Implement the Concrete Observer

```java
public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String productName) {
        System.out.println("Hello " + name + ", the product " + productName + " is now back in stock!");
    }
}
```

### Step 5: Client Code

```java
public class Main {
    public static void main(String[] args) {
        Product product = new Product("Laptop");

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        product.registerObserver(user1);
        product.registerObserver(user2);

        System.out.println("Setting product in stock...");
        product.setInStock(true);
    }
}
```

### Explanation

1. **Observer Interface**: Defines the `update` method that will be called when the subject's state changes.
2. **Subject Interface**: Defines methods for registering, removing, and notifying observers.
3. **Product Class**: Implements the `Subject` interface and maintains a list of observers. It notifies all observers when the product is back in stock.
4. **User Class**: Implements the `Observer` interface and defines the `update` method to receive notifications.
5. **Main Class**: Demonstrates the usage of the observer pattern by creating a product and users, registering the users as observers, and changing the product's stock status.

This example shows how the Observer Design Pattern can be used to notify users when a product is back in stock.
