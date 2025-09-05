package fr.univamu.progav.cours.cours7;

import java.util.ArrayList;
import java.util.List;

public class CatalogV3 {

  private final List<Car> cars = new ArrayList<>();

  public CatalogV3() {
    cars.add(new Car("Vaillante", "1985", 18000));
    cars.add(new Car("Vaillante", "1983", 14500));
    cars.add(new Car("Anvil Motors", "2015", 24800));
  }


  public static void main(String[] args) {
    CatalogV3 catalog = new CatalogV3();
    for (Car car : catalog.selectByBrand("Vaillante")) {
      System.out.println(car);
    }
  }


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



  public List<Car> selectByMaxPrice(int maxPrice) {
    return selectByCriterion(new CarPredicate() {
      @Override
      public boolean isValid(Car car) {
        return car.price() <= maxPrice;
      }
    });
  }



  public List<Car> selectByBrand(String brandName) {
    return selectByCriterion(new CarPredicate() {
      @Override
      public boolean isValid(Car car) {
        return brandName.equals(car.brand());
      }
    });
  }



  // L'utilisation de classes anonymes réduit la verbosité
  // Problèmes :
  // - cela reste un peu long, et très peu lisible.
  // - que faire si on veut sélectionner les voitures d'une marque et
  // d'un prix limité simultanément ?

  // Solution partielle :
  // utiliser une syntaxe encore plus abrégée pour créer les objets prédicats.
}
