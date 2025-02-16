import org.springframework.stereotype.Component;

@Component
public class Singleton {
    public Singleton() {
        System.out.println("DatabaseService Initialized.");
    }

    public void connect() {
        System.out.println("Connected to Database.");
    }
}


//springboot bydefault use the singleton design pattern for beans.
//@Component and @Service are singleton by default