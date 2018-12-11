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
public abstract class Jeu {
    
   private static final int NBAT = 5 ; //nombre des bateaux 
   private static final int NBP = 2; //nbr des joueurs 
   
   public List<Joueur> joueurs;
    

   public abstract void jouer(); //lancer le jeu 
   public abstract void finDePartie(); //End of Game 
   public abstract void addVue(); 
   public abstract void save(); //Save Game
   public abstract void load(); //Load saved game 
   public abstract void placerBateau(Bateau bateau, List<Point> p, int idJoueur);
    
    
}
