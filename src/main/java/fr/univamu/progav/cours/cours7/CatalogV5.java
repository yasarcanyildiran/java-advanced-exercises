package fr.univamu.progav.cours.cours7;

import java.util.ArrayList;
import java.util.List;

public class CatalogV5 {

  private final List<Car> cars = new ArrayList<>();

  public CatalogV5() {
    cars.add(new Car("Vaillante", "1985", 18000));
    cars.add(new Car("Vaillante", "1983", 14500));
    cars.add(new Car("Anvil Motors", "2015", 24800));
  }



  // En utilisant des méthodes par défaut, on peut ajouter des combinateurs
  // permettant de manipuler les prédicats

  @FunctionalInterface
  public interface CarPredicate {
    boolean isValid(Car car);

    default CarPredicate negate() {
      return car -> !this.isValid(car);
    }

    default CarPredicate and(CarPredicate predicate) {
      return car -> this.isValid(car) && predicate.isValid(car);
    }

    default CarPredicate or(CarPredicate predicate) {
      return car -> this.isValid(car) || predicate.isValid(car);
    }
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


  // Ce sera plus pratique d'avoir les prédicats à disposition, pour
  // pouvoir les combiner

  private CarPredicate hasMaxPrice(int maxPrice) {
    return car -> car.price() <= maxPrice;
  }

  private CarPredicate hasBrand(String brand) {
    return car -> brand.equals(car.brand());
  }

  public List<Car> selectByMaxPrice(int maxPrice) {
    return selectByCriterion(hasMaxPrice(maxPrice));
  }


  public List<Car> selectByBrand(String brandName) {
    return selectByCriterion(hasBrand(brandName));
  }

  public List<Car> selectByPriceAndBran(int maxPrice, String brandName) {
    return selectByCriterion(hasMaxPrice(maxPrice).and(hasBrand(brandName)));
  }


  public static void main(String[] args) {
    CatalogV5 catalog = new CatalogV5();
    for (Car car : catalog.selectByCriterion(catalog.hasMaxPrice(15000).and(catalog.hasBrand("Vaillante")))) {
      System.out.println(car);
    }
  }


  // Conclusion :
  // Solution concise et modulable !
}
