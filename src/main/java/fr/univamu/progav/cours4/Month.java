package fr.univamu.progav.cours4;

public enum Month {
  JANUARY(31),
  FEBRUARY(28),
  MARCH(31),
  APRIL(30),
  MAY(31),
  JUNE(30),
  JULY(31),
  AUGUST(31),
  SEPTEMBER(30),
  OCTOBER(31),
  NOVEMBER(30),
  DECEMBER(31);

  public final int nbDays;

  private Month(int nbDays) {
    this.nbDays = nbDays;
  }

  public int getNbDays() {
    return switch(this) {
      case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
      case FEBRUARY -> 28;
      case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
    };
  }
}
