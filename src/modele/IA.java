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

/**
 *
 * @author trabels33u
 */
public class IA extends Joueur {
	private List<Point> p ;


	public IA(int munition, List<Bateau> b){

		super(munition, b);
	}

	private Point getPointAlea()
	{
		Point p = new Point();
		p.x =1 + (int)(Math.random() * ((11 - 1) + 1));
		p.y =1 + (int)(Math.random() * ((11 - 1) + 1));
		return p;
	}    

	private boolean verfierPoitionVertical(Bateau b ,Point p)
	{
		if(b.getTaille()+p.y > plateau.Height+1  ) //&& b.getTaille()- p.y < 1
			return false;         
		return true ;

	}
	private boolean verfierPoitionHorizontal(Bateau b ,Point p)
	{
		if(b.getTaille()+p.y > plateau.Width+1  )//&& b.getTaille()- p.x < 1
			return false;         
		return true ;     
	}

	private boolean positionEstVideH(Bateau b , Point first)
	{
		int i =0;

		while(i<=b.getTaille())
		{
			if(this.plateau.estVide(this.plateau.plateau[first.x+i][first.y]))
				i++;
			else 
				return false;
		}
		return true;
	}

	private boolean positionEstVideV(Bateau b , Point first)
	{
		int i =0;

		while(i<=b.getTaille())
		{
			if(this.plateau.estVide(this.plateau.plateau[first.x][first.y+i]))
				i++;
			else 
				return false;
		}
		return true;
	}

	private boolean positionBateau(Bateau b)
	{

		//point alea
		Point first ;
		first= getPointAlea();

		int oriantation = 1+(int)(Math.random() * (( 2 - 1 )+1)); // 1 horizontal 2 vertical
		switch(oriantation)
		{
		case 1 : if(verfierPoitionHorizontal(b ,first)){
			if(positionEstVideV(b,first))
			{
				for(int i =0 ; i<= b.getTaille();i++)
					this.plateau.plateau[first.x+i][first.y].setidBateau(b.getID());
				// placerBateau( b, first);
				return true ;
			}
		}         
		else 
			return false ;

		case 2 : if(verfierPoitionVertical(b ,first))
		{ 
			if(positionEstVideV(b,first))
			{
				for(int i =0 ; i<= b.getTaille();i++)
					this.plateau.plateau[first.x][first.y+1].setidBateau(b.getID());
				//  placerBateau( b,first);
				return true ;
			}
		}
		else 
			return false ;
		default : return false ; 

		}



	}

	public void placerBateau(Bateau b ){
		b.setPosition(p);

	}
}
