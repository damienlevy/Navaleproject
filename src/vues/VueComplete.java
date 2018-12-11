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
    private final VueAdversaire vueAdversaire;
    private final VuePerso perso;
    
    public VueComplete()
    {
        this.vueAdversaire = new VueAdversaire();
        this.perso = new VuePerso();
       
       this.display(); 
       
    }

    @Override
    public void display() {
        //Panel principal
        Game=new JFrame();
        Game.setTitle("Bataille navale");
        Game.setLocationRelativeTo(null);
        Game.setSize(500,900);     
        Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
  

    


}
