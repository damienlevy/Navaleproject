/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import vues.GameVue;

import modele.bateau.Bateau;
import modele.factory.EpoqueFactory;
/**
 *
 * @author trabels33u
 */
public abstract class Jeu {

	protected final EpoqueFactory epoque ;
	protected ArrayList<GameVue> vues;


	public Jeu(EpoqueFactory epoque){
		this.epoque =epoque;
		this.vues = new ArrayList<>(1);
	}
	

	


	public void addVue(GameVue v){
		vues.add(v);
	}
	
	public void notifyVue(){
		for (GameVue v: vues) {
			v.update();
		}
	}

	public abstract void jouer(); //lancer le jeu 
	public abstract void finDePartie(); //End of Game 
	public abstract void save(); //Save Game
	public abstract void load(); //Load saved game 
	public void placerBateau(Bateau bateau, ArrayList<Point> p,Joueur j) {

	}

}
