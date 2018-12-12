/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import modele.bateau.Bateau;
import modele.factory.EpoqueFactory;
/**
 *
 * @author trabels33u
 */
public abstract class Jeu {

     protected EpoqueFactory epoque ;
    
   
 	public Jeu(EpoqueFactory epoque){
        this.epoque =epoque;
        /*ArrayList<Bateau> bateauJoueur1;
        ArrayList<Bateau> bateauJoueur2;
    	bateauJoueur1 = new ArrayList<>();
    	addBateau(epoque, bateauJoueur1);
    	bateauJoueur2 = new ArrayList<>();
    	this.addBateau(epoque, bateauJoueur2);
    	this.j1 = new Humain(100,bateauJoueur1);
    	this.ia = new IA(100,bateauJoueur2);*/
    }

   public abstract void jouer(); //lancer le jeu 
   public abstract void finDePartie(); //End of Game 
   public abstract void addVue(); 
   public abstract void save(); //Save Game
   public abstract void load(); //Load saved game 
   public void placerBateau(Bateau bateau, List<Point> p,Joueur j) {

}
    
    
}
