package modele.bateau;
import java.awt.Point;
import java.util.List;


public interface Bateau {

	int getID();
	List<Point> getPosition();
	void touche();
	boolean estCoule();
	
	
}
