package fr.univamu.progav.td.td3;

import fr.univamu.progav.td.td3.ExoQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExoQueueTest {

  @Test
  void unit() {
    ExoQueue q = new ExoQueue();
    q.addValue(8);
    assertEquals(1,q.nbRemainingValues());
    assertEquals(8,q.topValue());
  }

  @Test
  void addition() {
    ExoQueue q = new ExoQueue();
    q.addValue(3);
    q.addValue(5);
    assertEquals(2, q.nbRemainingValues());
    q.performAddition();
    assertEquals(1, q.nbRemainingValues());
    assertEquals(8,q.topValue());
  }

  @Test
  void multiplication() {
    ExoQueue q = new ExoQueue();
    q.addValue(3);
    q.addValue(5);
    q.addValue(2);
    assertEquals(3, q.nbRemainingValues());
    q.performMultiplication();
    assertEquals(2, q.nbRemainingValues());
    assertEquals(10,q.topValue());
    q.performMultiplication();
    assertEquals(1, q.nbRemainingValues());
    assertEquals(30,q.topValue());
  }


  // evaluate 3 5 2 x 1 + -4 7 + + *
  @Test
  void sequence() {
    ExoQueue q = new ExoQueue();
    q.addValue(3);
    q.addValue(5);
    q.addValue(2);
    q.performMultiplication();
    q.addValue(1);
    q.performAddition();
    q.addValue(-4);
    q.addValue(7);
    q.performAddition();
    q.performAddition();
    q.performMultiplication();
    assertEquals(1,q.nbRemainingValues());
    assertEquals(42,q.topValue());
  }

}