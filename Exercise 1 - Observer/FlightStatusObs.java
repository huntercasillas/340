
public class FlightStatusObs implements Observer {

  public void update(Flight flight) {
    if (flight != null) {
      System.out.println("Flight Status - " + flight.toString());
    }
  }
}
