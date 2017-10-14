package JeuEchec;

import java.io.PrintStream;

public class Piece {
  boolean color; //--> true blanc, false noir;
  
  public Piece(boolean color) {
    if (color) this.color = color; 
    else this.color = false;
  }
  
  public Piece() {}
  
  public String toString() {
    String a;
    if (color) a = "p"; else
      a = "P";
    return a;
  }
  

  public boolean estValide(deplacement dpl, Plateau p) {
	  //on ne peut pas faire sans coordonnées;
	  char m = dpl.quelType();
	  return !dpl.vefMov(this, m);
  }
  
  public static void main(String[] args)
  {
    Piece jj = new Piece(true);
    Piece jjj = new Piece();
    
    System.out.println(jjj);
  }
  
  
}