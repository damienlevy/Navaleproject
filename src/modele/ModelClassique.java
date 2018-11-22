/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import java.util.ArrayList;

import modele.bateau.Bateau;
import modele.factory.EpoqueFactory;

/**
 *
 * @author trabels33u
 */
public class ModelClassique extends Jeu {
     private ArrayList<Bateau> bateauJoueur1;
     private ArrayList<Bateau> bateauJoueur2;
     private Plateau plateauJoueur1;
     private Plateau plateauJoueur2;
    
    
    public ArrayList<Bateau> getBateauJoueur1() {
		return bateauJoueur1;
	}

	public ArrayList<Bateau> getBateauJoueur2() {
		return bateauJoueur2;
	}

	public Plateau getPlateauJoueur1() {
		return plateauJoueur1;
	}

	public Plateau getPlateauJoueur2() {
		return plateauJoueur2;
	}

	public ModelClassique(EpoqueFactory epoque){
    	this.bateauJoueur1 = new ArrayList<>();
    	this.addBateau(epoque, bateauJoueur1);
    	this.bateauJoueur2 = new ArrayList<>();
    	this.addBateau(epoque, bateauJoueur2);
    	this.plateauJoueur1 = new Plateau();
    	this.plateauJoueur2 = new Plateau();
    	
    }
    
    private void addBateau(Bateau b, ArrayList<Bateau> listBateau){
    	listBateau.add(b);
    }
    private void addBateau(EpoqueFactory epoque,ArrayList<Bateau> listBateau){
    	this.addBateau(epoque.createBateau2() , listBateau);
    	this.addBateau(epoque.createBateau3_1() , listBateau);
    	this.addBateau(epoque.createBateau3_2() , listBateau);
    	this.addBateau(epoque.createBateau4() , listBateau);
    	this.addBateau(epoque.createBateau5() , listBateau);
    }
    
   
    @Override
   public void placerBateau(Bateau bateau,Point ...p) {
    	bateau.setPosition(p);
    }

    @Override
    void jouer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void finDePartie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void addVue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
