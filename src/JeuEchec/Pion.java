package JeuEchec;

public class Pion extends Piece{
	

	public Pion(boolean color) {
	    if (color) this.color = color; else {
	      this.color = false;
	    }
	}
	  
	public String toString() {
		String a;
	    if (color) a = "pion"; else
	      a = "PION";
	    return a;
	}
}