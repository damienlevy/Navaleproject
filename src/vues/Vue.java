/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;


import java.awt.Graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author trabels33u
 */
public class Vue extends JPanel {

JFrame game;
public static Image back;
public final static int Width = 420;
public final static  int Height = 640;
public final static int CaseX = 40;
public final static int CaseY =60;

       
    public void CreatFenetre()       
      {
    Vue v = new Vue();
   game = new JFrame();
   game.setSize(Width , Height);
   game.setTitle("Bataille navale (Complete)");
    game.getContentPane().add(v);
   game.setVisible(true);
   game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
    
    @Override
  
   protected void paintComponent(Graphics g) {
 super.paintComponent(g);
    try {
        back = ImageIO.read(new File("./src/vues/images/back.jpg"));
        
        for( int i=0 ; i < (Width/CaseX); i++ )
        {
            for(int j = 0 ; j < (Height/CaseY)  ; j++)
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
