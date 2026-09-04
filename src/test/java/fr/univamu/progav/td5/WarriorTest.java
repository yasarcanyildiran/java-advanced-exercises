package fr.univamu.progav.td5;

import fr.univamu.progav.td.td5.Blow;
import fr.univamu.progav.td.td5.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class WarriorTest {

  @Test
  void newWarrior() {
    Warrior warrior = new Warrior();
    assertEquals(30,warrior.getHealth());
    warrior.reduceHealth(8);
    assertEquals(22,warrior.getHealth());
    warrior.setHealth(25);
    assertEquals(25,warrior.getHealth());
  }

  @Test
  void attack() {
    Warrior warrior = new Warrior();
    Blow b = warrior.attack();
    assertEquals(3,b.physicalDamage());
    assertEquals(0,b.magicalDamage());
  }

  @Test
  void defend() {
    Warrior warrior = new Warrior();
    warrior.defend(new Blow(10,2));
    assertEquals(23,warrior.getHealth());
    warrior.defend(new Blow(1,5));
    assertEquals(18,warrior.getHealth());
  }

  @Test
  void specialAction() {
    Warrior warrior = new Warrior();
    warrior.specialAction();
    Blow b  = warrior.attack();
    assertEquals(6,b.physicalDamage());
    assertEquals(0,b.magicalDamage());
    b  = warrior.attack();
    b  = warrior.attack();
    assertEquals(6,b.physicalDamage());
    assertEquals(0,b.magicalDamage());
    b  = warrior.attack();
    assertEquals(3,b.physicalDamage());
    assertEquals(0,b.magicalDamage());
  }

  @Test
  void getRage() {
    Warrior warrior = new Warrior();
    assertEquals(0,warrior.getRage());
    warrior.specialAction();
    assertEquals(3,warrior.getRage());
    warrior.attack();
    assertEquals(2,warrior.getRage());
    warrior.specialAction();
    assertEquals(3,warrior.getRage());
  }

  @Test
  void defendIncreaseRage() {
    Warrior warrior = new Warrior();
    warrior.defend(new Blow(4,4));
    assertEquals(0,warrior.getRage(), "Warrior does not enter rage by receiving a blow");
    warrior.specialAction();
    warrior.defend(new Blow(0,5));
    assertEquals(4,warrior.getRage(), "Increase rage when 5 health lost");
    warrior.defend(new Blow(0,4));
    assertEquals(4,warrior.getRage(), "Do not increase rage when <5 health lost");
    warrior.defend(new Blow(6,0));
    assertEquals(4,warrior.getRage(),"Do not increase rage when <5 health lost");
  }
}