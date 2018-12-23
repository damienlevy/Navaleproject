package modele;

/**
 *
 * @author trabels33u
 */
public class Case {
	private boolean toucher;
	private boolean eau;
	private int idBateau;

	public Case(int id) {
		this.eau = true;
		this.toucher = false; // par defaut
		this.idBateau = id;
	}

	public Case(int id, boolean toucher, boolean eau) {
		this.idBateau = id;
		this.toucher = toucher;
		this.eau = eau;
	}

	public void toucher() {
		this.toucher = true;
	}

	public boolean estTouche() {
		return this.toucher;
	}

	public boolean estEau() {
		return this.eau;
	}

	public void setEautouche() {
		this.eau = false;
	}

	// Return the id of the Naval
	public int getidBateau() {
		return this.idBateau;
	}

	public void setidBateau(int id) {
		this.idBateau = id;
	}

	public boolean isToucher() {
		return toucher;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.idBateau).append(",").append(this.toucher).append(",").append(this.eau);
		return sb.toString();
	}

}
