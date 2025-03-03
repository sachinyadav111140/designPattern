# SingleTon Examples

## Very simple using static keyword.
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

But the problem is thread safe this is not thread safe.

## Thread safe but expensive
in below example we are using synchronized keyword. it will not allow the multiple thread in function block. this is very expensive because 1000 thread can be hit to get the object. it will allow only one thread and give one by one.
```java
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        // private constructor to prevent instantiation
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
```

## Thread safe with double locks

Without volatile, the instance variable may not be correctly published to other threads. This can result in a situation where a thread sees a partially constructed object. Here's why:

    1.  Instruction Reordering: The Java compiler, JVM, or hardware may reorder instructions for performance optimization. Without volatile, the assignment to instance (instance = new DoubleCheckedLockingSingleton()) can be reordered such that the reference to the new object is assigned to instance before the constructor of DoubleCheckedLockingSingleton is fully executed.

    2. Visibility: Without volatile, changes made to instance by one thread may not be visible to other threads immediately. This means another thread could see a non-null but incompletely constructed instance.

```java
public class DoubleCheckedLockingSingleton {
    private static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
        // private constructor to prevent instantiation
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}
```


## Double lock with volatile so memory issue will not be there

```java
public class DoubleLockWithVolatile
{
    static private volatile DoubleLockWithVolatile instance;
    private DoubleLockWithVolatile()
    {
        //provate constructor so it can't be accessed from outside.
    }
    public DoubleLockWithVolatile getInstance()
    {
        if(instance==null)
        {
            synchronized(DoubleLockWithVolatile.class)
            {
                if(instance==null)
                {
                    instance = new DoubleLockWithVolatile();
                }

            }
        }
        return instance;
    }

}
```

Like this we can create the singleClasses for better approch.


