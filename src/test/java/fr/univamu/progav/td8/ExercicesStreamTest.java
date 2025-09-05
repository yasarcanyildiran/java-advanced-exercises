package fr.univamu.progav.td8;

import fr.univamu.progav.td.td8.ExercicesStream;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static fr.univamu.progav.td.td8.ExercicesStream.Person;
import static org.junit.jupiter.api.Assertions.*;

class ExercicesStreamTest {

  private record MockPerson(
    int age,
    String name,
    boolean isFemale,
    Person mother,
    Person father,
    List<Person> children
  ) implements Person {
    @Override
    public String toString() {
      return this.name;
    }
  }

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
  private static Stream<Person> femaleStream() {
    return Stream.of(alfa, echo, foxtrot, golf, india);
  }
  private static Stream<Person> maleStream() {
    return Stream.of(bravo,charlie,delta,hotel,juliett);
  }
  @Test
  void hasFemale() {
    assertTrue(ExercicesStream.hasFemale(ALL.stream()));
    assertFalse(ExercicesStream.hasFemale(Stream.of(bravo,charlie,delta)));
    assertTrue(ExercicesStream.hasFemale(Stream.of(alfa)));
    assertFalse(ExercicesStream.hasFemale(Stream.of()), "Cas de la stream vide");
  }

  @Test
  void containsMinorMale() {
    assertTrue(ExercicesStream.containsMinorMale(ALL.stream()));
    assertFalse(ExercicesStream.containsMinorMale(Stream.of(bravo,charlie,delta)), "Pas de mineurs");
    assertFalse(ExercicesStream.containsMinorMale(Stream.of(foxtrot,india)), "Pas d'hommes");
    assertFalse(ExercicesStream.containsMinorMale(Stream.of()), "Cas de la stream vide");
  }

  @Test
  void findMother() {
    Optional<Person> found = ExercicesStream.findMother(ALL.stream());
    assertTrue(found.isPresent());
    assertTrue(found.get().isFemale() && !found.get().children().isEmpty());
    assertEquals(Optional.of(golf),ExercicesStream.findMother(Stream.of(bravo,charlie,delta,golf,hotel,india)));
    assertEquals(Optional.empty(), ExercicesStream.findMother(Stream.of(bravo,charlie,delta,foxtrot,hotel,india)));
    assertEquals(Optional.empty(), ExercicesStream.findMother(Stream.of()), "Cas de la stream vide");
  }

  @Test
  void areAllMajor() {
    assertFalse(ExercicesStream.areAllMajor(ALL.stream()));
    assertTrue(ExercicesStream.areAllMajor(Stream.of(alfa,bravo,charlie,delta,echo,golf)));
    assertTrue(ExercicesStream.areAllMajor(Stream.of(alfa,bravo,charlie,delta,echo,golf,juliett)), "Cas d'un individu ayant 18 ans");
    assertFalse(ExercicesStream.areAllMajor(Stream.of(foxtrot,hotel,india)));
    assertTrue(ExercicesStream.areAllMajor(Stream.of()), "Cas de la stream vide");
  }

  @Test
  void ageOfSomeChild() {
    Optional<Integer> maybeAge =
      ExercicesStream.ageOfSomeChild(Stream.of(hotel, india, juliett, alfa, foxtrot, charlie));
    assertTrue(maybeAge.isPresent());
    assertTrue(List.of(charlie.age(),delta.age()).contains(maybeAge.get()));
    assertTrue(ExercicesStream.ageOfSomeChild(Stream.of(charlie,foxtrot,hotel,india,juliett)).isEmpty());
    assertTrue(ExercicesStream.ageOfSomeChild(Stream.of()).isEmpty(),"Cas de la stream vide");
  }

  @Test
  void males() {
    List<Person> allMales = ExercicesStream.males(ALL.stream());
    List<Person> expected = ALL.stream().filter(p -> !p.isFemale()).toList();
    assertNotNull(allMales);
    assertEquals(expected.size(), allMales.size(), "Nombre d'hommes incorrect");
    for (Person p : expected ) {
      assertTrue(allMales.contains(p), p.name() + " est un homme qui n'est pas dans la stream");
    }
    List<Person> neitherMaleNorFemale = ExercicesStream.males(femaleStream());
    assertNotNull(neitherMaleNorFemale);
    assertTrue(neitherMaleNorFemale.isEmpty());
    List<Person> empty = ExercicesStream.males(Stream.of());
    assertNotNull(empty, "Cas de la stream vide");
    assertTrue(empty.isEmpty(), "Cas de la stream vide");
  }

  @Test
  void nbFemales() {
    assertEquals(0,ExercicesStream.nbFemales(Stream.of()), "Cas de la stream vide");
    assertEquals(5,ExercicesStream.nbFemales(ALL.stream()));
    assertEquals(0,ExercicesStream.nbFemales(maleStream()));
  }

  @Test
  void eldest() {
    assertTrue(ExercicesStream.eldest(Stream.of()).isEmpty(), "Cas de la stream vide");
    assertEquals(Optional.of(bravo),ExercicesStream.eldest(ALL.stream()));
  }

  @Test
  void names() {
    String allNames = ExercicesStream.names(ALL.stream()).trim();
    assertEquals("Alfa Bravo Charlie Delta Echo Foxtrot Golf Hotel India Juliett",allNames);
    assertEquals("",ExercicesStream.names(Stream.of()), "Cas de la liste vide");
  }

  @Test
  void hasAsManyMalesAsFemales() {
    assertTrue(ExercicesStream.hasAsManyMalesAsFemales(Stream.of()), "Cas de la liste vide");
    assertFalse(ExercicesStream.hasAsManyMalesAsFemales(Stream.of(alfa)));
    assertFalse(ExercicesStream.hasAsManyMalesAsFemales(Stream.of(bravo)));
    assertFalse(ExercicesStream.hasAsManyMalesAsFemales(femaleStream()));
    assertFalse(ExercicesStream.hasAsManyMalesAsFemales(maleStream()));
    assertTrue(ExercicesStream.hasAsManyMalesAsFemales(ALL.stream()));
  }

  @Test
  void averageAge() {
    assertTrue(ExercicesStream.averageAge(Stream.of()).isEmpty(), "Cas de la liste vide");
    OptionalDouble average = ExercicesStream.averageAge(ALL.stream());
    assertTrue(average.isPresent());
    double expected = 34.1;
    assertTrue(Math.abs(average.getAsDouble() - expected) < 0.1, "La moyenne correcte est " + expected);
  }
}