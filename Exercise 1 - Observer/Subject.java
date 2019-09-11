
import java.util.*;

public abstract class Subject {

  ArrayList<Observer> observers = new ArrayList<Observer>();

  public void attach(Observer obs) {
    observers.add(obs);
  }

  public void detatch(Observer obs) {
    observers.remove(obs);
  }

  public void notifyObservers(Flight flight) {
    for (Observer obs: observers) {
      obs.update(flight);
    }
  }
}
