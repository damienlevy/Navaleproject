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
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import modele.Case;
import modele.Joueur;
import modele.Plateau;
import modele.bateau.Bateau;

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
    private Controleur controleur;
    private final static Point[] p= new Point[100];
    private static int compteur =0;
    private static boolean first =true;
    private int position ;
    private boolean tire;
    private static int nbBateau = 0;
    private MenuSave save;
    public VueComplete(Controleur c)
    {
    	controleur = c;
        this.vueAdversaire = new VueAdversaire(c);
        this.perso = new VuePerso(c);  
       this.save = new MenuSave(c);
       ActionListennerPerso();
       
        vueAdversaire.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
 if(tire== true){
                       chercherCase(e.getX()/37, e.getY()/37);
                       vueAdversaire.repaint();}
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
        tire=false;
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
         { this.vueAdversaire.model.getPlateauIA().plateau[x][y].setEautouche();
         
         }
       
         tire=false;
         controleur.getModele().getIa().munitionLose();
         verifPointTouche();
          perso.repaint();
         
       
      
    }
  void verifPointTouche()
  {
       Point p2 = controleur.getModele().getIa().tirerCroix(controleur.getModele().getPlateauJoueur1()) ;
      
       if(controleur.getModele().getPlateauJoueur1().plateau[p2.x][p2.y].getidBateau() > 0)
         {
             controleur.getModele().getPlateauJoueur1().plateau[p2.x][p2.y].toucher();  
              System.out.println("POINT ALEATPORE // "+p2 +" id bateau :" +controleur.getModele().getPlateauJoueur1().plateau[p2.x][p2.y].getidBateau()+"touche "+controleur.getModele().getPlateauJoueur1().plateau[p2.x][p2.y].estTouche() );
             perso.repaint();
         
         }
         else 
         { controleur.getModele().getPlateauJoueur1().plateau[p2.x][p2.y].setEautouche();
         
          perso.repaint();
         }
           p2 = controleur.getModele().getIa().tirerCroix(controleur.getModele().getPlateauJoueur1()) ;
         tire=true;
         controleur.getModele().getj1().munitionLose();
          perso.repaint();
  }
  
  void ActionListennerPerso()
  {
      perso.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
             List<Bateau> bat = controleur.getModele().getBateauJoueur1();
            
           for(Bateau b : bat)
           {
               System.out.println(b.getID());
           }
                if(first == true && nbBateau <5)
                {
                    first = remplirCompteur(e.getX()/37,e.getY()/37 );
                    perso.draw(e.getX()/37,e.getY()/37 );
                    perso.setDraw(true);
                    perso.repaint();                  
                }
                
                if(first==false && nbBateau <5)
                {
                   
                    first = remplirCompteur(e.getX()/37,e.getY()/37 );   
                   
                }
                  
            
              perso.repaint();
              if(nbBateau>4)
                  tire=true;
            
            }
            
            });
      }

          private boolean remplirCompteur(int i, int i0) {
              if(first==true) //on verifie pas la point 
              {
                    p[getCompteur()]= new Point(i,i0);
                    incrimentCompteur();
                   
                    //System.out.println(p[compteur-1].x +" y :" + p[compteur-1].y);
                   return false;
              }
             else if(first==false)
              {
                 Point actuel = new Point(i,i0);
                 System.out.println(actuel);
                 position = perso.checkPointOrientation(actuel);
                 if(position != -1){
                    Bateau b = controleur.getModele().getBateauJoueur1().get(nbBateau);
                     System.out.println("ok");
                      if(position== 1 && ((i)+b.getTaille())<=11)
                      {  System.out.println("ok");
                          for(int j=0 ;j<b.getTaille() ; j++)
                          {
                          controleur.getModele().getPlateauJoueur1().plateau[(i-1)+j][i0].setidBateau(b.getID());                                
                          p[getCompteur()]=new Point(i,i0);
                          incrimentCompteur(); 
                        
                          }
                                 
                          
                nbBateau++;
                         return true;
                      }
                      if(position== 2 && ((i0)+b.getTaille())<=11)
                      {  System.out.println("ok");
                          for(int j=0 ; j<b.getTaille() ; j++)
                          {
                          controleur.getModele().getPlateauJoueur1().plateau[i][(i0-1)+j].setidBateau(b.getID());                                
                          p[getCompteur()]=new Point(i,i0);
                          incrimentCompteur(); 
                        
                          }
                nbBateau++;
                         return true;
                         
                      }
                       if(position== 3 &&  i-b.getTaille()>=0)
                      {  System.out.println("ok");
                          for(int j=0 ; j<b.getTaille() ; j++)
                          {
                          controleur.getModele().getPlateauJoueur1().plateau[(i+1)-j][i0].setidBateau(b.getID());                                
                          p[getCompteur()]=new Point(i,i0);
                          incrimentCompteur(); 
                        
                          }
                nbBateau++;
                         return true;
                         
                      }
                        if(position== 4 && i0-b.getTaille()>=0)
                      {  System.out.println("ok");
                          for(int j=0 ; j<b.getTaille() ; j++)
                          {
                          controleur.getModele().getPlateauJoueur1().plateau[i][(i0+1)-j].setidBateau(b.getID());                                
                          p[getCompteur()]=new Point(i,i0);
                          incrimentCompteur(); 
                        
                          }
                nbBateau++;
                         return true;
                         
                      }
                      
                 }
              }
             
             
                 return  false ;
             
          }  

    private int getCompteur() {
return this.compteur;
    }

    private void incrimentCompteur() {
this.compteur++;    }
              
}
    /*    void placerBateau(int x , int y , Bateau b)
              {
                     List<Point> locat = new ArrayList<Point>();
                   
 
                        perso.setTaille(b.getTaille());
                      
                        switch(compteur)
                        {
                            case 0 :    p[compteur]=new Point(x/37,x/37);
                                        System.out.println(e.getX()/37+" y : "+e.getY()/37);
                                         perso.draw(e.getX()/37,e.getY()/37 );
                                         perso.setDraw(true);
                                         compteur++;
                                         break;
                           case 1 :      p[compteur]=new Point(e.getX()/37,e.getY()/37);
                                         System.out.println(e.getX()/37+" y : "+e.getY()/37);
                                         System.out.println("Verification deuxieme point");
                                         int i = perso.checkPointOrientation(p[1]);
                                         switch(i)
                                         {
                                             case 1:                                                  
                                                      for(int j= 0; j<=b.getTaille();j++)
                                                      {
                                                          locat.add(new Point((e.getX()+j)/37, e.getY()/37));
                                                         
                                                          controleur.getModele().getPlateauJoueur1().plateau[(e.getX()+j)/37][e.getY()/37].setidBateau(b.getID());
                                                          System.out.println(  controleur.getModele().getPlateauJoueur1().plateau[(e.getX()+j)/37][e.getY()/37].getidBateau());
                                                      }
                                                      controleur.getModele().getj1().placerBateau(b, locat);
                                                     break;
                                                     
                                                                                               }
                                        
                          // default : compteur =0;
}}
                            
              }
             
}*/
  
