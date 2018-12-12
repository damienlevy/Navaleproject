/**
 * 
 */
package dao;

import modele.Jeu;

/**
 * @author levy54u
 *
 */
public class JeuDAOCSV implements JeuDAO {
	private static final JeuDAOCSV instance = new JeuDAOCSV();

	
	@Override
	public void save() {
		

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
