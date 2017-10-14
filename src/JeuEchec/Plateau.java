package JeuEchec;

import java.io.PrintStream;

public class Plateau {
  int hauteur;
  int longeur;
  static Casse[][] ca;
  
  public Plateau(int haut, int lon) { hauteur = haut;
    longeur = lon;
    ca = new Casse[haut][lon];
    int a = 0;
    for (int i = 0; i < haut; i++)
      for (int j = 0; j < lon; j++) {
        if (a % 2 == 0) {
          ca[i][j] = new Casse(true);
        }
        ca[i][j] = new Casse(false);
        a++;
      }
  }
  
  public Casse getCase(int x, int y) { return ca[x][y]; }
  
  void viderCase(int x, int y)
  {
    ca[x][y].p = null;
  }
  
  void remplirCase(int x, int y, Piece p) {
    ca[x][y].p = p;
  }
  
  public void afficher() {
	  System.out.print("  " + "\t");
	  for(int p=0;p<longeur;p++) {
		  System.out.print(p + "\t");
	  }
	  System.out.println();
      for (int i = 0; i < hauteur; i++) {
    	  System.out.print(i + "\t");
          for (int j = 0; j < longeur; j++) {
        	  System.out.print(ca[i][j].toString() + "\t");
          }
          System.out.println();
      }
  }
  
  public boolean horsLimite(int x, int y) {
    if ((x < hauteur) && (y < longeur)) {
      return true;
    }
    return false;
  }
  
  public boolean horsLimit(deplacement dep) {
	  //cobiner dans les méthod de piece dans la class deplacament
	  boolean f = false;
	
	  return f;
  }
}