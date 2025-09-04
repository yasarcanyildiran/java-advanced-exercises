package fr.univamu.progav.cours7;

import java.util.ArrayList;
import java.util.List;

public class CatalogV4 {

  private final List<Car> cars = new ArrayList<>();

  public CatalogV4() {
    cars.add(new Car("Vaillante", "1985", 18000));
    cars.add(new Car("Vaillante", "1983", 14500));
    cars.add(new Car("Anvil Motors", "2015", 24800));
  }


  public static void main(String[] args) {
    CatalogV4 catalog = new CatalogV4();
    for (Car car : catalog.selectByBrand("Vaillante")) {
      System.out.println(car);
    }
  }

  // Puisque 'CarPredicate' ne déclare qu'une seule méthode,
  // c'est une interface fonctionnelle, et on peut la déclarer
  // comme telle avec l'annotation '@FunctionalInterface'

  @FunctionalInterface
  public interface CarPredicate {
    boolean isValid(Car car);
  }

  public List<Car> selectByCriterion(CarPredicate predicate) {
    List<Car> selection = new ArrayList<>();
    for (Car car : cars) {
      if (predicate.isValid(car)) {
        selection.add(car);
      }
    }
    return selection;
  }


  // Puisque 'CarPredicate' est une interface fonctionnelle, on peut
  // créer des objets ayant cette interface avec des lambdas
  // (dont la syntaxe est 'arguments -> expression')


  public List<Car> selectByMaxPrice(int maxPrice) {
    return selectByCriterion(car -> car.price() <= maxPrice);
  }


  public List<Car> selectByBrand(String brandName) {
    return selectByCriterion(car -> brandName.equals(car.brand()));
  }



  // L'utilisation des lambdas rend le programme court et lisible
  // Problème restant :
  // - que faire si on veut sélectionner les voitures d'une marque et
  // d'un prix limité simultanément ?

  // Solution partielle :
  // on peut bien sûr faire une lambda adaptée
  // car -> car.price() <= maxPrice && brandName.equals(car.brand())
}
