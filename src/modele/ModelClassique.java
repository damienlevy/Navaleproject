/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;
import dao.DAOFactoryCSV;
import dao.JeuDAO;

import modele.bateau.Bateau;
import modele.factory.AntiquiteFactory;
import modele.factory.EpoqueFactory;


/**
 *
 * @author trabels33u
 */
public class ModelClassique extends Jeu {

	protected Joueur j1;
	protected Joueur ia;

	public ModelClassique(EpoqueFactory epoque){
		super(epoque);
		ArrayList<Bateau> bateauJoueur1;
		ArrayList<Bateau> bateauJoueur2;
		bateauJoueur1 = new ArrayList<>();
		addBateau(epoque, bateauJoueur1);
		bateauJoueur2 = new ArrayList<>();
		this.addBateau(epoque, bateauJoueur2);
		
		this.j1 = new Humain(100,bateauJoueur1);
		this.ia = new IA(100,bateauJoueur2);
	}
	
	public ModelClassique(EpoqueFactory e,Joueur j1 , Joueur j2) {
		super(e);
		this.j1 = j1;
		this.ia = j2;
		
	}

	public List<Bateau> getBateauJoueur1() {
		return j1.getBateau();
	}

	public List<Bateau> getBateauIA() {
		return ia.getBateau();
	}
	public List<Bateau> getBateau(Joueur j){
		return j.getBateau();
	}

	public Plateau getPlateauJoueur1() {
		return j1.getPlateau();
	}

	public Plateau getPlateauIA() {
		return ia.getPlateau();
	}


	private void addBateau(Bateau b, ArrayList<Bateau> listBateau){
		listBateau.add(b);
	}
	private void addBateau(EpoqueFactory epoque,ArrayList<Bateau> listBateau){
		this.addBateau(epoque.createBateau2() , listBateau);
		this.addBateau(epoque.createBateau3_1() , listBateau);
		this.addBateau(epoque.createBateau3_2() , listBateau);
		this.addBateau(epoque.createBateau4() , listBateau);
		this.addBateau(epoque.createBateau5() , listBateau);
	}



	@Override
	public void placerBateau(Bateau bateau , ArrayList<Point> p,Joueur j) {
		j.placerBateau(bateau, p);
		notifyVue();
	}

	@Override
	public void jouer() {

	}

	@Override
	public
	void finDePartie() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public
	void save() {
		DAOFactoryCSV dao = (DAOFactoryCSV) DAOFactory.getInstance(0);
		dao.getJEUDAO().save("test", this);
	
	}

	@Override
	public
	void load() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public EpoqueFactory getEpoque()
	{
		return this.epoque;
	}

	public void tirer(Point c, Joueur j) {
		getOtherJoueur(j).tirer(c);
		notifyVue();
	}


	private Joueur getOtherJoueur(Joueur j) {		
		return j.equals(j1) ? ia : j1;
	}
	
	public String typeJoueur(Joueur j) {
		return j.getType();
	}
	public Joueur getj1() {
		return this.j1;
	}
	public Joueur getIa() {
		return this.ia;
	}
	
	public static void main(String[] argv){
		ModelClassique mc = new ModelClassique(new AntiquiteFactory());
		int i = 1;
		int j = 2;
		/*for(Bateau b : mc.getBateauJoueur1()) {	
			System.out.println("OKKKKKKK");
			i++;
			j++;
		ArrayList<Point> l = new ArrayList<Point>();
		l.add(new Point(i,j));
		i++;
		l.add(new Point(i,j));
		mc.placerBateau(b,l ,mc.getj1());
		}*/
		
		
		/*
		l = new ArrayList<>();
		l.add(new Point(2, 3));
		l.add(new Point(3, 3));
		l.add(new Point(4, 3));
		mc.placerBateau(mc.getBateauJoueur1().get(1),l ,mc.getj1());*/
		
		mc.save();
		System.out.println("OKKKKKKK");
		
	}
}
