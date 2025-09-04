package fr.univamu.progav.cours8;

import java.util.List;
import java.util.NoSuchElementException;

public class CarAnalyzerV1 {
  private static final List<Car> cars = List.of(
    new Car("Vaillante","Vaillante F1", 340, false, 1999, 1250000),
    new Car("Anvil Motors","Elegy RH8", 250, true, 2006, 90000),
    new Car("Vaillante","Vaillante GT", 270, false, 1994, 110000),
    new Car("Vaillante","Junior", 180, true, 2002, 24000),
    new Car("Anvil Motors","Camper", 150, true, 2003, 65000),
    new Car("Vaillante","NEUILLY", 225, true, 2005, 53500)
    );

  private static final int CURRENT_YEAR = 2025;

  public static double averageAgeOfFastAutomaticVaillanteCars(List<Car> cars) {
    int count = 0;
    int sumAge = 0;
    for (Car car : cars) {
      if (!"Vaillante".equals(car.brand())
        || !car.hasAutomaticTransmission()
        || car.topSpeed() < 200) {
        continue;
      }
      sumAge = sumAge + (CURRENT_YEAR - car.productionYear());
      count++;
    }
    if (count == 0) { throw new NoSuchElementException(); }
    return (double) sumAge / count;
  }


  public static void main(String[] args) {
    System.out.println(averageAgeOfFastAutomaticVaillanteCars(cars));
  }
}

// Problème :
// méthode modérément complexe, difficile à lire. Il serait facile de faire une
// petite erreur et de ne pas s'en rendre compte.
// Solution :
// - découper en plusieurs méthodes (une pour le prédicat, une pour construire
// une liste intermédiaire de voitures qui satisfont les critères, une
// calculant la moyenne)
// - ou bien, utiliser une Stream