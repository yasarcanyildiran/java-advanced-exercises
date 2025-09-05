package fr.univamu.progav.td2;

import fr.univamu.progav.td.td2.BackPackSolver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BackPackSolverTest {


  private final static List<BackPackSolver.Item> ITEMS =
    List.of(
      new BackPackSolver.Item("Alfa",5,8),
      new BackPackSolver.Item("Bravo",4,7),
      new BackPackSolver.Item("Charlie",4,6),
      new BackPackSolver.Item("Delta",3,4),
      new BackPackSolver.Item("Echo",2,3)
    );
  public static final int AVAILABLE_VOLUME = 10;

  @Test
  void findBestValueBackpack() {
    BackPackSolver bp = new BackPackSolver(ITEMS, AVAILABLE_VOLUME);
    List<BackPackSolver.Item> selection = bp.findBestValueBackpack(0);
    int totalVolume = selection.stream().mapToInt(BackPackSolver.Item::volume).sum();
    int totalValue = selection.stream().mapToInt(BackPackSolver.Item::value).sum();
    assertTrue(totalVolume <= AVAILABLE_VOLUME);
    assertEquals(16,totalValue);
    assertEquals(3,selection.size());
  }
}