The Factory Method is a creational design pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created. It promotes loose coupling by eliminating the need to bind application-specific classes into the code. This pattern defines a method, which should be used for creating objects instead of a direct constructor call. The Factory Method pattern is particularly useful when the exact type of the object to be created is determined by the subclass. It helps in achieving a more flexible and reusable code structure.



### Example Without Factory Method

```java
public class Main {
    public static void main(String[] args) {
        // Direct instantiation of objects
        Shape circle = new Circle();
        Shape square = new Square();
        
        circle.draw();
        square.draw();
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}
```

### Example With Factory Method

```java
public class Main {
    public static void main(String[] args) {
        // Using factory method to create objects
        ShapeFactory shapeFactory = new ShapeFactory();
        
        Shape circle = shapeFactory.createShape("CIRCLE");
        Shape square = shapeFactory.createShape("SQUARE");
        
        circle.draw();
        square.draw();
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
```

### Benefits of Using Factory Method

1. **Encapsulation**: The object creation logic is encapsulated within the `ShapeFactory` class, making the code more modular.
2. **Flexibility**: New shapes can be added easily by extending the `Shape` interface and updating the `ShapeFactory` without modifying the client code.
3. **Reusability**: The factory method promotes loose coupling, allowing the `ShapeFactory` to be reused across different parts of the application.
4. **Maintainability**: Adding new types of shapes does not require changes to the existing code, improving maintainability.
5. **Testing**: The factory method makes unit testing easier by allowing the creation of mock objects and simplifying the testing process.

Overall, the Factory Method pattern provides a more organized, maintainable, and scalable approach to object creation.