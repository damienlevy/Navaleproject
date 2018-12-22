/**
 * 
 */
package modele.factory;

import modele.bateau.Bateau;
import modele.bateau.antiquite.*;


/**
 * @author levy54u
 *
 */
public class AntiquiteFactory implements EpoqueFactory {

	private int id;
	/**
	 * 
	 */
	public AntiquiteFactory() {
		this.id = 1;
	}

	@Override
	public Bateau createBateau2() {
		return new BateauAntique2(id++);
	}

	@Override
	public Bateau createBateau3_1() {
		return new BateauAntique3_1(id++);
	}

	@Override
	public Bateau createBateau3_2() {
		return new BateauAntique3_2(id++);
	}

	@Override
	public Bateau createBateau4() {
		return new BateauAntique4(id++);
	}

	@Override
	public Bateau createBateau5() {
		return new BateauAntique5(id++);
	}
	
	public String toString() {
		return "AntiquiteFactory";
	}

	@Override
	public Bateau createBateau2(int id) {
		return new BateauAntique2(id);
	}

	@Override
	public Bateau createBateau3_1(int id) {
		return new BateauAntique3_1(id);
	}

	@Override
	public Bateau createBateau3_2(int id) {
		return new BateauAntique3_2(id);
	}

	@Override
	public Bateau createBateau4(int id) {
		return new BateauAntique4(id);
	}

	@Override
	public Bateau createBateau5(int id) {
		return new BateauAntique5(id);
	}

}
