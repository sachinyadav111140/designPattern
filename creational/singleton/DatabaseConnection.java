// Singleton class basic it is not thread safe. But how to make it thread safe? we can use synchronized keyword in the getInstance method.
class DatabaseConnection {
    private static DatabaseConnection instance;

    // Private constructor prevents instantiation
    private DatabaseConnection() {
        System.out.println("Database Connection Initialized.");
    }

    // Public method to provide a single instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}

// Client Code
public class SingletonDemo {
    public static void main(String[] args) {
        // Try to create multiple instances
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        db1.connect();

        // Verify that both instances are the same
        System.out.println(db1 == db2); // Output: true
    }
}
