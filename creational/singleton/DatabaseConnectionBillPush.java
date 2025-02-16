class DatabaseConnectionBillPush {
    private DatabaseConnectionBillPush() {
        System.out.println("Database Connection Initialized.");
    }

    private static class Holder {
        private static final DatabaseConnectionBillPush INSTANCE = new DatabaseConnectionBillPush();
    }

    public static DatabaseConnectionBillPush getInstance() {
        return Holder.INSTANCE;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}
