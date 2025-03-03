# Template Method Design Pattern

## Why use the Template Method design pattern?

The Template Method design pattern is used to define the skeleton of an algorithm in a base class, allowing subclasses to override specific steps of the algorithm without changing its structure. This promotes code reuse, consistency, and flexibility by enabling the common behavior to be defined in one place while allowing variations in the behavior through subclassing.

## Real-World Examples of Template Method Design Pattern

1. **Coffee Brewing Process**:
    - The process of brewing coffee can be defined in a base class with steps like boiling water, brewing coffee, and pouring into a cup. Subclasses can override the brewing step to make different types of coffee like espresso, latte, or cappuccino.

2. **Document Generation**:
    - In a document generation system, the base class can define the steps for generating a document, such as opening the document, writing content, and saving the document. Subclasses can override the writing content step to generate different types of documents like reports, invoices, or letters.

3. **Game Development**:
    - In game development, the base class can define the steps for initializing a game, starting the game loop, and ending the game. Subclasses can override the game loop step to implement different types of games like puzzle games, action games, or strategy games.

4. **Data Processing Pipelines**:
    - In data processing, a base class can define the steps for processing data, such as reading data, processing data, and writing data. Subclasses can override the processing data step to implement different data transformations like filtering, aggregation, or enrichment.

5. **User Authentication**:
    - In an authentication system, the base class can define the steps for authenticating a user, such as validating credentials, checking permissions, and logging the user in. Subclasses can override the checking permissions step to implement different authentication mechanisms like role-based access control, multi-factor authentication, or biometric authentication.



    ## Example in Java: Template Method Design Pattern

    Let's consider an example of a template method design pattern in Java for making beverages.

    ### Step 1: Create an Abstract Class

    Define an abstract class `Beverage` with a template method `prepareRecipe()` and abstract methods for the steps that need to be implemented by subclasses.

    ```java
    abstract class Beverage {
        // Template method
        public final void prepareRecipe() {
            boilWater();
            brew();
            pourInCup();
            addCondiments();
        }

        abstract void brew();
        abstract void addCondiments();

        void boilWater() {
            System.out.println("Boiling water");
        }

        void pourInCup() {
            System.out.println("Pouring into cup");
        }
    }
    ```

    ### Step 2: Create Concrete Subclasses

    Create concrete subclasses `Tea` and `Coffee` that implement the abstract methods.

    ```java
    class Tea extends Beverage {
        void brew() {
            System.out.println("Steeping the tea");
        }

        void addCondiments() {
            System.out.println("Adding lemon");
        }
    }

    class Coffee extends Beverage {
        void brew() {
            System.out.println("Dripping coffee through filter");
        }

        void addCondiments() {
            System.out.println("Adding sugar and milk");
        }
    }
    ```

    ### Step 3: Use the Template Method

    Create instances of `Tea` and `Coffee` and call the `prepareRecipe()` method to see the template method in action.

    ```java
    public class TemplateMethodTest {
        public static void main(String[] args) {
            Beverage tea = new Tea();
            tea.prepareRecipe();

            Beverage coffee = new Coffee();
            coffee.prepareRecipe();
        }
    }
    ```

    ### Output

    When you run the `TemplateMethodTest` class, you will see the following output:

    ```
    Boiling water
    Steeping the tea
    Pouring into cup
    Adding lemon
    Boiling water
    Dripping coffee through filter
    Pouring into cup
    Adding sugar and milk
    ```

    This demonstrates how the template method pattern allows for the reuse of the algorithm's structure while enabling subclasses to provide specific implementations for certain steps.



In this case steps would same and client can override based on the their requirement.