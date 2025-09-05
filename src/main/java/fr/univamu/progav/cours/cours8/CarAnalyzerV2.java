package fr.univamu.progav.cours.cours8;

import java.util.List;
import java.util.NoSuchElementException;

public class CarAnalyzerV2 {
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
    return cars.stream()
      .filter(car -> "Vaillante".equals(car.brand()))
      .filter(car -> car.hasAutomaticTransmission())
      .filter(car -> car.topSpeed() >= 200)
      .mapToInt(car -> car.productionYear())
      .average()
      .orElseThrow(() -> new NoSuchElementException());
  }


  public static void main(String[] args) {
    System.out.println(averageAgeOfFastAutomaticVaillanteCars(cars));
  }
}


// structure simple (plus de if, de for, de variables à gérer), donc :
// - difficile de faire une erreur
// - plus facile à lire (le code décrit l'intention, et non le calcul)