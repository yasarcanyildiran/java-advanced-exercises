package fr.univamu.progav.td2;

import java.util.List;

public class People {

  private final String name;
  private final int age;

  public People(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  /** Decides whether the list contains a 25-year-old "Charlie"
   * @param peopleList
   * @return true if a 25-year-old charlie is in the list
   */
  public static int whereIsCharlie(List<People> peopleList) {
    People charlie = new People("Charlie", 25);
    int count = 0;
    for (People p : peopleList) {
      if (p == charlie) {
        return  count;
      }
      count++;
    }
    return -1; // Charlie is not here.
  }


  @Override
  public String toString() {
    return this.name;
  }
}
