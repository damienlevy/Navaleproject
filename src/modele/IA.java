/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modele.bateau.Bateau;

/**
 *
 * @author trabels33u
 */
public class IA extends Joueur {
 private List<Point> p ;
 

	
    public IA(int munition, List<Bateau> b){
       
                 super(munition, b);
               
                 placerBateaux(b);
                 plateau.afficherPlateau();
	}

    
   private Point getPointAlea()
   {
       Point p = new Point();
       Random r = new Random();
       p.x = r.nextInt(8)+1;
       p.y = r.nextInt(8)+1;
      // p.x =1 + (int)(Math.random() * ((11 - 1) + 1));
       //p.y =1 + (int)(Math.random() * ((11 - 1) + 1));
       return p;
   }    
        
   private boolean verfierPoitionVertical(Bateau b ,Point p)
   {
          if(b.getTaille()+ p.y > 11 ) //&& b.getTaille()- p.y < 1
              return false;         
          return true ;
          
   }
     private boolean verfierPoitionHorizontal(Bateau b ,Point p)
   {
          if(b.getTaille()+ p.x > 11  )//&& b.getTaille()- p.x < 1
              return false;         
          return true ;     
   }
   
   private boolean positionEstVideH(Bateau b , Point first)
   {
       int i =0;
       boolean cont =true;
        while(i<b.getTaille()&& cont== true)
              {
               if(plateau.estVide(super.plateau.plateau[first.x+i][first.y]))
                 i++;
               else if(!plateau.estVide(plateau.plateau[first.x+i][first.y]))
               { cont = false ; return false ;}
               else 
                   return false;
               }
       return true;
   }
   
      private boolean positionEstVideV(Bateau b , Point first)
   {
       int i =0;
       boolean cont =  true ;
        while(i < b.getTaille() && cont ==true)
              {
               if(plateau.estVide(plateau.plateau[first.x][first.y+i]))
               {
                   i++;
                   cont=true; 
               }
               else cont= false ;
             
               
               }
         
                 
       return cont ;
   }
   
   private boolean positionBateau(Bateau b)
     {
         ArrayList<Point> position = new ArrayList<>(5);
        
         //point alea
          Point first ;
          first= getPointAlea();
          System.out.println(first);
          System.out.println(b.getTaille());
          int orientation = 1+(int)(Math.random() * (( 2 - 1 )+1)); // 1 horizontal 2 vertical
          boolean bd ;
          switch(orientation)
          {  
              case 1 : if(bd= verfierPoitionHorizontal(b ,first)){
                   System.out.println(bd);
                            if(positionEstVideH(b,first))
                            {
                                for(int i =0 ; i<b.getTaille();i++)
                                {
                                    super.plateau.plateau[first.x+i][first.y].setidBateau(b.getID());
                                    position.add(new Point(first.x+i, first.y));
                                }
                               placerBateau( b, position);
                                return true ;
                            }
                            else return false ;
                       }         
                       else 
                           return false ;
                       
              case 2 : if(verfierPoitionVertical(b ,first))
                          { 
                            if(positionEstVideV(b,first))
                           {
                               for(int i =0 ; i< b.getTaille();i++)
                               {
                                   plateau.plateau[first.x][first.y+i].setidBateau(b.getID());
                                     System.out.println("id bateau " +plateau.plateau[first.x][first.y+i].getidBateau());
                                   position.add(new Point(first.x, first.y+i));
                               }
                             placerBateau( b,position);
                             return true ;
                           }
                            else return false ;
                          }
                       else 
                           return false ;
              default : return false ; 
              
          }
          
        
          
     }
   
     public void placerBateau(Bateau b ){
    	b.setPosition(p);
       // this.plateau.allocatePosition(b.getID(), p);
    	    	
    }
     public void placerBateaux(List<Bateau> bateaux )
     {
         
         for(Bateau b : bateaux )
         {
             boolean pos = positionBateau( b);
             if(pos == false )
             {
                 while(pos==false )
                     pos = positionBateau(b);
             }
            
       
         }    
    }


	@Override
	public String getType() {
		return "ia";
	}
     
}

