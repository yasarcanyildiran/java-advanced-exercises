package fr.univamu.progav.td5;

public abstract class Character {

  // TODO add health points

  public boolean isAlive() {
    // TODO
    return false;
  }

  protected int getHealth() {
    // TODO
    return 0;
  }
  protected void reduceHealth(int amount) {
    // TODO
  }
  protected void setHealth(int health) {
    // TODO
  }

  public abstract Blow attack();

  public abstract void defend(Blow blow);

  public abstract void specialAction();

}
