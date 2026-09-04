package fr.univamu.progav.td3;

import fr.univamu.progav.td.td3.ExoSet;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExoSetTest {

  @Test
  void fromList() {
    List<Integer> l1 = List.of(1,2,3,4);
    Set<Integer> set = ExoSet.fromList(l1);
    for (int i : l1) {
      assertTrue(set.contains(i));
    }
    assertEquals(4, set.size());
    List<Integer> l2 = List.of(1,2,3,1,3,2,1,3,4,2,3,1,5,4,2);
    Set<Integer> set2 = ExoSet.fromList(l2);
    for (int i : l2) {
      assertTrue(set2.contains(i));
    }
    assertEquals(5, set2.size());
    Set<Integer> set3 = ExoSet.fromList(List.of());
    assertTrue(set3.isEmpty());
  }

  @Test
  void unionToList() {
    Set<Integer> set1 = Set.of(1,2,4,6);
    Set<Integer> set2 = Set.of(1,3,4,5);
    List<Integer> list = ExoSet.unionToList(set1, set2);
    for (int i : list) {
      assertTrue(set1.contains(i) || set2.contains(i));
    }
    for (int i : set1) {
      assertTrue(list.contains(i));
    }
    for (int i : set2) {
      assertTrue(list.contains(i));
    }
    assertEquals(6, list.size());
  }
}