/**
 * 
 */
package modele.factory;

import modele.bateau.Bateau;

/**
 * @author levy54u
 *
 */
public interface EpoqueFactory {
	
	public Bateau createBateau2();
	public Bateau createBateau3_1();
	public Bateau createBateau3_2();
	public Bateau createBateau4();
	public Bateau createBateau5();
	public Bateau createBateau2(int id);
	public Bateau createBateau3_1(int id);
	public Bateau createBateau3_2(int id);
	public Bateau createBateau4(int id);
	public Bateau createBateau5(int id);
	
}
