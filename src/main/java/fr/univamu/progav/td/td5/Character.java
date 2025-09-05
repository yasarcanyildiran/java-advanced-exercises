package fr.univamu.progav.td.td5;

public abstract class Character {

  // TODO add health points

  public boolean isAlive() {
    // TODO
    return false;
  }

  public int getHealth() {
    // TODO
    return 0;
  }
  public void reduceHealth(int amount) {
    // TODO
  }
  public void setHealth(int health) {
    // TODO
  }

  public abstract Blow attack();

  public abstract void defend(Blow blow);

  public abstract void specialAction();

}
