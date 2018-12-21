/**
 * 
 */
package dao;

import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;

import modele.Case;
import modele.Jeu;
import modele.Joueur;
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
		Joueur j = jeu.getj1();
		Case c = null;
		name +=".csv";
		try {
			String separator = "\n";
			String separatorArg = ",";
			FileWriter writer = new FileWriter(name);
			
			//writer.append(jeu.getEpoque());
			
			for (int a = 0; a < 2; a++) {
				// type de joueur j1
				writer.append(j.getType());
				
				writer.append(separator);

				// munition restante
				writer.append(new Integer(j.getMunition()).toString());
				
				writer.append(separator);

				// bateau joueur 1
				for (Bateau b : jeu.getBateau(j)) {

					// id bateau joueur 1
					writer.append(new Integer(b.getID()).toString());
					writer.append(separator);

					// taille bateau
					writer.append(new Integer(b.getTaille()).toString());
					writer.append(separator);

					// position bateau
					if (b.getPosition().isEmpty()) {
						writer.append("Null");
						writer.append(separator);
					} else {
						for (Point p : b.getPosition()) {
							//writer.append(p.toString());
							writer.append(new Integer(p.x).toString());
							writer.append(separatorArg);
							writer.append(new Integer(p.y).toString());
							writer.append(separator);

						}
					}
					// touche
					if (b.getTouche().isEmpty()) {
						writer.append("Null");
						writer.append(separator);

					} else {
						for (Point p : b.getTouche()) {
							writer.append(new Integer(p.x).toString());
							writer.append(separatorArg);
							writer.append(new Integer(p.y).toString());
							//writer.append(p.toString());
							writer.append(separator);

						}
						writer.append(separator);

					}
				}
				//plateau
				for (int i = 0; i < j.getPlateau().getPlateau().length; i++) {
					for (int k = 0; k < j.getPlateau().getPlateau()[0].length; k++) {
						c = j.getPlateau().getCase(i, k);
						writer.append(c.toString());
						writer.append(separatorArg);
					}
					writer.append(separator);
				}
				
				j = jeu.getIa();				
			}
			

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Jeu load() {
		
		
		return null;
	}

	public static JeuDAO getInstance() {
		
		return instance;
	}

}
