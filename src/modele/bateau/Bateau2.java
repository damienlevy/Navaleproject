package modele.bateau;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class Bateau2 implements Bateau{

	protected int id;
	protected List<Point> coords;
	protected List<Point> touche;
	
	public Bateau2(int id) {
		this.id = id;
		this.coords = new ArrayList<>();
		this.touche = new ArrayList<>();
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public List<Point> getPosition() {
		// TODO Auto-generated method stub
		return coords;
	}
	
	@Override
	public void touche(Point p){
		if(coords.contains(p) && !touche.contains(p)) {
			touche.add(p);
		}
	}
		
	@Override
	public boolean estCoule() {
		boolean b = true;
		for (int i = 0; i < coords.size(); i++) {
			if(!coords.contains(touche.get(i)))
				b = false;
		}
		return b;
	}

}
