package controleur;

import java.awt.Point;
import modele.Joueur;
import modele.ModelClassique;
import vues.GameVue;

public interface Controleur {

	public void start();

	public void addVue(GameVue vue);

	public ModelClassique getModele();

	public void save();
 public void notifyTirer(Point c, Joueur j);

}
