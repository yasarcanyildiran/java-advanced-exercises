package fr.univamu.progav.td7;

import fr.univamu.progav.td.td7.Interval;
import fr.univamu.progav.td.td7.Sequence;
import org.junit.jupiter.api.Test;

import static fr.univamu.progav.td.td7.IntervalSequences.*;
import static org.junit.jupiter.api.Assertions.*;

class IntervalSequencesTest {

  private final Sequence<Interval> seq1 = new ListSequence<>(
    new Interval(2,8),
    new Interval(-4,5),
    new Interval(3,-2),
    new Interval(-9,-3)
  );
  private final Sequence<Interval> seq2 = new ListSequence<>(
    new Interval(0,0),
    new Interval(0,10),
    new Interval(-10,5),
    new Interval(-3,-3)
  );
  private final Sequence<Interval> seqEmpty = new ListSequence<>();

  @Test
  void testContainsEmptyInterval() {
    assertTrue(containsEmptyInterval(seq1));
    assertFalse(containsEmptyInterval(seq2));
    assertFalse(containsEmptyInterval(seqEmpty));
  }

  @Test
  void testSumOfSizes() {
    assertEquals(24, sumOfSizes(seq1));
    assertEquals(29, sumOfSizes(seq2));
    assertEquals(0, sumOfSizes(seqEmpty));
  }

  @Test
  void testLongestInterval() {
    assertEquals(10,longestInterval(seq1).size());
    assertEquals(16,longestInterval(seq2).size());
    assertNull(longestInterval(seqEmpty));
  }
}