/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import modele.Case;
/**
 *
 * @author trabels33u
 */
public class Plateau {
    
    public static final int Width = 10; 
    public static final int Height = 10;
    
    public final Case[][] plateau  ; 
    
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
    public boolean positionVide(Point ...p)       
    {
        int i = p[0].x;
        int j = p[0].y;
        while( i <= p[1].x)
        {
            while(j<= p[2].y)
            {
                if(this.estVide(plateau[i][j]))
                {   i++;
                    j++;
                }
                 else
                {
                    return false ;
                }
            }
        }
       
     return true ; 
    }
    public void allocatePosition(int id , Point ...p)
    {
        
        int i = p[0].x;
        int j = p[0].y;
        while( i <= p[1].x)
        {
            while(j<= p[2].y)
            {
               this.plateau[i][j]=new Case(id);
            }
        }
    }
 
    
}
