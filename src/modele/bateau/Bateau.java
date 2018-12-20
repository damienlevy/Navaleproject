package modele.bateau;
import java.awt.Point;
import java.util.List;


public interface Bateau {

	public int getID();
	public List<Point> getPosition();
	public void setPosition(List<Point> p);
	public void touche(Point p);
	public boolean estCoule();
	public int getTaille();
	public List<Point> getTouche();
	
	
	
}
