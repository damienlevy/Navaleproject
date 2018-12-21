package controleur;

import modele.ModelClassique;
import vues.GameVue;

public interface Controleur {

	
	public void start();
	public void addVue(GameVue vue);
        public ModelClassique getModele();
       
}
