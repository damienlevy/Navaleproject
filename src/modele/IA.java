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
		placerBateaux();
	}


	public Point tirerRandom(Plateau p) {
		Point cible;
		Random r =  new Random();
		Case[][] plateau  = p.getPlateau();
		cible = new Point(r.nextInt(9)+1, r.nextInt(9)+1);
		while(plateau[cible.x][cible.y].estTouche()){
			cible = new Point(r.nextInt(9)+1, r.nextInt(9)+1);	
		}
		return cible;
	}

	public Point tirerCroix(Plateau p) {
		ArrayList<Point> lp = getToucheBateau(p);
		ArrayList<Point> toucher = getToucher(p);
		Point cible = tirerRandom(p);
		Point tempo;
		Case[][] plateau  = p.getPlateau();
		for (Point point : lp) {
			tempo = new Point(point.x-1, point.y );
			if(point.x-1 > 0 && !toucher.contains(tempo)) {
				cible = tempo;
			}
			tempo = new Point(point.x+1, point.y );
			if(point.x+1 < 12 && !toucher.contains(tempo)) {
				cible = tempo;
			}
			tempo = new Point(point.x, point.y-1 );
			if(point.y-1 > 0 && !toucher.contains(tempo)) {
				cible = tempo;
			}
			tempo = new Point(point.x, point.y+1 );
			if(point.y+1 < 12 && !toucher.contains(tempo)) {
				cible = tempo;
			}
		}
		return cible;
	}

	private ArrayList<Point> getToucher(Plateau p) {
		ArrayList<Point> lp = new ArrayList<>();
		Case[][] plateau = p.getPlateau();
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				if(plateau[i][j].estTouche()){
					lp.add(new Point(i,j));
				}
			}
		}
		return lp;
	}

	private ArrayList<Point> getToucheBateau(Plateau p){
		ArrayList<Point> lp = new ArrayList<>();
		Case[][] plateau = p.getPlateau();
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				if(plateau[i][j].estTouche() && plateau[i][j].getidBateau() != -1){
					lp.add(new Point(i,j));
				}
			}
		}
		return lp;
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
		int orientation = 1+(int)(Math.random() * (( 2 - 1 )+1)); // 1 horizontal 2 vertical
		boolean bd ;
		switch(orientation)
		{  
		case 1 : if(bd= verfierPoitionHorizontal(b ,first)){
			if(positionEstVideH(b,first))
			{
				for(int i =0 ; i<b.getTaille();i++)
				{
					super.plateau.plateau[first.x+i][first.y].setidBateau(b.getID());

					position.add(new Point(first.x+i, first.y));
				}
				placerBateau( b, position);

				setPositionBateau(b, position);

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
					position.add(new Point(first.x, first.y+i));
				}
				placerBateau( b,position);
				setPositionBateau(b, position);
				return true ;
			}
			else return false ;
		}
		else 
			return false ;
		default : return false ; 

		}
	}
	
	public void setPositionBateau(Bateau b, ArrayList<Point> position) {
		for(Bateau bat : bateaux) {
			if(bat.getID() == b.getID()) {
				bat.setPosition(position);
			}
		}
	}
	
	public void placerBateaux()
	{
		for(Bateau b : bateaux )
		{
			boolean pos = positionBateau(b);
			if(pos == false )
			{
				while(pos==false ) {
					pos = positionBateau(b);
				}
			}
		}
	}



	@Override
	public String getType() {
		return "ia";
	}

}

