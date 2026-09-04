package fr.univamu.progav.td.td3;

import fr.univamu.progav.td.td3.ExoMap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExoMapTest {

  @Test
  void test1() {
    List<String> words = List.of("alfa", "bravo", "charlie", "alfa", "charlie", "delta");
    ExoMap counter = new ExoMap();
    counter.count(words);
    assertEquals(2,counter.countOf("alfa"));
    assertEquals(1,counter.countOf("bravo"));
    assertEquals(2,counter.countOf("charlie"));
    assertEquals(1,counter.countOf("delta"));
    assertEquals(0,counter.countOf("echo"));
    counter.count("delta");
    assertEquals(2,counter.countOf("alfa"));
    assertEquals(1,counter.countOf("bravo"));
    assertEquals(2,counter.countOf("charlie"));
    assertEquals(2,counter.countOf("delta"));
    assertEquals(0,counter.countOf("echo"));
  }

  void test2() {
    List<String> words = List.of("alfa", "alfa", "bravo", "charlie", "bravo", "alfa", "charlie", "delta", "echo", "echo", "echo", "echo");
    ExoMap counter = new ExoMap();
    counter.count(words);
    assertEquals(3,counter.countOf("alfa"));
    assertEquals(2,counter.countOf("bravo"));
    assertEquals(2,counter.countOf("charlie"));
    assertEquals(1,counter.countOf("delta"));
    assertEquals(4,counter.countOf("echo"));
  }

  void testEmpty() {
    ExoMap counter = new ExoMap();
    counter.count(List.of());
    assertEquals(0,counter.countOf("alfa"));
    assertEquals(0,counter.countOf("bravo"));
    assertEquals(0,counter.countOf("charlie"));
  }
}