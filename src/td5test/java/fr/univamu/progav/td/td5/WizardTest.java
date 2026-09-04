package fr.univamu.progav.td.td5;

import fr.univamu.progav.td.td5.Blow;
import fr.univamu.progav.td.td5.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class WizardTest {


  @Test
  void newWizard() {
    Wizard wizard = new Wizard();
    assertEquals(20,wizard.getHealth());
    assertEquals(0,wizard.getShield());
    assertTrue(wizard.isAlive());
  }

  @Test
  void attack() {
    Wizard wizard = new Wizard();
    Blow b = wizard.attack();
    assertEquals(4, b.magicalDamage());
    assertEquals(0, b.physicalDamage());
    wizard.specialAction();
    b = wizard.attack();
    assertEquals(4, b.magicalDamage());
    assertEquals(0,b.physicalDamage());
  }

  @Test
  void defend() {
    Wizard wizard = new Wizard();
    assertEquals(20,wizard.getHealth());
    wizard.defend(new Blow(6,2));
    assertEquals(15,wizard.getHealth(), "Wizard loses life on physical attack, but physical damage is reduced by half of magical damage");
    wizard.defend(new Blow(0,10));
    assertEquals(15,wizard.getHealth(), "Wizard does not gain life on magical attack.");
  }

  @Test
  void specialAction() {
    Wizard wizard = new Wizard();
    wizard.specialAction();
    assertEquals(20, wizard.getHealth());
    wizard.defend(new Blow(6, 2));
    assertEquals(20, wizard.getHealth(), "Wizard's shield absorbs physical damage");
    assertEquals(2, wizard.getShield());
    wizard.defend(new Blow(6, 2));
    assertEquals(
      17,
      wizard.getHealth(),
      "Wizard's shield absorbs physical damage until depleted, then normal rules apply"
    );
    assertEquals(0, wizard.getShield());
  }

  @Test
  void maxShieldValue() {
    Wizard wizard = new Wizard();
    wizard.specialAction();
    wizard.defend(new Blow(5,0));
    wizard.specialAction();
    wizard.defend(new Blow(5,0));
    assertEquals(3, wizard.getShield(),"Wizard's special action sets shield to 8 (not an addition)");
  }
}