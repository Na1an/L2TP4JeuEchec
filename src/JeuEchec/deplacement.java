package JeuEchec;

import java.util.Scanner;

import javax.xml.bind.annotation.XmlAccessOrder;

public class deplacement {
  int[] tab = new int[2]; //tab[0] stoker gauche et droite; tab[1] stoker haut et bas
  Scanner sc = new Scanner(System.in);
  
  public deplacement(){

  }
  public deplacement(char a){ 
	  Scanner sc = new Scanner(System.in);
	  System.out.println("Choissisez la distance du déplacement !!");
	  int i = sc.nextInt();
	  System.out.println("Choissisez le signe:  0--> en negatif et 1 -->pofsitif");
  }
  
  public char quelType(){
    System.out.println("Choissisez le type du déplacement !!");
    System.out.println("v : vertical -- h : horizontale -- d : diagonal -- c : cavalier -- x : aucun des précédents");
    String a = sc.next();
    return a.charAt(0);
  }

  public void bouger(Plateau pla) {
	  System.out.println("Quel case voulez-vous bouger ?");
	  boolean f = true;
	  int i=0;
	  int j=0;
	  while (f) {
		  System.out.println("Abscisse? 0 ~~" + (pla.ca.length-1));
		  i = sc.nextInt();
		  System.out.println("Ordonnée? 0 ~~" + (pla.ca[i].length-1));
		  j = sc.nextInt();
		  if(pla.ca[i][j].p instanceof Piece) {
			  f = false;
		  }else {
			System.out.println("Cette case est vide !!");
		  }
	  }
	  //pla.ca[i][j] connu la location
	  char m = quelType();
	  if(!vefMov(pla.ca[i][j].p, m)) {
		  distance(pla.ca[i][j], m,i,j);
		  pla.remplirCase(i+tab[1], j+tab[0], pla.ca[i][j].p); //tab[1] est avec i, influence ordonne; et tab[0] est avec j, influence abscisse;
		  pla.ca[i][j].enleverPiece();
	  }
  }
  
  public void distance(Casse ca, char m,int i,int j) {
	  int n = 0;
	  boolean f = true;
	  tab[0] = 0;
	  tab[1] = 0;
	  System.out.println("Vous avez choisi un" + ca.toString());
	  if(ca.p instanceof Pion) {
		  bougePion(ca, f, n,i,j);
	  }
	  else if(ca.p instanceof Tour) {
		  bougeTour(ca, f, n, m,i,j);
	  }else if(ca.p instanceof Reine) {
		  bougeReine(ca, f, n, m,i,j);
	  }else if(ca.p instanceof Roi) {
		  bougeRoi(ca, f, n, m);
	  }
  }
  
  public void bougeRoi(Casse ca,boolean f, int n, char m) {
	  int h = 0;
	  if(m == 'v') {
		  while (f) {
			  System.out.println("Vers haut ou vers bas?Vers haut est -1, par contre vers bas est 1");
			  n = sc.nextInt();
			  if(n==1 || n==-1) {
				  f = false;
			  }
		  }
		  tab[1] = tab[1] + n;
	  }else if(m == 'h'){
		  while (f) {
			  System.out.println("Vers gauche ou vers droite?Vers gauche est -1, vers droite est 1");
			  n = sc.nextInt();
			  if(n==1 || n==-1) {
				  f = false;
			  }
		  }
		  tab[0] = tab[0] + n;
	  }else if(m == 'd'){
		  while (f) {
			  System.out.println("Vers haut ou vers bas?Vers haut est -1, par contre vers bas est 1");
			  n = sc.nextInt();
			  System.out.println("Vers gauche ou vers droite?Vers gauche est -1, vers droite est 1");
			  h = sc.nextInt();
			  if(n==1 || n==-1) {
				  if(h==1 || h==-1) f = false;
			  }
	      }
		  tab[0] = tab[0] + h;
		  tab[1] = tab[1] + n;
	  }
  }
  
  public void bougeReine(Casse ca,boolean f, int n, char m,int i,int j) {
	  int h = 0;
	  
	  if(m == 'v') {
		  while (f) {
			  System.out.println("Vers haut ou vers bas?Vers haut est negatif, par contre vers bas est positif");
			  n = sc.nextInt();
			  if(n+i<Plateau.ca.length && n+i>0) {
				  f = false;
			  }
		  }
		  tab[1] = tab[1] + n;
	  }else if(m == 'h'){
		  while (f) {
			  System.out.println("Vers gauche ou vers droite?Vers gauche est negatif, vers droite est positif");
			  n = sc.nextInt();
			  if(n+j<Plateau.ca[i].length && n+j>0) {
				  f = false;
			  }
		  }
		  tab[0] = tab[0] + n;
	  }else if(m == 'd'){
		  while (f) {
			  System.out.println("Vers haut ou vers bas?Vers haut est negatif, par contre vers bas est positif");
			  n = sc.nextInt();
			  System.out.println("Vers gauche ou vers droite?Vers gauche est negatif, vers droite est positif");
			  h = sc.nextInt();
			  if(n+i<Plateau.ca.length && n+i>0) {
				  if(h+j<Plateau.ca[i].length && h+j>0) f = false;
			  }
	      }
		  tab[0] = tab[0] + h;
		  tab[1] = tab[1] + n;
	  }
  }
  
  public void bougeTour(Casse ca,boolean f, int n, char m,int i,int j) {
	  /**
	   * ca la case;
	   * f est un operateur, peu important
	   * m le type de manipulation
	   * i ordonnée
	   * j abscisse
	   */
	  if(m == 'v') {
		  while (f) {
			  System.out.println("Vers haut ou vers bas?Vers haut est negatif, par contre vers bas est positif");
			  n = sc.nextInt();
			  if(n+i<Plateau.ca.length && n+i>0) {
				  f = false;
			  }
		  }
		  tab[1] = tab[1] + n;
	  }else {
		  while (f) {
			  System.out.println("Vers gauche ou vers droite?Vers gauche est negatif, vers droite est positif");
			  n = sc.nextInt();
			  if(n+j<Plateau.ca[i].length && n+j>0) {
				  f = false;
			  }
		  }
		  tab[0] = tab[0] + n;
	  }
  }
  
  public void bougePion(Casse ca,boolean f, int n,int i,int j) {
	  while (f) {
		  System.out.println("Une case ou deux cases? (Automatique distinguer blanc et noir!)");
		  n = sc.nextInt();
		  System.out.println(ca.p.color);
		  System.out.println(i-n);
		  if(ca.p.color== true && i-n>=0) {
			 
			  if(n == 1 || n== 2) f = false;
			  tab[1] = -n;
		  }
		  if(ca.p.color==false && i+n<Plateau.ca.length) {
			  
			  if(n == 1 || n== 2) f = false;
			  tab[1] = n;
		  }
	  }
	  tab[0] = 0; 
	 
  }
  
  public boolean vefMov(Piece pie,char m) {
	  //manipulation des pieces
	  boolean f = true;
	  while(f) {
		  if(pie instanceof Pion) {
			  if(m == 'v') f = false;
		  }else if(pie instanceof Tour) {
			  if(m == 'h' || m == 'v') f = false;
		  }else if(pie instanceof Reine) {
			  f = false;
		  }else if(pie instanceof Roi) {
			  f = false;
		  }
		  if(f) m = quelType();
	  }
	  return f;
  }

}
