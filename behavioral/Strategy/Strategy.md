# strategy Design pattern.
## Why
1. Sometimes we need to choose one algorithm from a list of algorithms.
2. We can create a Strategy interface that defines the algorithm's structure.

```java
public interface Strategy {
    void execute();
}
```

3. Implement different algorithms by creating classes that implement the Strategy interface.

```java
public class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Algorithm A");
    }
}

public class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Algorithm B");
    }
}
```

4. Create a Context class that uses a Strategy.

```java
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}
```

5. Use the Context class to execute different algorithms.

```java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.executeStrategy(); // Output: Algorithm A

        context.setStrategy(new ConcreteStrategyB());
        context.executeStrategy(); // Output: Algorithm B
    }
}
```

## Real-world Examples of Strategy Design Pattern

1. **Sorting Algorithms**:
    - Different sorting algorithms (e.g., QuickSort, MergeSort, BubbleSort) can be implemented as strategies. The context can choose the appropriate sorting strategy based on the size and nature of the data.

2. **Payment Methods in E-commerce**:
    - Various payment methods (e.g., Credit Card, PayPal, Bitcoin) can be implemented as strategies. The context (e.g., Checkout process) can select the appropriate payment strategy based on user preference or availability.

3. **Compression Algorithms**:
    - Different compression algorithms (e.g., ZIP, RAR, GZIP) can be implemented as strategies. The context can choose the appropriate compression strategy based on the type of file and required compression ratio.

4. **Travel Route Calculation**:
    - Different route calculation algorithms (e.g., Shortest Path, Fastest Route, Scenic Route) can be implemented as strategies. The context (e.g., GPS Navigation System) can select the appropriate strategy based on user preference or traffic conditions.

5. **File Encryption**:
    - Various encryption algorithms (e.g., AES, DES, RSA) can be implemented as strategies. The context can choose the appropriate encryption strategy based on security requirements and performance considerations.