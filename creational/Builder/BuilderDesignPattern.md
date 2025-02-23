# Builder Design Pattern

The Builder Design Pattern is a creational design pattern that allows for the step-by-step creation of complex objects using a builder interface. This pattern is particularly useful when an object needs to be created in multiple steps or when an object can have different representations.

## Key Concepts

- **Builder**: This is an interface that defines all the steps required to create the product.
- **ConcreteBuilder**: This class implements the Builder interface and provides specific implementations for the steps defined in the Builder.
- **Director**: This class is responsible for constructing the object using the Builder interface. It controls the construction process.
- **Product**: This is the complex object that is being built.

## Advantages

- **Separation of Concerns**: The construction process is separated from the representation, allowing for different representations of the object to be created using the same construction process.
- **Flexibility**: The pattern provides flexibility in creating complex objects by allowing the construction process to be more controlled and incremental.
- **Reusability**: Builders can be reused to create different representations of the same object.

## Example

Here is a simple example of the Builder Design Pattern in Java:

```java
// Product
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    // Getters and setters
}

// Builder Interface
public interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void buildInterior();
    House getHouse();
}

// Concrete Builder
public class ConcreteHouseBuilder implements HouseBuilder {
    private House house;

    public ConcreteHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Concrete, brick, and stone");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Concrete, brick, and stone");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Concrete, brick, and stone");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Concrete, brick, and stone");
    }

    @Override
    public House getHouse() {
        return this.house;
    }
}

// Director
public class ConstructionEngineer {
    private HouseBuilder houseBuilder;

    public ConstructionEngineer(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        this.houseBuilder.buildFoundation();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        this.houseBuilder.buildInterior();
        return this.houseBuilder.getHouse();
    }
}

// Client
public class Client {
    public static void main(String[] args) {
        HouseBuilder houseBuilder = new ConcreteHouseBuilder();
        ConstructionEngineer engineer = new ConstructionEngineer(houseBuilder);
        House house = engineer.constructHouse();
        System.out.println("House is: " + house);
    }
}
```

In this example, the `House` class is the product being built. The `HouseBuilder` interface defines the steps to build the house. The `ConcreteHouseBuilder` class provides the implementation of these steps. The `ConstructionEngineer` class is the director that controls the construction process. Finally, the `Client` class demonstrates how to use these classes to build a house.


## Example Without Builder Design Pattern

Here is an example of creating a complex object without using the Builder Design Pattern:

```java
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    public House(String foundation, String structure, String roof, String interior) {
        this.foundation = foundation;
        this.structure = structure;
        this.roof = roof;
        this.interior = interior;
    }

    // Getters and setters
}

public class Client {
    public static void main(String[] args) {
        House house = new House("Concrete, brick, and stone", "Concrete, brick, and stone", "Concrete, brick, and stone", "Concrete, brick, and stone");
        System.out.println("House is: " + house);
    }
}
```

### Complexity

1. **Code Duplication**: If the construction process is complex and involves multiple steps, the same code might be duplicated in multiple places, leading to maintenance issues.
2. **Lack of Flexibility**: Any change in the construction process would require changes in all places where the object is being created, making the code less flexible.
3. **Difficulty in Managing Optional Parameters**: Managing optional parameters can become cumbersome as the number of parameters increases, leading to constructors with many parameters.
4. **Reduced Readability**: The readability of the code decreases as the complexity of the object increases, making it harder to understand and maintain.

Using the Builder Design Pattern helps to address these complexities by separating the construction process from the representation, providing a more flexible and maintainable approach to creating complex objects.


## Builder Design Pattern in Java Spring Boot with Annotations

In Spring Boot, you can leverage Lombok's `@Builder` annotation to implement the Builder Design Pattern. Lombok is a Java library that helps to reduce boilerplate code. Here is an example of how to achieve this:

### Step 1: Add Lombok Dependency

First, add the Lombok dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.24</version>
    <scope>provided</scope>
</dependency>
```

### Step 2: Create the Product Class

Use the `@Builder` annotation to create the product class:

```java
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;
}
```

### Step 3: Use the Builder in the Client Code

You can now use the builder pattern in your client code to create instances of the `House` class:

```java
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuilderPatternApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BuildPatternApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        House house = House.builder()
                .foundation("Concrete, brick, and stone")
                .structure("Concrete, brick, and stone")
                .roof("Concrete, brick, and stone")
                .interior("Concrete, brick, and stone")
                .build();

        System.out.println("House is: " + house);
    }
}
```

In this example, the `House` class is annotated with `@Builder`, which generates a builder for the class. The `BuilderPatternApplication` class demonstrates how to use this builder to create an instance of `House`.

Using Lombok's `@Builder` annotation simplifies the implementation of the Builder Design Pattern in Spring Boot applications, reducing boilerplate code and improving readability.