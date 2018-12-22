
package modele;

import java.util.List;

import modele.bateau.*;

/**
 *
 * @author trabels33u
 */
public class Humain extends Joueur {

	public Humain(int munition, List<Bateau> b) {
		super(munition, b);
	}

	public Humain(int munition, List<Bateau> b, Plateau p) {
		super(munition, b, p);
	}

	@Override
	public String getType() {
		return "humain";
	}

}
