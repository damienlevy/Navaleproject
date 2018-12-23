package modele.factory;

import modele.bateau.Bateau;

/**
 * @author levy54u
 *
 */
public interface EpoqueFactory {

	/**
	 * 
	 * @return bateau de 2 case
	 */
	public Bateau createBateau2();

	/**
	 * 
	 * @return bateau de 3 case
	 */
	public Bateau createBateau3_1();

	/**
	 * 
	 * @return bateau de 3 case
	 */
	public Bateau createBateau3_2();

	/**
	 * 
	 * @return bateau de 4 case
	 */
	public Bateau createBateau4();

	/**
	 * 
	 * @return bateau de 5 case
	 */
	public Bateau createBateau5();

	// fonction pour recreer des bateau sauvegarder avec le meme id
	public Bateau createBateau2(int id);

	public Bateau createBateau3_1(int id);

	public Bateau createBateau3_2(int id);

	public Bateau createBateau4(int id);

	public Bateau createBateau5(int id);

}
