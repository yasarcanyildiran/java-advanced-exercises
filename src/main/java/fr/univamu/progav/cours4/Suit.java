package fr.univamu.progav.cours4;

public enum Suit {
  SPADES ("spades", '♠'),
  HEARTS ("hearts", '♡'),
  DIAMONDS ("diamonds", '♢'),
  CLUBS ("clubs", '♣');

  private final String name ;
  private final char symbol;

  private Suit(String name, char symbol) {
    this.name = name;
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return name;
  }

  public char getSymbol() {
    return symbol;
  }

  public boolean isRed() {
    switch (this) {
      case Suit.HEARTS :
      case Suit.DIAMONDS : return true;
      default : return false;
    }
  }

  public boolean isBlack() {
    return switch (this) {
      case Suit.HEARTS, Suit.DIAMONDS -> false;
      case Suit.SPADES, Suit.CLUBS -> true;
    };
  }
}
