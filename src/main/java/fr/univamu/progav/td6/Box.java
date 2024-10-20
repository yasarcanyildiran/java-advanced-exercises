package fr.univamu.progav.td6;

public class Box implements Lens<Integer> {

  private int content;

  public Box(int content) {
    this.content = content;
  }

  @Override
  public void set(Integer newContent) {
    this.content = newContent;
  }

  @Override
  public Integer get() {
    return this.content;
  }
}
