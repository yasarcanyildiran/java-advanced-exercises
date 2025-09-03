package fr.univamu.progav.cours4.TrainTicket;

public sealed interface TrainTicket
  permits StandardTicket, BookingTicket, UnlimitedTicket
{


  // switch instructionnel
  static boolean isDeparture(TrainTicket ticket, Station station) {
    switch (ticket) {
      case StandardTicket stdTicket :
        return stdTicket.departure().equals(station);
      case BookingTicket bkgTicket :
        return bkgTicket.departure().equals(station);
      case UnlimitedTicket ultdTicket :
        return true; // any station is a possible departure
    }
  }

  // switch expressionnel
  static boolean isDestination(TrainTicket ticket, Station station) {
    return switch (ticket) {
      case StandardTicket stdTicket -> stdTicket.destination().equals(station);
      case BookingTicket bkgTicket -> bkgTicket.destination().equals(station);
      case UnlimitedTicket _ -> true;
    };
  }

}
