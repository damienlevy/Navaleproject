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
public class Plateau {
    
    public static final int Width = 100; 
    public static final int HEIGHT = 100;
    private final Case[][] plateau  ; 
    
    public Plateau ()
    {
        this.initialiser();
        plateau = new Case[10][10];
    }
    
    public void initialiser()
    {
        
    }
    
    
    
}
