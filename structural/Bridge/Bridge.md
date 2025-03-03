# Why we should use the Bridge design pattern:

- Decouples abstraction from implementation.
- Improves code maintainability and scalability.
- Enhances flexibility by allowing independent development of abstraction and implementation.
- Facilitates the addition of new abstractions and implementations without modifying existing code.
- Promotes the use of composition over inheritance.
- Reduces code duplication by sharing implementations among multiple abstractions.
- Simplifies complex class hierarchies.

## Real-world Examples of the Bridge Design Pattern:

1. **Remote Controls and Devices**:
    - Abstraction: Remote control
    - Implementations: TV, DVD player, Sound system

2. **Cross-platform GUI Libraries**:
    - Abstraction: GUI elements (buttons, windows)
    - Implementations: Windows, macOS, Linux

3. **Document Generation Systems**:
    - Abstraction: Document (report, invoice)
    - Implementations: PDF, HTML, Word

4. **Payment Systems**:
    - Abstraction: Payment method (credit card, PayPal)
    - Implementations: Different payment gateways (Stripe, PayPal API)

5. **Drawing Applications**:
    - Abstraction: Shape (circle, rectangle)
    - Implementations: Different rendering engines (OpenGL, DirectX)


    ## Step-by-Step Java Code Using Bridge Design Pattern for Payment System

    ### Step 1: Define the Abstraction

    ```java
    // Payment.java
    public abstract class Payment {
        protected PaymentGateway paymentGateway;

        protected Payment(PaymentGateway paymentGateway) {
            this.paymentGateway = paymentGateway;
        }

        public abstract void makePayment(double amount);
    }
    ```

    ### Step 2: Implement the Refined Abstraction

    ```java
    // CreditCardPayment.java
    public class CreditCardPayment extends Payment {

        public CreditCardPayment(PaymentGateway paymentGateway) {
            super(paymentGateway);
        }

        @Override
        public void makePayment(double amount) {
            paymentGateway.processPayment("Credit Card", amount);
        }
    }
    ```

    ```java
    // PayPalPayment.java
    public class PayPalPayment extends Payment {

        public PayPalPayment(PaymentGateway paymentGateway) {
            super(paymentGateway);
        }

        @Override
        public void makePayment(double amount) {
            paymentGateway.processPayment("PayPal", amount);
        }
    }
    ```

    ### Step 3: Define the Implementor Interface

    ```java
    // PaymentGateway.java
    public interface PaymentGateway {
        void processPayment(String paymentType, double amount);
    }
    ```

    ### Step 4: Implement the Concrete Implementors

    ```java
    // StripeGateway.java
    public class StripeGateway implements PaymentGateway {

        @Override
        public void processPayment(String paymentType, double amount) {
            System.out.println("Processing " + paymentType + " payment of $" + amount + " through Stripe.");
        }
    }
    ```

    ```java
    // PayPalGateway.java
    public class PayPalGateway implements PaymentGateway {

        @Override
        public void processPayment(String paymentType, double amount) {
            System.out.println("Processing " + paymentType + " payment of $" + amount + " through PayPal.");
        }
    }
    ```

    ### Step 5: Demonstrate the Bridge Pattern

    ```java
    // Main.java
    public class Main {
        public static void main(String[] args) {
            PaymentGateway stripeGateway = new StripeGateway();
            PaymentGateway payPalGateway = new PayPalGateway();

            Payment creditCardPayment = new CreditCardPayment(stripeGateway);
            creditCardPayment.makePayment(100.0);

            Payment payPalPayment = new PayPalPayment(payPalGateway);
            payPalPayment.makePayment(200.0);
        }
    }
    ```


    ### Class Diagram for the Payment System Example

    ```mermaid
    classDiagram
        class Payment {
            <<Abstract class>>
            - PaymentGateway paymentGateway
            + makePayment(double amount)
        }

        class PaymentGateway {
            <<interface>>
            + processPayment(String paymentType, double amount)
        }

        Payment <|-- CreditCardPayment : is a
        Payment <|-- PayPalPayment : is a
        PaymentGateway <|.. StripeGateway  : is a
        PaymentGateway <|.. PayPalGateway : is a
        Payment --> PaymentGateway : has a
        class CreditCardPayment {
            <<concrete class from payment>>
            + makePayment(double amount)
        }

        class PayPalPayment {
            <<concrete class from payment>>
            + makePayment(double amount)
        }

        class StripeGateway {
            <<Concrete class from PaymentGateway>>
            + processPayment(String paymentType, double amount)
        }

        class PayPalGateway {
            <<Concrete class from PaymentGateway>>
            + processPayment(String paymentType, double amount)
        }
    ```

