package controleur;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modele.Jeu;
import modele.ModelClassique;
import modele.bateau.Bateau;
import vues.Vue;

public class ControleurJeuxClassique implements Controleur{

	private List<Vue> listVues;
	private ModelClassique model;
	private HashMap<Integer, Integer> select;
	//0 horizontal // 1 vertical
	private HashMap<Integer, Integer> orientation;

	public ControleurJeuxClassique(ModelClassique model) {
		this.model  = model; 
		listVues    = new ArrayList<>();
		select      = new HashMap<>();
		orientation = new HashMap<>();
	}

	@Override
	public void start(){
		for (Vue vue : listVues) {
			vue.display();
		}
	}

	@Override
	public void addVue(Vue vue) {
		listVues.add(vue);
	}

	public void notifyTirer(Point c) {
		model.tirer(c);
	}

	public void selectBateau(int idBateau, int idJoueur) {
		if(idBateau == select.get(idJoueur)) {

			if(orientation.get(idBateau) == 0) {
				orientation.remove(idBateau);
				orientation.put(idBateau, 0);
			} else {
				orientation.remove(idBateau);
				orientation.put(idBateau, 1);
			}

		} else {
			select.remove(idJoueur);
			select.put(idJoueur, idBateau);
			orientation.put(idBateau, 0);
		}
	}

	public void placerBateau(Point c, int idJoueur) {
		if(select.get(idJoueur) != null) {
			ArrayList<Bateau> bateaux = model.getBateauJoueur1();
			ArrayList<Point> position = new ArrayList<>(5);
			int taille = 0;
			Bateau b = null;
			for (Bateau bateau : bateaux) {
				if(bateau.getID() == select.get(idJoueur)) {
					b = bateau; 
					taille = bateau.getTaille();
				}
			}
			position.add(c);
			for (int i = 1; i < taille; i++) {
				if(orientation.get(b.getID()) == 0) {
					position.add(new Point(c.x+i, c.y));
				}else {
					position.add(new Point(c.x, c.y+i));
				}
			}
			model.placerBateau(b, position, idJoueur);
		}
	}
}
