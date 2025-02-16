//here we have used synchronized keyword to make the getInstance method thread safe. but it has performance issue because of locking mechanism.
//we can use double check locking mechanism to avoid this issue.
class DatabaseConnectionThreadSafe {
    private static DatabaseConnectionThreadSafe instance;

    private DatabaseConnectionThreadSafe() {
        System.out.println("Database Connection Initialized.");
    }

    public static synchronized DatabaseConnectionThreadSafe getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionThreadSafe();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}
