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