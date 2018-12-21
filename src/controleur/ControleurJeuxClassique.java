package controleur;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modele.Case;
import modele.Joueur;
import modele.ModelClassique;
import modele.Plateau;
import modele.bateau.Bateau;
import vues.GameVue;

public class ControleurJeuxClassique implements Controleur{

	private List<GameVue> listVues;
	private ModelClassique model;
	private HashMap<Joueur, Integer> select;
        public final Plateau plateau;
	//0 horizontal // 1 vertical
	private HashMap<Integer, Integer> orientation;

	public ControleurJeuxClassique(ModelClassique model) {
		this.model  = model; 
		listVues    = new ArrayList<>();
		select      = new HashMap<>();
		orientation = new HashMap<>();
                plateau= model.getPlateauIA();
                plateau.afficherPlateau();
	}

	@Override
	public void start(){
		for (GameVue vue : listVues) {
			vue.display();
		}
	}

	@Override
	public void addVue(GameVue vue) {
		listVues.add(vue);
	}

	public void notifyTirer(Point c,Joueur j) {
		model.tirer(c,j);
	}

	public void selectBateau(int idBateau, Joueur j) {
		if(idBateau == select.get(j)) {

			if(orientation.get(idBateau) == 0) {
				orientation.remove(idBateau);
				orientation.put(idBateau, 0);
			} else {
				orientation.remove(idBateau);
				orientation.put(idBateau, 1);
			}

		} else {
			select.remove(j);
			select.put(j, idBateau);
			orientation.put(idBateau, 0);
		}
	}

	public void placerBateau(Point c, Joueur j) {
		boolean valide = true;
		if(select.get(j) != null) {
			ArrayList<Bateau> bateaux = (ArrayList<Bateau>) model.getBateauJoueur1();
			ArrayList<Point> position = new ArrayList<>(5);
			int taille = 0;
			Bateau b = null;
			for (Bateau bateau : bateaux) {
				if(bateau.getID() == select.get(j)) {
					b = bateau; 
					taille = bateau.getTaille();
				}
			}

			for (int i = 1; i < taille; i++) {
				if(orientation.get(b.getID()) == 0) {
					if(c.x+i > 9) {
						valide = false;
					}
				}else {
					if(c.y+i > 9) {
						valide = false;
					}
				}

			}
			if(valide) {
				position.add(c);
				for (int i = 1; i < taille; i++) {
					if(orientation.get(b.getID()) == 0) {
						position.add(new Point(c.x+i, c.y));
					}else {
						position.add(new Point(c.x, c.y+i));
					}
				}
				model.placerBateau(b, position, j);
			}
		}
	}
         @Override
        public ModelClassique getModele()
        {
            return this.model;
        }

   
    
           
        
}

