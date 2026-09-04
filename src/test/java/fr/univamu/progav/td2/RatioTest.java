package fr.univamu.progav.td2;

import fr.univamu.progav.td.td2.Ratio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatioTest {


  @Test
  void plusTest() {
    assertEquals(Ratio.unsafeOf(2,1),Ratio.of(1,1).plus(Ratio.of(1,1)));
    assertEquals(Ratio.unsafeOf(5,6),Ratio.of(1,3).plus(Ratio.of(1,2)));
    assertEquals(Ratio.unsafeOf(1,6),Ratio.of(-1,3).plus(Ratio.of(1,2)));
    assertEquals(Ratio.unsafeOf(-1,6),Ratio.of(1,3).plus(Ratio.of(-1,2)));
    assertEquals(Ratio.unsafeOf(-5,6),Ratio.of(-1,3).plus(Ratio.of(-1,2)));
    assertEquals(Ratio.unsafeOf(-5,6),Ratio.of(1,-3).plus(Ratio.of(1,-2)));
    assertEquals(Ratio.unsafeOf(5,6),Ratio.of(-1,-3).plus(Ratio.of(1,2)));
  }

}