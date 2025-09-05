package fr.univamu.progav.cours.cours4.TrainTicket;

import java.time.LocalDate;

public record UnlimitedTicket(LocalDate startingDay,
                              LocalDate endingDay) implements TrainTicket {
}
