package fr.univamu.progav.td.td2;

import org.junit.jupiter.api.Test;

import static fr.univamu.progav.td.td2.ASimpleLoop.nonTerminatingSum;
import static org.junit.jupiter.api.Assertions.*;

class ASimpleLoopTest {

  @Test
  void nonTerminatingSumTest() {
    double result = nonTerminatingSum(10);
    assertEquals(505,result);
  }
}