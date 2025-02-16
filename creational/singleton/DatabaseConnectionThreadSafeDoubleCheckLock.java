//this is good approch but little complex to write.
// we can use Bill push mechanism also check the next exmaple.
class DatabaseConnectionThreadSafeDoubleCheckLock {
    // here use of volatie keyword is very important. because it will prevent the reordering of the code by the compiler. it will ensure that the instance is initialized only after the memory is allocated to the instance.
    private static volatile DatabaseConnectionThreadSafeDoubleCheckLock instance;

    private DatabaseConnectionThreadSafeDoubleCheckLock() {
        System.out.println("Database Connection Initialized.");
    }

    public static DatabaseConnectionThreadSafeDoubleCheckLock getInstance() {
        if (instance == null) {  // First check (no locking)
            synchronized (DatabaseConnectionThreadSafeDoubleCheckLock.class) {
                if (instance == null) {  // Second check (inside lock)
                    instance = new DatabaseConnectionThreadSafeDoubleCheckLock();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}
