package fr.univamu.progav.cours.cours8;

public record Car(
  String brand,
  String model,
  int topSpeed,
  boolean hasAutomaticTransmission,
  int productionYear,
  int price) {
}
