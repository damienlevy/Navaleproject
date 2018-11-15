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
class Case {
    boolean toucher ;
    private int idBateau; 
    
    
    public Case(int id )
    {
        this.toucher = false ; // par deafaut 
        this.idBateau = id ; 
    }
    
    
    boolean estToucher()
    {
       
        return this.toucher=true ;
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
