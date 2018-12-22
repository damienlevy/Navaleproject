/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import controleur.Controleur;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modele.Case;



/**
 *
 * @author TRABELSI
 */
public class VueComplete extends JPanel implements GameVue {
    public JFrame Game ;
    public final static int Width = 500;
    public final static  int Height = 900;
    public final static int CaseX = 20;
    public final static int CaseY =20   ;
    public final VueAdversaire vueAdversaire;
    private final VuePerso perso;
    private MenuSave save;
    private Controleur controleur;
    
    public VueComplete(Controleur c)
    {
    	controleur = c;
        this.vueAdversaire = new VueAdversaire(c);
        this.perso = new VuePerso();    
        this.save = new MenuSave(c);
        vueAdversaire.addMouseListener(new MouseAdapter(){

   @Override
   public void mouseClicked(MouseEvent e) {
    
  chercherCase(e.getX()/37, e.getY()/37);
 
}
  
  
});
    }

    @Override
    public void display() {
        //Panel principal
        Game=new JFrame();
        Game.setTitle("Bataille navale");
        Game.setLocationRelativeTo(null);
        Game.setSize(500,900);     
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game.setJMenuBar(save);
        
        JSplitPane GamePanes = new JSplitPane();
        GamePanes.setOrientation(JSplitPane.VERTICAL_SPLIT); 
        GamePanes.setDividerLocation(420);    
         Game.getContentPane().add(GamePanes);
       
         //affichage plateau 1
         GamePanes.setTopComponent(perso);  
         //afficher plateau 2
         GamePanes.setBottomComponent(vueAdversaire);
      
        Game.setVisible(true);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public void chercherCase(int x, int y) {
         Point p = new Point(x,y);
    
         if( this.vueAdversaire.model.getPlateauIA().plateau[x][y].getidBateau() > 0)
         { this.vueAdversaire.model.getPlateauIA().plateau[x][y].toucher();  
         
         }
         else 
                this.vueAdversaire.model.getPlateauIA().plateau[x][y].setEautouche();
         
         this.vueAdversaire.repaint();
      
    }
}
