package behavioral.Observer.code;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private String name;
    private String availability;
    private List<Observer> observers = new ArrayList<>();

    public Product(String name, String availability) {
        this.name = name;
        this.availability = availability;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Notifying to all the subscribers when product became available");
        for (Observer observer : observers) {
            observer.update("Hello "+ name+ " is now " + availability);
        }
    }

    @Override
    public void setAvailability(String availability) {
        this.availability = availability;
        notifyObservers();
    }

}
