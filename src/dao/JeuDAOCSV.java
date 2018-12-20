/**
 * 
 */
package dao;

import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;

import modele.Jeu;
import modele.ModelClassique;
import modele.bateau.Bateau;

/**
 * @author levy54u
 *
 */
public class JeuDAOCSV implements JeuDAO {
	private static final JeuDAOCSV instance = new JeuDAOCSV();

	
	@Override
	public void save(String name,ModelClassique jeu) {
		try {
			String separator = "\n";
			String separatorArg = ",";
			FileWriter writer = new FileWriter(name);
			
			//type de joueur
			writer.append(jeu.getj1().getType());
			writer.append(separator);
			
			//bateau joueur 1
			for(Bateau b : jeu.getBateauJoueur1()) {
				
				//id bateau joueur 1
				writer.append(new Integer(b.getID()).toString());
				writer.append(separatorArg);
				
				//taille bateau
				writer.append(new Integer(b.getTaille()).toString());
				writer.append(separatorArg);
				
				//position bateau
				for(Point p : b.getPosition()) {
					writer.append(p.toString());
					writer.append(separatorArg);
				}
				
				//touche
				for(Point p : b.getTouche()) {
					writer.append(p.toString());
					writer.append(separatorArg);
				}
				
				/*
				writer.append();
				writer.append();*/
				
			}
			
			//writer.append(jeu.getBateauJoueur1())
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Jeu load() {
		
		return null;
	}

	public static JeuDAO getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

}
