package fr.univamu.progav.cours.cours7;

import java.util.ArrayList;
import java.util.List;

public class CatalogV1 {

  private final List<Car> cars = new ArrayList<>();

  public CatalogV1() {
    cars.add(new Car("Vaillante", "1985", 18000));
    cars.add(new Car("Vaillante", "1983", 14500));
    cars.add(new Car("Anvil Motors", "2015", 24800));
  }


  public static void main(String[] args) {
    CatalogV1 catalog = new CatalogV1();
    for (Car car : catalog.selectByBrand("Vaillante")) {
      System.out.println(car);
    }
  }

  public List<Car> selectByMaxPrice(int maxPrice) {
    List<Car> selection = new ArrayList<>();
    for (Car car : cars) {
      if (car.price() <= maxPrice) {
        selection.add(car);
      }
    }
    return selection;
  }

  public List<Car> selectByBrand(String brandName) {
    List<Car> selection = new ArrayList<>();
    for (Car car : cars) {
      if (car.brand().equals(brandName)) {
        selection.add(car);
      }
    }
    return selection;
  }

  // Problèmes :
  // - répétitions entre les deux méthodes
  // - que faire si on veut sélectionner les voitures d'une marque et
  // d'un prix limité simultanément ?

  // Solution partielle :
  // factoriser les comportements communs, et utiliser une interface pour
  // les comportements distincts, comme nous savons le faire.
}
