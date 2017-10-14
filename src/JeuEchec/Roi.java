package JeuEchec;

public class Roi extends Piece{
	

	public Roi(boolean color) {
		if (color) this.color = color; else {
	    this.color = false;
	    }
	}
	
	public String toString() {
	    String a;
	
	    if (color) a = "roi"; else
	      a = "ROI";
	    return a;
	}
}