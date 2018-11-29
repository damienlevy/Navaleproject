/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import javax.swing.JFrame;
import static vues.Vue.Height;
import static vues.Vue.Width;

/**
 *
 * @author TRABELSI
 */
public class VueAdversaire extends Vue implements GameVue {
    private final static int POSX = 900;
 public VueAdversaire()
    {
        
        this.display();
    }

    @Override
   public void display() {      
    Vue v = new Vue();
   this.game = new JFrame();
   this.game.setSize(Width , Height);
   this.game.setTitle("Bataille navale (Adversaire)");
    this.game.getContentPane().add(v);
   this.game.setVisible(true);
   this.game.setLocation(POSX,0);
  this.game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
