package fr.univamu.progav.cours5.InductiveList;

public class Main {

  public static void main(String[] args) {
    LinkedList<Integer> list0 = new EmptyLinkedList<>();
    LinkedList<Integer> list1 = list0.add(1);
    LinkedList<Integer> list2 = list1.add(3);
    LinkedList<Integer> list3 = list2.add(2);
    for (int elt : list3) {
      System.out.println(elt);
    }
    System.out.println();
    for (int elt : list1) {
      System.out.println(elt);
    }
  }
}
