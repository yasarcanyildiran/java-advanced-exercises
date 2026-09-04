package fr.univamu.progav.td.td3;

import fr.univamu.progav.td.td3.ExoList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ExoListTest {

  @Test
  void initList() {
    assertEquals(List.of(0,1,2,3,4), ExoList.initList(5));
    assertEquals(List.of(0,1,2,3,4,5,6,7,8,9), ExoList.initList(10));
    assertEquals(List.of(), ExoList.initList(0));
    List<Integer> l1000 = ExoList.initList(1000);
    assertEquals(1000, l1000.size());
    assertEquals(532, l1000.get(532));
    assertEquals(763, l1000.get(763));
    assertEquals(923, l1000.get(923));
  }

  @Test
  void addOneEverywhere() {
    List<Integer> l1 = new ArrayList<>(List.of(0,1,2,3,4));
    ExoList.addOneEverywhere(l1);
    assertEquals(List.of(1,2,3,4,5), l1);
    List<Integer> l2 = new ArrayList<>(List.of(9,-1,3,6,-4));
    ExoList.addOneEverywhere(l2);
    assertEquals(List.of(10,0,4,7,-3), l2);
    List<Integer> l3 = new ArrayList<>();
    ExoList.addOneEverywhere(l3);
    assertEquals(List.of(), l3);
  }

  @Test
  void duplicate() {
    List<Integer> l1 = new ArrayList<>(List.of(0,1,2,3,4));
    ExoList.duplicate(l1);
    assertEquals(List.of(0,1,2,3,4,0,1,2,3,4), l1);
    List<Integer> l2 = new ArrayList<>(List.of(0,1));
    ExoList.duplicate(l2);
    assertEquals(List.of(0,1,0,1), l2);
    List<Integer> l3 = new ArrayList<>();
    ExoList.duplicate(l3);
    assertEquals(List.of(), l3);
  }
}