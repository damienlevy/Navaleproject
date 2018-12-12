/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import java.util.List;

import modele.bateau.Bateau;

/**
 *
 * @author trabels33u
 */
public abstract class Joueur {

	public int munition ;
	public Plateau plateau;
	public List<Bateau> bateaux;

	public Joueur(int munition,List<Bateau> b){
		this.munition = munition;
		this.plateau = new Plateau();
		this.bateaux = b;
	}


	public int getMunition(){
		return this.munition;
	}

	public void tirer(Point p){
		this.munition --;
		Case c = this.plateau.getCase(p);
		int idB;
		Bateau b;
		if(!c.isToucher()) {
			c.toucher();
			idB = c.getidBateau();
			if(idB != -1) {
				for (Bateau bat: bateaux) {
					if(bat.getID() == idB) {
						b = bat;
						b.touche(p);
					}
				}
			}
		}
	}

	public boolean munitionIsEmpty(){
		boolean b = false;
		if(this.munition==0){
			b = true;
		}
		return b;
	}

	public void placerBateau(Bateau b, List<Point> p){
		if(this.plateau.positionVide(p)) {
			b.setPosition(p);
			this.plateau.allocatePosition(b.getID(), p);
		}
	}

	public Plateau getPlateau(){
		return this.plateau;
	}

	public List<Bateau> getBateau(){
		return this.bateaux;
	}


}
