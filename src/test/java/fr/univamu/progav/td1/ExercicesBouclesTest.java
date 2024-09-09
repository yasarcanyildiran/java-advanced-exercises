package fr.univamu.progav.td1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import static fr.univamu.progav.td1.ExercicesBoucles.Person;

class ExercicesBouclesTest {

  private record MockPerson(
    int age,
    String name,
    boolean isFemale,
    Person mother,
    Person father,
    List<Person> children
  ) implements Person {}

  private static final Person alfa =
    new MockPerson(78,"Alfa",true,null,null, new ArrayList<>());
  private static final Person bravo =
    new MockPerson(82,"Bravo",false,null,null, new ArrayList<>());
  private static final Person charlie =
    new MockPerson(42,"Charlie",false, alfa,bravo,List.of());
  private static final Person delta =
    new MockPerson(38,"Delta",false, alfa,bravo, new ArrayList<>());
  private static final Person echo =
    new MockPerson(41,"Echo",true,null,null, new ArrayList<>());
  private static final Person foxtrot =
    new MockPerson(7,"Foxtrot",true,echo,delta, List.of());
  private static final Person golf =
    new MockPerson(25,"Golf",true,null,null, new ArrayList<>());
  private static final Person hotel =
    new MockPerson(2,"Hotel",false,golf,null, List.of());
  private static final Person india =
    new MockPerson(8,"India",true,null,null, List.of());
  private static final Person juliett =
    new MockPerson(18,"Juliett",false,null,null,List.of());

  static {
    alfa.children().addAll(List.of(charlie, delta));
    bravo.children().addAll(List.of(charlie, delta));
    delta.children().add(foxtrot);
    echo.children().add(foxtrot);
    golf.children().add(hotel);
  }

  private static final List<Person> ALL =
    List.of(alfa,bravo,charlie,delta,echo,foxtrot,golf,hotel,india,juliett);

  @Test
  void hasFemale() {
    assertTrue(ExercicesBoucles.hasFemale(ALL));
    assertFalse(ExercicesBoucles.hasFemale(ALL.stream().filter(p -> !p.isFemale()).toList()));
    assertTrue(ExercicesBoucles.hasFemale(List.of(alfa)));
    assertFalse(ExercicesBoucles.hasFemale(List.of()), "Cas de la liste vide");
  }

  @Test
  void containsMinorMale() {
    assertTrue(ExercicesBoucles.containsMinorMale(ALL));
    assertFalse(ExercicesBoucles.containsMinorMale(ALL.stream().filter(p -> p.age() >= 18).toList()), "Pas de mineurs");
    assertFalse(ExercicesBoucles.containsMinorMale(ALL.stream().filter(Person::isFemale).toList()), "Pas d'hommes");
    assertFalse(ExercicesBoucles.containsMinorMale(List.of()), "Cas de la liste vide");
  }

  @Test
  void findMother() {
    Person found = ExercicesBoucles.findMother(ALL);
    assertNotNull(found);
    assertTrue(found.isFemale() && !found.children().isEmpty());
    assertEquals(golf,ExercicesBoucles.findMother(List.of(bravo,charlie,delta,golf,hotel,india)));
    assertNull(ExercicesBoucles.findMother(List.of(bravo,charlie,delta,foxtrot,hotel,india)));
    assertNull(ExercicesBoucles.findMother(List.of()), "Cas de la liste vide");
  }

  @Test
  void areAllMajor() {
    assertFalse(ExercicesBoucles.areAllMajor(ALL));
    assertTrue(ExercicesBoucles.areAllMajor(ALL.stream().filter(p -> p.age() > 18).toList()));
    assertTrue(ExercicesBoucles.areAllMajor(ALL.stream().filter(p -> p.age() >= 18).toList()), "Cas d'un individu ayant 18 ans");
    assertFalse(ExercicesBoucles.areAllMajor(ALL.stream().filter(p -> p.age() < 18).toList()));
    assertTrue(ExercicesBoucles.areAllMajor(List.of()), "Cas de la liste vide");
  }

  @Test
  void ageOfSomeChild() {
    assertTrue(List.of(charlie.age(),delta.age()).contains(ExercicesBoucles.ageOfSomeChild(List.of(hotel,india,juliett,alfa,foxtrot,charlie))));
    assertEquals(-1,ExercicesBoucles.ageOfSomeChild(List.of(charlie,foxtrot,hotel,india,juliett)));
    assertEquals(-1,ExercicesBoucles.ageOfSomeChild(List.of()),"Cas de la liste vide");
  }

  @Test
  void males() {
    List<Person> allMales = ExercicesBoucles.males(ALL);
    List<Person> expected = ALL.stream().filter(p -> !p.isFemale()).toList();
    assertNotNull(allMales);
    assertEquals(expected.size(), allMales.size(), "Nombre d'hommes incorrect");
    for (Person p : expected ) {
      assertTrue(allMales.contains(p), p.name() + " est un homme qui n'est pas dans la liste");
    }
    List<Person> neitherMaleNorFemale = ExercicesBoucles.males(ALL.stream().filter(Person::isFemale).toList());
    assertNotNull(neitherMaleNorFemale);
    assertTrue(neitherMaleNorFemale.isEmpty());
    List<Person> empty = ExercicesBoucles.males(List.of());
    assertNotNull(empty, "Cas de la liste vide");
    assertTrue(empty.isEmpty(), "Cas de la liste vide");
  }

  @Test
  void nbFemales() {
    assertEquals(0,ExercicesBoucles.nbFemales(List.of()), "Cas de la liste vide");
    assertEquals(5,ExercicesBoucles.nbFemales(ALL));
    assertEquals(0,ExercicesBoucles.nbFemales(ALL.stream().filter(p -> !p.isFemale()).collect(Collectors.toList())));
  }

  @Test
  void eldest() {
    assertNull(ExercicesBoucles.eldest(List.of()), "Cas de la liste vide");
    assertEquals(bravo,ExercicesBoucles.eldest(ALL));
  }

  @Test
  void names() {
    String allNames = ExercicesBoucles.names(ALL).trim();
    assertEquals("Alfa Bravo Charlie Delta Echo Foxtrot Golf Hotel India Juliett",allNames);
    assertEquals("",ExercicesBoucles.names(List.of()), "Cas de la liste vide");
  }

  @Test
  void hasAsManyMalesAsFemales() {
    assertTrue(ExercicesBoucles.hasAsManyMalesAsFemales(List.of()), "Cas de la liste vide");
    assertFalse(ExercicesBoucles.hasAsManyMalesAsFemales(List.of(alfa)));
    assertFalse(ExercicesBoucles.hasAsManyMalesAsFemales(List.of(bravo)));
    assertFalse(ExercicesBoucles.hasAsManyMalesAsFemales(ALL.stream().filter(Person::isFemale).toList()));
    assertFalse(ExercicesBoucles.hasAsManyMalesAsFemales(ALL.stream().filter(p -> !p.isFemale()).toList()));
    assertTrue(ExercicesBoucles.hasAsManyMalesAsFemales(ALL));
  }

  @Test
  void averageAge() {
    assertEquals(0,ExercicesBoucles.averageAge(List.of()), "Cas de la liste vide");
    double average = ExercicesBoucles.averageAge(ALL);
    double expected = 34.1;
    assertTrue(Math.abs(average - expected) < 0.1, "La moyenne correcte est " + expected);
  }
}