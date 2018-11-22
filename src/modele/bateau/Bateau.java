package modele.bateau;
import java.awt.Point;
import java.util.List;


public interface Bateau {

	int getID();
	List<Point> getPosition();
	void setPosition(Point...points);
	void touche(Point p);
	boolean estCoule();
	
	
	
}
