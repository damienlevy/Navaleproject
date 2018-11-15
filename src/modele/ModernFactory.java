/**
 * 
 */
package modele;

import modele.bateau.Bateau;
import modele.bateau.antiquite.BateauAntique3_1;
import modele.bateau.moderne.BateauModerne2;
import modele.bateau.moderne.BateauModerne3_2;
import modele.bateau.moderne.BateauModerne4;

/**
 * @author levy54u
 *
 */
public class ModernFactory implements EpoqueFactory {

	private int id;
	/**
	 * 
	 */
	public ModernFactory() {
		this.id = 0;
	}

	@Override
	public Bateau createBateau2() {
		
		return new BateauModerne2(id++);
	}

	@Override
	public Bateau createBateau3_1() {
		
		return new BateauModerne3_1(id++);
	}

	@Override
	public Bateau createBateau3_2() {
		
		return new BateauModerne3_2(id++);
	}

	@Override
	public Bateau createBateau4() {
		return new BateauModerne4(id++);
	}

	@Override
	public Bateau createBateau5() {
		return new BateauModerne5(id++);
	}

}
