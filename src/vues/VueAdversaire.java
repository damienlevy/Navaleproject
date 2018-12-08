/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static vues.Vue.back;


/**
 *
 * @author TRABELSI
 */
public class VueAdversaire extends JPanel implements GameVue {
  
    private final static int w = 400;
    private final static int h = 400;
    public final static int CaseX = 40;
    public final static int CaseY =40   ;
    public JPanel adversaire ;
    
    public VueAdversaire()
    {
        
        this.display();
    }

    @Override
   public void display() {      
       adversaire = new JPanel();
       adversaire.setPreferredSize(new Dimension(w,h));
       //adversaire.setSize(w,h);
    }

    @Override
    public void update() {

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    try {
        back = ImageIO.read(new File("./src/vues/images/back.jpg"));
         
        
        for( int i=0 ; i < (w/CaseX); i++ )
        {
            
            for(int j = 0 ; j < h/CaseY ; j++)
            {
              g.drawRect(i*CaseX,j*CaseY,CaseX,CaseY); 
              g.drawImage(back,i*CaseX,j*CaseY,CaseX-1,CaseY-1,this); 
             
            }
        }
    
      
    } catch (IOException ex) {
        Logger.getLogger(Vue.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}
}
