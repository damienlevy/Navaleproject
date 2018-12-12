/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author trabels33u
 */
public class Case {
    boolean toucher ;
    private int idBateau; 
    
    
    public Case(int id )
    {
        this.toucher = false ; // par defaut 
        this.idBateau = id ; 
    }
    
    
    public void toucher()
    {
       this.toucher=true ;
    }
    public boolean estTouche() {
    	return this.toucher;
    }
    
    //Return the id of the Naval
    public int getidBateau()
    {
        return this.idBateau;
    }
    
    public void setidBateau(int id )
    {
        this.idBateau= id;
    }
    
    
    
}
