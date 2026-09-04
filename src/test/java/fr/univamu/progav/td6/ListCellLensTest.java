package fr.univamu.progav.td6;

import fr.univamu.progav.td.td6.Lens;
import fr.univamu.progav.td.td6.ListCellLens;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListCellLensTest {

  @Test
  void testGet() {
    List<Integer> list = new ArrayList<>(List.of(4,3,2,1));
    Lens<Integer> lens1 = new ListCellLens<>(list, 1);
    assertEquals(3, lens1.get());
    list.set(1,5);
    assertEquals(5, lens1.get());
  }

  @Test
  void testSet() {
    List<Integer> list = new ArrayList<>(List.of(4,3,2,1));
    Lens<Integer> lens1 = new ListCellLens<>(list, 1);
    lens1.set(8);
    assertEquals(8, lens1.get());
  }


  @Test
  void testSetModifyList() {
    List<Integer> list = new ArrayList<>(List.of(4,3,2,1));
    Lens<Integer> lens1 = new ListCellLens<>(list, 1);
    lens1.set(5);
    assertEquals(5, lens1.get());
    assertEquals(5, list.get(1));
    assertEquals(4, list.get(0));
    assertEquals(2, list.get(2));
  }

}