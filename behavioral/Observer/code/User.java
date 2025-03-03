package behavioral.Observer.code;


public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }

}
