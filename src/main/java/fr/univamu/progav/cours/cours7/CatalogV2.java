package fr.univamu.progav.cours.cours7;

import java.util.ArrayList;
import java.util.List;

public class CatalogV2 {

  private final List<Car> cars = new ArrayList<>();

  public CatalogV2() {
    cars.add(new Car("Vaillante", "1985", 18000));
    cars.add(new Car("Vaillante", "1983", 14500));
    cars.add(new Car("Anvil Motors", "2015", 24800));
  }


  public static void main(String[] args) {
    CatalogV2 catalog = new CatalogV2();
    for (Car car : catalog.selectByBrand("Vaillante")) {
      System.out.println(car);
    }
  }

  // on introduit l'interface pour les comportements distincts
  public interface CarPredicate {
    boolean isValid(Car car);
  }

  // on délègue à l'interface les comportements distincts
  public List<Car> selectByCriterion(CarPredicate predicate) {
    List<Car> selection = new ArrayList<>();
    for (Car car : cars) {
      if (predicate.isValid(car)) {
        selection.add(car);
      }
    }
    return selection;
  }

  // on spécialise en définissant des objets à qui déléguer
  private static class MaxPriceCriterion implements CarPredicate {
    private final double maxPrice;

    MaxPriceCriterion(double maxPrice) {
      this.maxPrice = maxPrice;
    }

    @Override
    public boolean isValid(Car car) {
      return car.price() <= maxPrice;
    }
  }

  public List<Car> selectByMaxPrice(int maxPrice) {
    return selectByCriterion(new MaxPriceCriterion(maxPrice));
  }

  private static class HasBrand implements CarPredicate {
    private final String brandName;

    public HasBrand(String brandName) {
      this.brandName = brandName;
    }

    @Override
    public boolean isValid(Car car) {
      return brandName.equals(car.brand());
    }
  }


  public List<Car> selectByBrand(String brandName) {
    return selectByCriterion(new HasBrand(brandName));
  }


  // On a factorisé les comportements distincts, mais :
  // Problèmes :
  // - c'est plus verbeux et long que la solution initiale
  // - que faire si on veut sélectionner les voitures d'une marque et
  // d'un prix limité simultanément ?

  // Solution partielle :
  // utiliser une syntaxe abrégée pour créer les objets prédicats.
}
