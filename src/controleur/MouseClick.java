/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import modele.Case;
import modele.Plateau;

/**
 *
 * @author trabels33u
 */
public class MouseClick implements MouseListener {
 private int x ;
 private int y ;
 private final Plateau plateau;
 private int Case =37;
    private BufferedImage img;
    private BufferedImage touche;

  public MouseClick(Plateau p)
  {
      this.plateau=p;
      
  }
  
    @Override
    public void mouseClicked(MouseEvent e) {
       
        setX(e.getX());
        setY(e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Case c = chercherCase(getX()/Case, getY()/Case);
        this.plateau.plateau[getX()/Case][getY()/Case].toucher();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
                try {
                        touche = ImageIO.read(new File("./src/vues/images/touche.png"));
                } catch (IOException ec) {
                        // TODO Auto-generated catch block
                        ec.printStackTrace();
                }
                 
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setX(int x) {
        this.x = x ;
    }
    
    public void setY(int x) {
        this.y = x ;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }

   

    private Case chercherCase(int x, int y) {
        return this.plateau.getCase(x, y);
    }

   
    
}
