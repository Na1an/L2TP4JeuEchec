package JeuEchec;

import java.io.PrintStream;

public class Casse {
  boolean bn;
  Piece p;
  
  deplacement deplacement = new deplacement();
  
  public Casse(boolean b) {
    p = new Piece(b);
  }
  
  public Piece getPiece() {
    return p;
  }
  
  public boolean estVide() {
    if (p == null) {
      return true;
    }
    
    return false;
  }
  
  public void remplirPiece(Piece p)
  {
    this.p = p;
  }
  
  public void enleverPiece() {
    p = null;
  }
  
  public String toString() {
    if (p == null) {
      if (bn) return "blanc";
      return "noir";
    }
    return p.toString();
  }
  
  public static void main(String[] args)
  {
    Casse ca = new Casse(true);
    System.out.println(ca.toString());
  }
}