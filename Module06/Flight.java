import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;

public class Flight implements Comparable<Flight> {

  private String airline;
  private int flightNumber;
  private String airlineCode;

  public Flight(String airline, int flightNumber, String airlineCode) {
    this.airline = airline;
    this.flightNumber = flightNumber;
    this.airlineCode = airlineCode;
  }

  @Override
  public int hashCode() {
    // We reuse hashcode for a String here
    return getFlightID().hashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other)
      return true;
    if (other == null)
      return false;
    if (getClass() != other.getClass())
      return false;
    Flight otherFlight = (Flight) other; // We have to cast Object as Flight
    // We reuse the equals method for a string here
    return getFlightID().equals(otherFlight.getFlightID());
  }

  public int getFlightNumber() {
    return flightNumber;
  }

  public String getFlightID() {
    return airlineCode + flightNumber;
  }

  public String getAirlineCode() {
    return airlineCode;
  }

  @Override
  public int compareTo(Flight o) {
    return this.getFlightID().compareTo(o.getFlightID());
  }

  @Override
  public String toString() {
    return "Flight{" + "airline='" + airline + '\'' + ", flightNumber=" + flightNumber
        + ", airlineCode='" + airlineCode + '\'' + '}';
  }

  public static void main(String[] args) {
    Flight f1 = new Flight("Delta", 123, "DL");
    Flight f2 = new Flight("American", 456, "AA");
    Flight f3 = new Flight("United", 789, "UA");

    System.out.println(f1.compareTo(f2));
    System.out.println(f2.compareTo(f3));
    System.out.println(f3.compareTo(f1));

    List<Flight> flights = new ArrayList<>();
    // can't use list.of() only, as it returns an immutable list, so we add one to
    // new list
    flights.addAll(List.of(f1, f2, f3));

    System.out.println(flights);

    Set<Flight> flightSet = new TreeSet<>(flights);
    System.out.println(flightSet);

    flights.sort(null);
    System.out.println(flights);

    flights.sort((flight1, flight2) -> flight1.getFlightNumber() - flight2.getFlightNumber());
    System.out.println(flights);
    TreeMap<Flight, Integer> flightSeats = new TreeMap<>();

    // assuming F1, F2, F3 are already created
    flightSeats.put(f1, 100);
    flightSeats.put(f2, 200);
    flightSeats.put(f3, 300);

    System.out.println(flightSeats);

  }
}
