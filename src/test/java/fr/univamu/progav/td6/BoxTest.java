package fr.univamu.progav.td6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

  @Test
  void testGet() {
    Lens<Integer> box = new Box(0);
    assertEquals(0,box.get());
    box = new Box(42);
    assertEquals(42,box.get());
  }

  @Test
  void testSet() {
    Lens<Integer> box = new Box(0);
    box.set(3);
    assertEquals(3,box.get());
    box.set(5);
    assertEquals(5,box.get());
    box.set(-3);
    assertEquals(-3,box.get());
  }


  @Test
  void genericBox() {
    Lens<String> box = null; // TODO créer une boîte contenant "foo"
    assertEquals("foo", box.get());
    box.set("bar");
    assertEquals("bar", box.get());
    Lens<Lens<Integer>> boxbox = null; // TODO créer une boîte contenant une boîte contenant 0
    boxbox.get().set(2);
    assertEquals(2,boxbox.get().get());
  }

}