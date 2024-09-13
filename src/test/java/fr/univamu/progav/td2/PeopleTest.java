package fr.univamu.progav.td2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static fr.univamu.progav.td2.People.whereIsCharlie;
import static org.junit.jupiter.api.Assertions.*;

class PeopleTest {

  private final List<People> peopleList =
    List.of(
      new People("Alfa", 12),
      new People("Bravo", 18),
      new People("Charlie", 25),
      new People("Delta", 36),
      new People("Echo", 8),
      new People("Foxtrot", 11),
      new People("Golf", 21),
      new People("Hotel", 53),
      new People("India", 42),
      new People("Juliett", 28)
    );


  @Test
  void whereIsCharlieTest() {
    int charliePosition = whereIsCharlie(peopleList);
    assertEquals(2, charliePosition);
    List<People> noCharlie =
      peopleList.stream().filter(p -> !p.getName().equals("Charlie")).toList();
    int noCharliePosition = whereIsCharlie(noCharlie);
    assertEquals(-1, noCharliePosition);
  }
}