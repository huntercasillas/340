
import java.util.*;

public abstract class Subject {

  ArrayList<Observer> observers = new ArrayList<Observer>();

  public void attach(Observer obs) {
    observers.add(obs);
  }

  public void detatch(Observer obs) {
    observers.remove(obs);
  }

  public void notifyObservers(Object obj) {
    for (Observer obs: observers) {
      obs.update(obj);
    }
  }
}
