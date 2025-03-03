The SOLID principles are a set of design principles in object-oriented programming that help to create more understandable, flexible, and maintainable software. SOLID is an acronym that stands for:
- **S**ingle Responsibility Principle (SRP)
- **O**pen/Closed Principle (OCP)
- **L**iskov Substitution Principle (LSP)
- **I**nterface Segregation Principle (ISP)
- **D**ependency Inversion Principle (DIP)


1. **S**ingle Responsibility Principle (SRP): A class should have only one reason to change, meaning it should have only one job or responsibility.

### Example of Single Responsibility Principle (SRP)

#### Not Following SRP:
```java
class User {
    public void login(String username, String password) {
        // Login logic
    }

    public void register(String username, String password, String email) {
        // Registration logic
    }

    public void sendEmail(String email, String message) {
        // Email sending logic
    }
}
```

In the above example, the `User` class has multiple responsibilities: handling user authentication and sending emails. This violates the Single Responsibility Principle.

#### Following SRP:
```java
class User {
    public void login(String username, String password) {
        // Login logic
    }

    public void register(String username, String password, String email) {
        // Registration logic
    }
}

class EmailService {
    public void sendEmail(String email, String message) {
        // Email sending logic
    }
}
```

In this example, the responsibilities are separated into different classes. The `User` class handles user authentication, and the `EmailService` class handles email sending. This adheres to the Single Responsibility Principle.


2. **O**pen/Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.

So it means we should not touch or update the existing code. instead of that we can extend the class and add the new feature in child class. so existing code wil not be updated.

### Example of Open/Closed Principle (OCP)

#### Not Following OCP:
```java
class Rectangle {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class AreaCalculator {
    public int calculateRectangleArea(Rectangle rectangle) {
        return rectangle.getWidth() * rectangle.getHeight();
    }
}
```

In the above example, if we need to add a new shape like a circle, we would have to modify the `AreaCalculator` class, which violates the Open/Closed Principle.

#### Following OCP:
```java
interface Shape {
    int calculateArea();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int calculateArea() {
        return (int) (Math.PI * radius * radius);
    }
}

class AreaCalculator {
    public int calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
```

In this example, the `AreaCalculator` class is open for extension but closed for modification. We can add new shapes like `Circle` without modifying the `AreaCalculator` class.
3. **L**iskov Substitution Principle (LSP): Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

Examples -: if you are creating any child class you should not reduce the feature of parent class. always it should extend the feature not the narrow it down.

### Example of Liskov Substitution Principle (LSP)

#### Not Following LSP:
```java
class Bird {
    public void fly() {
        // Fly logic
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
```

In the above example, the `Ostrich` class violates the Liskov Substitution Principle because it cannot be substituted for the `Bird` class without causing issues. The `fly` method in `Ostrich` throws an exception, which is not expected behavior for a `Bird`.

#### Following LSP:
```java
abstract class Bird {
    public abstract void move();
}

class FlyingBird extends Bird {
    @Override
    public void move() {
        fly();
    }

    public void fly() {
        // Fly logic
    }
}

class Ostrich extends Bird {
    @Override
    public void move() {
        // Ostrich specific movement logic
    }
}
```

In this example, the `Bird` class hierarchy is restructured to ensure that all subclasses can be substituted for the `Bird` class without altering the expected behavior. The `Ostrich` class no longer attempts to fly, adhering to the Liskov Substitution Principle.
4. **I**nterface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use. Instead of one large interface, many small, specific interfaces are preferred.

Examples -:
we should use the interface based on the required relevent features don't add any method/feature which is not useful. we can create muliple class based on the requirement.
### Example of Interface Segregation Principle (ISP)

#### Not Following ISP:
```java
interface Worker {
    void work();
    void eat();
}

class HumanWorker implements Worker {
    public void work() {
        // Human working
    }

    public void eat() {
        // Human eating
    }
}

class RobotWorker implements Worker {
    public void work() {
        // Robot working
    }

    public void eat() {
        // Robots don't eat, but forced to implement this method
    }
}
```

In the above example, the `RobotWorker` class is forced to implement the `eat` method, which it does not need. This violates the Interface Segregation Principle.

#### Following ISP:
```java
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable {
    public void work() {
        // Human working
    }

    public void eat() {
        // Human eating
    }
}

class RobotWorker implements Workable {
    public void work() {
        // Robot working
    }
}
```

In this example, the interfaces are segregated based on functionality. The `RobotWorker` class only implements the `Workable` interface, which it needs, and is not forced to implement the `Eatable` interface.


5. **D**ependency Inversion Principle (DIP): High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.

Examples -: we should always use the interface name in the left side and right side implemented one so in future directly we can update the implemented class if required.
### Example of Dependency Inversion Principle (DIP)

#### Not Following DIP:
```java
class LightBulb {
    public void turnOn() {
        // Turn on the light bulb
    }

    public void turnOff() {
        // Turn off the light bulb
    }
}

class Switch {
    private LightBulb lightBulb;

    public Switch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    public void operate() {
        lightBulb.turnOn();
    }
}
```

In the above example, the `Switch` class depends directly on the `LightBulb` class, which violates the Dependency Inversion Principle.

#### Following DIP:
```java
interface Switchable {
    void turnOn();
    void turnOff();
}

class LightBulb implements Switchable {
    public void turnOn() {
        // Turn on the light bulb
    }

    public void turnOff() {
        // Turn off the light bulb
    }
}

class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate() {
        device.turnOn();
    }
}
```

In this example, the `Switch` class depends on the `Switchable` interface rather than a concrete implementation. This adheres to the Dependency Inversion Principle.
These principles help in building robust and scalable software systems.