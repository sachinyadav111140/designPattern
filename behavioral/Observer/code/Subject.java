package behavioral.Observer.code;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setAvailability(String availability);

}
