package fr.univamu.progav.td6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCellLensTest {

  @Test
  void testGet() {
    Integer[] array = {4, 3, 2, 1};
    Lens<Integer> lens1 = new ArrayCellLens<>(array, 1);
    assertEquals(3, lens1.get());
    array[1] = 5;
    assertEquals(5, lens1.get());
  }

  @Test
  void testSet() {
    Integer[] array = {4, 3, 2, 1};
    Lens<Integer> lens1 = new ArrayCellLens<>(array, 1);
    lens1.set(8);
    assertEquals(8, lens1.get());
  }


  @Test
  void testSetModifyArray() {
    Integer[] array = {4, 3, 2, 1};
    Lens<Integer> lens1 = new ArrayCellLens<>(array, 1);
    lens1.set(5);
    assertEquals(5, lens1.get());
    assertEquals(5, array[1]);
    assertEquals(4, array[0]);
    assertEquals(2, array[2]);
  }

}
