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
abstract class Joueur {
    
	public int munition ;
    public Plateau plateau;
    public List<Bateau> bateaux;
    
    public Joueur(int munition, Plateau plateau , List<Bateau> b){
    	this.munition = munition;
    	this.plateau = plateau;
    	this.bateaux = b;
    }
    
    
    public int getMunition(){
    	return this.munition;
    }
    
    public void tirer(){
    	this.munition --;
    }
    
    public boolean munitionIsEmpty(){
    	boolean b = false;
    	if(this.munition==0){
    		b = true;
    	}
    	return b;
    }
    
    public void placerBateau(Bateau b, List<Point> p){
    	    	
    }
  

}
