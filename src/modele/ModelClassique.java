/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import modele.bateau.Bateau;
import modele.factory.AntiquiteFactory;
import modele.factory.EpoqueFactory;
import modele.factory.ModernFactory;

/**
 *
 * @author trabels33u
 */
public class ModelClassique extends Jeu {
    
	 protected Joueur j1;
     protected Joueur ia;

     
     
 	public ModelClassique(EpoqueFactory epoque){
 		super(epoque);
        ArrayList<Bateau> bateauJoueur1;
        ArrayList<Bateau> bateauJoueur2;
    	bateauJoueur1 = new ArrayList<>();
    	addBateau(epoque, bateauJoueur1);
    	bateauJoueur2 = new ArrayList<>();
    	this.addBateau(epoque, bateauJoueur2);
    	this.j1 = new Humain(100,bateauJoueur1);
    	this.ia = new IA(100,bateauJoueur2);
    }
    
    public List<Bateau> getBateauJoueur1() {
		return j1.getBateau();
	}

	public List<Bateau> getBateauIA() {
		return ia.getBateau();
	}

	public Plateau getPlateauJoueur1() {
		return j1.getPlateau();
	}

	public Plateau getPlateauIA() {
		return ia.getPlateau();
	}

    
    private void addBateau(Bateau b, ArrayList<Bateau> listBateau){
    	listBateau.add(b);
    }
    private void addBateau(EpoqueFactory epoque,ArrayList<Bateau> listBateau){
    	this.addBateau(epoque.createBateau2() , listBateau);
    	this.addBateau(epoque.createBateau3_1() , listBateau);
    	this.addBateau(epoque.createBateau3_2() , listBateau);
    	this.addBateau(epoque.createBateau4() , listBateau);
    	this.addBateau(epoque.createBateau5() , listBateau);
    }
    

   
    @Override
   public void placerBateau(Bateau bateau , List<Point> p,Joueur j) {
		/*
		 * Plateau pla; //check Game board if(plateau == plateauJoueur1)
		 * pla=this.getPlateauJoueur1(); else pla = this.getPlateauJoueur2();
		 * 
		 * //check boat type if(this.getEpoque() instanceof AntiquiteFactory ) {
		 * this.setNBCASE(4); } else if(this.getEpoque() instanceof
		 * ModernFactory){ this.setNBCASE(2); } //verfiy if this position in the
		 * Game boeard is already empty if(pla.positionVide(p) == false ||
		 * VerifyPosition(p) ) System.out.println("Position already token "); //
		 * give an other Empty position else { bateau.setPosition(p); //place it
		 * on the Game board too pla. allocatePosition(bateau.getID() ,p);
		 * setPlateau(pla, plateau); //faudra mieu la changer }
		 
    	if(this.verifierPoint(plateau, p)){
    		plateau.allocatePosition(bateau.getID(), p);
    	}
    	*/
    	
    	j.placerBateau(bateau, p);
    	
    	
    }

    @Override
    public void jouer() {
        
    }

    @Override
	public
    void finDePartie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
	public
    void addVue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
	public
    void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
	public
    void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EpoqueFactory getEpoque()
    {
        return this.epoque;
    }

/*
    private void setPlateau(Plateau pla, Plateau plateau) {
       if(plateau==this.plateauJoueur1)
          this.plateauJoueur1=pla;
       else if(plateau == this.plateauJoueur2)
         this.plateauJoueur2=pla;
    }
    
    private boolean VerifyPosition(Point ...p)
    {
     if(this.NBCases ==( p[2].y-p[0].y))
     {
         if((p[1].x - p[0].x) == 1)
             return true ;
     }
     return false ;
    }
    */
   
    
}
