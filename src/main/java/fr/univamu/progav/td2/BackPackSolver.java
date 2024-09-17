package fr.univamu.progav.td2;

import java.util.ArrayList;
import java.util.List;

public class BackPackSolver {



  private final List<Item> allItems;
  private final List<Item> currentBackpack = new ArrayList<>();
  private final int availableVolume;

  public BackPackSolver(List<Item> allItems, int availableVolume) {
    this.allItems = allItems;
    this.availableVolume = availableVolume;
  }


  public List<Item> findBestValueBackpack(int nextItemIndex) {
    if (nextItemIndex >= allItems.size()) {
      return new ArrayList<>(currentBackpack);
    }
    List<Item> backpack1 = findBestValueBackpack(nextItemIndex+1);
    int currentVolume = sumVolumes(currentBackpack);
    if (currentVolume + allItems.get(nextItemIndex).volume > availableVolume) {
      return backpack1;
    }
    currentBackpack.add(allItems.get(nextItemIndex));
    List<Item> backpack2 = findBestValueBackpack(nextItemIndex+1);
    return selectBestBackpack(backpack1, backpack2);
  }



  private List<Item> selectBestBackpack(List<Item> backpack1, List<Item> backpack2) {
    int value1 = sumValues(backpack1);
    int value2 = sumValues(backpack2);
    return (value1 >= value2)? backpack1 : backpack2;
  }

  public record Item(String name,int volume, int value) {
    @Override
    public String toString() {
      return name + " (Volume=" + volume + ", value=" + value + ")";
    }
  }

  private static int sumValues(List<Item> backpack1) {
    return backpack1.stream().mapToInt(Item::value).sum();
  }

  private int sumVolumes(List<Item> backpack) {
    return backpack.stream().mapToInt(Item::volume).sum();
  }

}
