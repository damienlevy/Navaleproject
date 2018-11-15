/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import modele.bateau.Bateau;
/**
 *
 * @author trabels33u
 */
abstract class Jeu {
    
   private static final int NBAT = 5 ; //nombre des bateaux 
   private static final int NBP = 3; //nbr des joueurs 
   
   public Plateau[] plateaux ; 
   
   public Joueur[] players; 
   
   public Bateau[] bateaux;
    
    abstract Plateau placerBateau(); //placer les Bateaux sur le plateau 
    abstract void jouer(); //lancer le jeu 
    abstract void finDePartie(); //End of Game 
    abstract void addVue(); 
    abstract void save(); //Save Game
    abstract void load(); //Load saved game 
    
    
}
