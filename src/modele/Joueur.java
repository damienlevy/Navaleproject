
package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import modele.bateau.Bateau;

/**
 *
 * @author trabels33u
 */
public abstract class Joueur {

	public int munition;
	public Plateau plateau;
	public List<Bateau> bateaux;

	public Joueur(int munition, List<Bateau> b) {
		this.munition = munition;
		this.plateau = new Plateau();
		this.bateaux = b;
	}

	public Joueur(int munition, List<Bateau> b, Plateau p) {
		this.munition = munition;
		this.plateau = p;
		this.bateaux = b;
	}

	public int getMunition() {
		return this.munition;
	}

	public void tirer(Point p) {
		this.munition--;
		Case c = this.plateau.getCase(p);
		int idB;
		Bateau b;
		if (!c.isToucher()) {
			c.toucher();
			idB = c.getidBateau();
			if (idB != -1) {
				for (Bateau bat : bateaux) {
					if (bat.getID() == idB) {
						b = bat;
						b.touche(p);
					}
				}
			}
		}
	}

	public boolean munitionIsEmpty() {
		boolean b = false;
		if (this.munition == 0) {
			b = true;
		}
		return b;
	}

	public void placerBateau(Bateau b, List<Point> p) {
		if (b.getPosition().size() != 0) {
			ArrayList<Point> coords = (ArrayList<Point>) b.getPosition();
			for (Point coord : coords) {
				plateau.libererCase(coord);
			}
		}
		if (this.plateau.positionVide(p)) {
			b.setPosition(p);
			this.plateau.allocatePosition(b.getID(), p);
		}
	}

	public Plateau getPlateau() {
		return this.plateau;
	}

	public List<Bateau> getBateau() {
		return this.bateaux;
	}

	public abstract String getType();

}
