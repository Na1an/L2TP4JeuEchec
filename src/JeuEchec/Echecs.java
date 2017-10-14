package JeuEchec;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class Echecs {
  Plateau pla;
  boolean blanc = true;
  boolean noir = false;
  
  public Echecs() {
    pla = new Plateau(4, 4);
    pla.ca[0][0].p = new Tour(noir);
    pla.ca[0][1].p = new Reine(noir);
    pla.ca[0][2].p = new Roi(noir);
    pla.ca[0][3].p = new Tour(noir);
    pla.ca[1][0].p = new Pion(noir);
    pla.ca[1][1].p = new Pion(noir);
    pla.ca[1][2].p = new Pion(noir);
    pla.ca[1][3].p = new Pion(noir);
    pla.ca[2][0].p = new Pion(blanc);
    pla.ca[2][1].p = new Pion(blanc);
    pla.ca[2][2].p = new Pion(blanc);
    pla.ca[2][3].p = new Pion(blanc);
    pla.ca[3][0].p = new Tour(blanc);
    pla.ca[3][1].p = new Roi(blanc);
    pla.ca[3][2].p = new Reine(blanc);
    pla.ca[3][3].p = new Tour(blanc);
  }
  
  public void jouerTour(deplacement dpl,boolean joueur,Plateau p) {
	  while (joueur) {
		  p.afficher();
		  dpl.bouger(p);
		  joueur = false;
		  for(int i=0;i<p.hauteur;i++) {
			  for(int j=0;j<p.longeur;j++) {
				  if(p.ca[i][j].p instanceof Roi) {
					  joueur = true;
				  }
			  }
		  }
	  }
  }
  
  public static void main(String[] args){
    Echecs ech = new Echecs();
    deplacement dpl = new deplacement();
    boolean f = true;
    ech.jouerTour(dpl, f, ech.pla);
  }
}
