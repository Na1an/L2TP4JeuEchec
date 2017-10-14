package JeuEchec;

public class Tour extends Piece{

	public Tour(boolean color) {
		if (color) this.color = color; else
        this.color = false;
    }
  
    public String toString() {
        String a;

        if (color) a = "tour"; else
        a = "TOUR";
        return a;
    }
}