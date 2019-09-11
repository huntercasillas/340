import java.lang.Math.*;

public class FlightDeltaObs implements Observer {

	Flight prevFlight = null;

	public void setPrevFlight(Flight flight) {
		if (flight != null) {
			prevFlight = flight;
		}
	}

	public void update(Flight flight) {
		if (prevFlight != null && flight != null) {
			float deltaLon = java.lang.Math.abs(prevFlight.longitude - flight.longitude);
			float deltaLat = java.lang.Math.abs(prevFlight.latitude - flight.latitude);
			float deltaVel = java.lang.Math.abs(prevFlight.velocity - flight.velocity);
			float deltaAlt = java.lang.Math.abs(prevFlight.geo_altitude - flight.geo_altitude);
			String output = "delta lon: " + deltaLon + ", delta lat: " + deltaLat + ", delta vel: " + deltaVel + ", delta alt: " + deltaAlt;
			System.out.println("Flight Changes - " + output + "\n");
			prevFlight = flight;
		}
		setPrevFlight(flight);
	}
}
