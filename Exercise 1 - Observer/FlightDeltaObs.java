import java.lang.*;

public class FlightDeltaObs implements Observer {

	Flight prevFlight = null;

	public void setPrevFlight(Flight flight) {
		if (flight != null) {
			prevFlight = flight;
		}
	}

	public void update(Object object) {
		if (object.getClass().equals(Flight.class) && prevFlight != null && object != null) {
			Flight flight = (Flight) object;
			float deltaLon = java.lang.Math.abs(prevFlight.longitude - flight.longitude);
			float deltaLat = java.lang.Math.abs(prevFlight.latitude - flight.latitude);
			float deltaVel = java.lang.Math.abs(prevFlight.velocity - flight.velocity);
			float deltaAlt = java.lang.Math.abs(prevFlight.geo_altitude - flight.geo_altitude);
			String output = "delta lon: " + deltaLon + ", delta lat: " + deltaLat + ", delta vel: " + deltaVel + ", delta alt: " + deltaAlt;
			System.out.println("Flight Changes - " + output + "\n");
			prevFlight = flight;
		}
		if (object.getClass().equals(Flight.class)) {
			Flight flight = (Flight) object;
			setPrevFlight(flight);
		}
	}
}
