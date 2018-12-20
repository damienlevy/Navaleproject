/**
 * 
 */
package dao;

import modele.Jeu;
import modele.ModelClassique;

/**
 * @author levy54u
 *
 */
public interface JeuDAO {
	
	public void save(String name,ModelClassique jeu);
	public Jeu load();

}
