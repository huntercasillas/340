
public class FlightStatusObs implements Observer {

  public void update(Object object) {
    if (object.getClass().equals(Flight.class) && object != null) {
      Flight flight = (Flight) object;
      System.out.println("Flight Status - " + flight.toString());
    }
  }
}
