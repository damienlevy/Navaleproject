/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.List;

import modele.bateau.*;

/**
 *
 * @author trabels33u
 */
public abstract class Humain extends Joueur {

 
	public Humain(int munition, List<Bateau> b){
		super(munition, b);
	}
    
}
