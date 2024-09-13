package fr.univamu.progav.td2;

public class ASimpleLoop {

  public static double nonTerminatingSum(int n) {
    double sum = 0;
    for (double i = 0; i != n; i = i + 0.1) {
      sum = sum + i ;
    }
    return sum;
  }

}
