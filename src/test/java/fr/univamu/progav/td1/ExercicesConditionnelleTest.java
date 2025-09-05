package fr.univamu.progav.td1;

import fr.univamu.progav.td.td1.ExercicesConditionnelle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExercicesConditionnelleTest {
   static final class MockCar implements ExercicesConditionnelle.Car {
    int nbGo = 0;
    int nbStop = 0;
    public void go() { nbGo++; }
    public void stop() { nbStop++; }
  }
  enum Light implements ExercicesConditionnelle.TrafficLight {
    RED("rouge"), GREEN("vert"), YELLOW("orange");
    private final String name;
    Light(String name) { this.name = name; }
    public boolean isGreen() { return this == GREEN; }
    public boolean isRed() { return this == RED; }
    public boolean isYellow() { return this == YELLOW; }
  }

  @Test
  void testDecideGo() {
    MockCar car = new MockCar();
    ExercicesConditionnelle.decideStopOrGo(car, Light.GREEN,()->true);
    String situation = "(" + Light.GREEN.name + ",  carrefour libre)";
    assertTrue(1 == car.nbGo + car.nbStop,
      () -> "la voiture doit prendre exactement une décision " + situation);
    assertTrue(0 == car.nbStop,() -> "La voiture ne doit pas s'arrêter au vert " + situation);
    assertTrue(1 == car.nbGo,() -> "La voiture doit s'avancer au vert " + situation);
  }

  @Test
  void testDecideStop() {
     for (Light light : Light.values()) {
       MockCar car = new MockCar();
       ExercicesConditionnelle.decideStopOrGo(car, light,()-> false);
       String situation = "(" + light.name + ",  carrefour occupé)";
       assertTrue(1 == car.nbGo + car.nbStop,
         () -> "la voiture doit prendre exactement une décision " + situation);
       assertTrue(0 == car.nbGo,()-> "La voiture ne doit pas avancer " + situation);
       assertTrue(1 == car.nbStop, () -> "La voiture doit s'arrêter " + situation);
     }
    for (Light light : List.of(Light.YELLOW,Light.RED)) {
      MockCar car = new MockCar();
      ExercicesConditionnelle.decideStopOrGo(car, light,()-> true);
      String situation = "(" + light.name + ",  carrefour libre)";
      assertTrue(car.nbGo + car.nbStop == 1, () -> "la voiture doit prendre exactement une " +
        "décision" +
        "situation");
      assertTrue(car.nbGo == 0,()-> "La voiture ne doit pas avancer " + situation);
      assertTrue(car.nbStop == 1, () -> "La voiture doit s'arrêter " + situation);
    }
  }

  record MockCustomer(
    int age,
    boolean isUnemployed,
    boolean hasAnnualSubscription,
    double price
  ) implements ExercicesConditionnelle.Customer {
    @Override
    public String toString() {
      return "Âge " + age + " "
        + (isUnemployed? "sans emploi ": "")
        + (hasAnnualSubscription? "avec abonnement annuel": "");
    }
  }

  private List<MockCustomer> costumers =
    List.of(
      new MockCustomer(28,false,false,10),
      new MockCustomer(19,false,false,10),
      new MockCustomer(18,false,false,10),
      new MockCustomer(28,true,false,5),
      new MockCustomer(28,false,true,0),
      new MockCustomer(28,true,true,0),
      new MockCustomer(18,true,false,5),
      new MockCustomer(18,false,true,0),
      new MockCustomer(18,true,true,0),
      new MockCustomer(15,false,false,5),
      new MockCustomer(15,true,false,5),
      new MockCustomer(15,false,true,0),
      new MockCustomer(15,true,true,0)
      );

  @Test
  void getPriceTest() {
    for (MockCustomer costumer : costumers) {
      double price = ExercicesConditionnelle.getPrice(costumer);
      assertEquals(costumer.price, price,
        "prix incorrect dans le cas :  " + costumer);
    }
  }

  @Test
  void leapYearTest() {
    for (int year : List.of(1984,1988,2004,2024,4080,1600,2000,2400,5200)) {
      assertTrue(ExercicesConditionnelle.isLeapYear(year), () -> year + " est bissextile");
    }
    for (int year : List.of(2025,1979,1999,1900,2100,5100,2023)) {
      assertTrue(!ExercicesConditionnelle.isLeapYear(year), () -> year + " n'est pas bissextile");
    }
  }

  public record Date(int day, int month, int year) {
    @Override
    public String toString() {
      return String.format("%02d/%02d/%02d", day, month, year);
    }
  }
  private List<Date> dates = List.of(
    new Date(11,9,2024),
    new Date(30,9,2024),
    new Date(28,2,2024),
    new Date(28,2,2023),
    new Date(28,2,2000),
    new Date(31,12,2024),
    new Date(31,12,2000),
    new Date(31,1,2024),
    new Date(30,4,2024),
    new Date(30,5,2024)
  );
  private List<String> datesOutputs = List.of(
    "12/09/2024",
    "01/10/2024",
    "29/02/2024",
    "01/03/2023",
    "29/02/2000",
    "01/01/2025",
    "01/01/2001",
    "01/02/2024",
    "01/05/2024",
    "31/05/2024"
  );
  @Test
  void nextDayTest() {
    for (int i = 0;i < dates.size();i++) {
      Date date = dates.get(i);
      assertEquals(datesOutputs.get(i),
        ExercicesConditionnelle.nextDayString(date.day,date.month,date.year));
    }
  }

}

