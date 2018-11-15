/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import modele.Case;
/**
 *
 * @author trabels33u
 */
public class Plateau {
    
    public static final int Width = 10; 
    public static final int Height = 10;
    
    private final Case[][] plateau  ; 
    
    public Plateau ()
    {
        this.initialiser();
        plateau = new Case[Width][Height];
    }
    
    
    public final void initialiser()
    {//initialiser plateau vide 
        for(int i =0  ; i<= Width ; i++)
        {
            for(int j =0  ; j<= Height ; j++)
            {
                  plateau[i][j]= new Case(-1);
            }
        }
        
    }
    
    //verfifier si la case est déjà vide avant de placer le bateau 
    public boolean estVide(Case c)
    {
        if(c.getidBateau()== -1)
            return true ;
        return false ;
    }
    
    
    
}
