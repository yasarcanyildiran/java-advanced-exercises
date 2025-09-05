package fr.univamu.progav.cours.cours4.TrainTicket;

import java.time.LocalDateTime;

public record BookingTicket(
      Station departure,
      Station destination,
      String seat,
      LocalDateTime departureTime,
      LocalDateTime arrivalTime) implements TrainTicket {
}
