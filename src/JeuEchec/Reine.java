package JeuEchec;

public class Reine extends Piece{
	

	public Reine(boolean color) {
		if (color) this.color = color; else {
			this.color = false;
			}
	}
	  
	public String toString() {
		String a;
	
	    if (color) a = "reine"; else
	      a = "REINE";
	    return a;
	}
}