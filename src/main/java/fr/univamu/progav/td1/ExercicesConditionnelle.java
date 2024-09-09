package fr.univamu.progav.td1;

import java.util.List;

public class ExercicesConditionnelle {


  // Exercice 1 : selon la couleur du feu et la présence d'autres véhicules,
  // décider si la voiture avance ou s'arrête.

  public interface Car {
    void go();
    void stop();
  }
  public interface TrafficLight {
    boolean isGreen();
    boolean isRed();
    boolean isYellow();
  }
  public interface CrossRoad {
    boolean isFree(); // le carrefour est libre de toute autre voiture
  }

  // La méthode decideStopOrGo doit appeler soit car.stop(), soit car.go(), correctement.
  public static void decideStopOrGo(Car car, TrafficLight light, CrossRoad crossRoad) {
    return;
  }






  // Exercice 2 : On souhaite calculer le tarif d’un billet de train pour une
  // personne. Le tarif normal est de 10 euros, les mineurs et les sans-emplois
  // bénéficient d’un tarif réduit à 5 euros. Enfin, les personnes ayant un
  // abonnement annuel ne paient rien.

  public interface Costumer {
    int age();
    boolean isUnemployed();
    boolean hasAnnualSubscription();
  }

  public static double getPrice(Costumer costumer) {
    return 0;
  }





  // Exercice 3 : Décider si une année est bissextile.
  // Les années bissextiles ont lieu tous les 4 ans.
  // Sauf les dernières années de chaque siècle (1900, 2100 ne sont pas bissextiles)
  // Sauf tous les 4 siècles (1600, 2000, 2400 sont bissextiles)

  public static boolean isLeapYear(int year) {
    // n % p == 0 teste la divisibilité de n par p
    // (car n % p est le reste de la division de n par p)
    return false;
  }





  // Exercice 4 : calculer le jour suivant.
  // On reçoit une date,
  // par exemple day=11, month=09, year=2024 pour le 11 septembre 2024.
  // On doit retourner la date du lendemain, sous forme d'une chaîne
  // de caractère, dans l'exemple "12/09/2024".

  public final static List<Integer> MONTHS =
    List.of( 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 );

  public static String nextDayString(int day, int month, int year) {
    int nextDay = day;
    int nextMonth = month;
    int nextYear = year;

    // Mise au format de la date (ne pas modifier) :
    return String.format("%02d/%02d/%02d", nextDay, nextMonth, nextYear);
  }

}
