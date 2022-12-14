package app.services;

import app.entities.Flight;
import app.entities.Seat;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Flight Service
 *
 * @author - Alexander Plekhov
 */

public interface FlightService {
    void save(Flight flight);
    void update(Flight flight);
    Flight findFlightById(long id);
    List<Flight> findFlightByFromToDate(String from, String to, String date);
    List<Flight> findFlightByDepartureDateTime(LocalDateTime localDateTime);
    void deleteById(long id);

    List<Seat> findAllFreeSeatsOnFlight(Flight flight);
    List<Seat> findAllFreeSeatsOnFlightByEconomy(Flight flight);
    List<Seat> findAllFreeSeatsOnFlightByBusiness(Flight flight);
}
