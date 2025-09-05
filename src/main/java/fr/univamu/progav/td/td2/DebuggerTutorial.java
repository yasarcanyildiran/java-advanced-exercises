package fr.univamu.progav.td.td2;

public class DebuggerTutorial {

  private int x = 2;
  private String text = "an instance variable of a DebuggerTutorial instance";

  public void exoDebug() {
    double x = 1;
    f();
    A a = new A();
    a.g();
    for (int i = 0; i < 100000; i++) {
      String s = "Reprendre l'exécution pour passer la boucle";
    }
    String r = "Si vous voyez ceci dans le débugger, c'est GAGNÉ";
    System.out.println("The end.");
  }

  public void f() {
    System.out.println("In method f.");
    double x = 0;
    String bad = "Si vous voyez ceci dans le débugger, c'est PERDU.";
    double y = 0;
  }

  class A {
    private final int x = 42;

    public void g() {
      String bad = "Si vous voyez ceci dans le débugger, c'est PERDU.";
      System.out.println("In method g.");
    }
  }


}
