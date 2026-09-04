package fr.univamu.progav.td.td3;

import fr.univamu.progav.td.td3.ExoArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExoArrayTest {

  @Test
  void initArray() {
    int[] a4 = ExoArray.initArray(4);
    assertArrayEquals(new int[]{0,-1,2,3}, a4);
    int[] a10 = ExoArray.initArray(10);
    assertArrayEquals(new int[]{0,-1,2,3,-4,5,6,-7,8,9}, a10);
    int[] a0 = ExoArray.initArray(0);
    assertEquals(0, a0.length);
    int[] a10000 = ExoArray.initArray(10000);
    assertEquals(10000, a10000.length);
  }

  @Test
  void sumEvenPositions() {
    int[] a1 = {0,1,2,3,4,5,6};
    assertEquals(12, ExoArray.sumEvenPositions(a1));
    int[] a2 = {0,1,2,3,4,5,6,7};
    assertEquals(12, ExoArray.sumEvenPositions(a2));
    int[] a3 = {5,3,7,-2,-4,-8,1,-2,8,-3,3,10};
    assertEquals(20, ExoArray.sumEvenPositions(a3));
  }

  @Test
  void shiftToLeft() {
    int[] a1 =  {1,2,3,4,5};
    ExoArray.shiftToLeft(a1);
    assertArrayEquals(new int[] {2,3,4,5,1}, a1);
    int[] a2 = {1,2};
    ExoArray.shiftToLeft(a2);
    assertArrayEquals(new int[] {2,1},a2);
    int[] a3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    ExoArray.shiftToLeft(a3);
    assertArrayEquals(new int[] {8,7,6,5,4,3,2,1,0,9}, a3);
    int[] a4 = {};
    ExoArray.shiftToLeft(a4);
    assertArrayEquals(new int[]{}, a4);

  }
}