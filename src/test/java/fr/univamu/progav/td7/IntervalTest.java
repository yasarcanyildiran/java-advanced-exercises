package fr.univamu.progav.td7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IntervalTest {

  @Test
  void contains() {
    Interval range = new Interval(-2, 5);
    assertTrue(range.contains(-2));
    assertTrue(range.contains(0));
    assertTrue(range.contains(1));
    assertTrue(range.contains(4));
    assertTrue(range.contains(5));
    assertFalse(range.contains(-3));
    assertFalse(range.contains(-30));
    assertFalse(range.contains(6));
    assertFalse(range.contains(42));
    assertFalse(range.contains(2904429));
  }

  @Test
  void size() {
    assertEquals(5, new Interval(0,4).size());
    assertEquals(0, new Interval(4,0).size());
    assertEquals(6, new Interval(4,9).size());
    assertEquals(7, new Interval(-7,-1).size());
    assertEquals(8, new Interval(-3,4).size());
    assertEquals(1, new Interval(3,3).size());
  }

  @Test
  void isEmpty() {
    assertTrue(new Interval(5,3).isEmpty());
    assertTrue(new Interval(2,-5).isEmpty());
    assertTrue(new Interval(0,-1).isEmpty());
    assertTrue(new Interval(1,0).isEmpty());
    assertFalse(new Interval(1,1).isEmpty());
    assertFalse(new Interval(0,0).isEmpty());
    assertFalse(new Interval(-3,3).isEmpty());
  }

  @Test
  void intersects() {
    assertTrue(new Interval(1,5).intersects(new Interval(2,3)));
    assertTrue(new Interval(-5,5).intersects(new Interval(-3,-2)));
    assertTrue(new Interval(-5,5).intersects(new Interval(-2,3)));
    assertTrue(new Interval(-5,5).intersects(new Interval(-6,-5)));
    assertTrue(new Interval(-5,5).intersects(new Interval(5,7)));
    assertTrue(new Interval(-3,4).intersects(new Interval(-4,8)));
    assertFalse(new Interval(-3,4).intersects(new Interval(2,-2)));
    assertFalse(new Interval(-3,4).intersects(new Interval(5,8)));
    assertFalse(new Interval(-3,4).intersects(new Interval(-7,-4)));
    assertFalse(new Interval(-3,4).intersects(new Interval(12,35)));
    assertFalse(new Interval(-3,4).intersects(new Interval(67,-21)));
  }

  @Test
  void iterator() {
    Iterator<Integer> iterator = new Interval(-2,8).iterator();
    List<Integer> elements = new ArrayList<>();
    while (iterator.hasNext()) {
      elements.add(iterator.next());
    }
    assertEquals(List.of(-2,-1,0,1,2,3,4,5,6,7,8), elements);
    assertThrows(NoSuchElementException.class, iterator::next, "Iterator.next() must throw NoSuchElementException when iteration is over");
    iterator = new Interval(0,-1).iterator();
    assertFalse(iterator.hasNext());
    assertThrows(NoSuchElementException.class, iterator::next, "Iterator.next() must throw NoSuchElementException when iteration is over");
  }

}