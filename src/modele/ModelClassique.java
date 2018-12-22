/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;
import dao.DAOFactoryCSV;
import dao.JeuDAO;

import modele.bateau.Bateau;
import modele.factory.AntiquiteFactory;
import modele.factory.EpoqueFactory;
import modele.factory.ModernFactory;


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
		dao.getJEUDAO().save("sauvegarde_navale_project", this);
	
	}
	void save(String nom) {
		DAOFactoryCSV dao = (DAOFactoryCSV) DAOFactory.getInstance(0);
		dao.getJEUDAO().save(nom, this);
	
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
		}
		l = new ArrayList<>();
		l.add(new Point(2, 3));
		l.add(new Point(3, 3));
		l.add(new Point(4, 3));
		mc.placerBateau(mc.getBateauJoueur1().get(1),l ,mc.getj1());*/
		
		mc.save();
		
		String separatorArg = ",";
		BufferedReader br = null;
		String line ="";
		EpoqueFactory factory = null;
		Joueur j1 = null;
		Joueur ia = null;
		int munition = 0;
		ArrayList<Bateau> b1 = new ArrayList<>(); 
		ArrayList<Bateau> b2 = new ArrayList<>();
		ArrayList<Point> point = null;//new ArrayList<>();
		int id;
		int taille;
		Bateau b =null;
		String[] tabpoint = null;
		Case[][] cas = new Case[11][11];
		boolean boo = false,boo1 = false;
		Plateau p = null;
		try {
			
			br = new BufferedReader(new FileReader("test.csv"));
			line = br.readLine();
			//System.out.println(line);
			if(line.equals("AntiquiteFactory")) {
				factory = new AntiquiteFactory();
			}else {
				factory = new ModernFactory();
			}
			//System.out.println(line);
			line = br.readLine();
			//System.out.println(line);
			line = br.readLine();
			//System.out.println(line);
			for(int compteur =0 ; compteur < 2 ; compteur++) {
			if(line.equals("humain")) {
				line = br.readLine();
				//System.out.println(line);
				munition = Integer.parseInt(line);
				line = br.readLine();
				//System.out.println(line);
				for(int ii= 0 ; ii < 5 ; ii++) {
					
					//line = br.readLine();
					id = Integer.parseInt(line);
					//System.out.println("id : "+id);
					line = br.readLine();
					//System.out.println(line);
					taille = Integer.parseInt(line);
					if(taille == 2) {
						b = factory.createBateau2(id);
						b1.add(b);
					}else if(taille == 3) {
						b = factory.createBateau3_1(id);
						b1.add(b);
					}else if(taille == 4) {
						b =factory.createBateau4(id);
						b1.add(b);
					}else if(taille ==5) {
						b = factory.createBateau5(id);
						b1.add(b);
					}
					
					
					line = br.readLine();
					//System.out.println(line);
					tabpoint = null;
					if(line.equals("listePosition")) {
						line = br.readLine();
						//System.out.println(line);
						if(!line.equals("null")) {
						
							while(!line.equals("touche")) {
								int x , y;
								tabpoint = line.split(separatorArg);
								x = Integer.parseInt(tabpoint[0]);
								y = Integer.parseInt(tabpoint[1]);
								point.add(new Point(x, y));
								
								line = br.readLine();
							}
							b.setPosition(point);
						}
					}
					line = br.readLine();
					//System.out.println(line);
					point = new ArrayList<>();
					if(line.equals("touche")) {
						line = br.readLine();
						//System.out.println(line);
						if(!line.equals("null")) {
							while(!line.equals("plateau")) {
								
								int x , y;
								tabpoint = line.split(separatorArg);
								x = Integer.parseInt(tabpoint[0]);
								y = Integer.parseInt(tabpoint[1]);
								b.touche(new Point(x, y));
								line = br.readLine();
							}
						}
						line = br.readLine();
						//System.out.println(line);
						
						
										
						
					}
					

					
					
				}
				int comptx = 0 , compty = 0 ;
				line = br.readLine();
				//System.out.println(line);
				
				while((!line.equals("joueur"))&& ((line) != null)){
					//System.out.println(line);
					tabpoint = line.split(separatorArg);
							//System.out.println(tabpoint[1]);
							if(tabpoint[1].equals("true")) {
								boo = true;
							}else {
								boo = false;
							}
							if(tabpoint[2].equals("true")) {
								boo1 = true;
							}else {
								boo1 = false;
							}
							cas[comptx][compty] = new Case(Integer.parseInt(tabpoint[0]),boo,boo1);
							compty ++;
							if(compty>10) {
								comptx++;
								compty = 0;
								
							}
							if(comptx>10) {
								comptx = 0;
							}
					line = br.readLine();
						
				}
				p = new Plateau(cas);
				//p.afficherPlateau();
				
				
				line = br.readLine();
				//System.out.println(line);
				j1=new Humain(munition,b1,p );
			}
			else if(line.equals("ia")) {
				cas = new Case[11][11];
				tabpoint=null;
				line = br.readLine();
				//System.out.println(line);
				munition = Integer.parseInt(line);
				line = br.readLine();
				//System.out.println(line);
				for(int ii= 0 ; ii < 5 ; ii++) {
					
					//line = br.readLine();
					id = Integer.parseInt(line);
					//System.out.println("id : "+id);
					line = br.readLine();
					System.out.println(line);
					taille = Integer.parseInt(line);
					if(taille == 2) {
						b = factory.createBateau2(id);
						b2.add(b);
					}else if(taille == 3) {
						b = factory.createBateau3_1(id);
						b2.add(b);
					}else if(taille == 4) {
						b =factory.createBateau4(id);
						b2.add(b);
					}else if(taille ==5) {
						b = factory.createBateau5(id);
						b2.add(b);
					}
					
					
					line = br.readLine();
					//System.out.println(line);
					
					point = new ArrayList<>();
					if(line.equals("listePosition")) {
						line = br.readLine();
						//System.out.println(line);
						if(!line.equals("null")) {
							
							while(!line.equals("touche")) {
								//System.out.println(line);
								int x , y;
								tabpoint = line.split(separatorArg);
								x = Integer.parseInt(tabpoint[0]);
								y = Integer.parseInt(tabpoint[1]);
								point.add(new Point(x, y));
								
								
								line = br.readLine();
								//System.out.println(line);
							}
							b.setPosition(point);
							//System.out.println(point);

						}
					}
					//line = br.readLine();
					//System.out.println(line);
					point = new ArrayList<>();
					if(line.equals("touche")) {
						line = br.readLine();
						//System.out.println(line);
						if(!line.equals("null")) {
							while(!line.equals("plateau")) {
								
								int x , y;
								tabpoint = line.split(separatorArg);
								x = Integer.parseInt(tabpoint[0]);
								y = Integer.parseInt(tabpoint[1]);
								b.touche(new Point(x, y));
								line = br.readLine();
							}
						}
						line = br.readLine();
						//System.out.println(line);	
					}
				}
				int comptx = 0 , compty = 0 ;
				line = br.readLine();
				//System.out.println(line);
				
				while( ((line) != null) && (!line.equals("joueur"))){
					//System.out.println(line);
					tabpoint = line.split(separatorArg);
						//	System.out.println(tabpoint[1]);
							if(tabpoint[1].equals("true")) {
								boo = true;
							}else {
								boo = false;
							}
							if(tabpoint[2].equals("true")) {
								boo1 = true;
							}else {
								boo1 = false;
							}
							cas[comptx][compty] = new Case(Integer.parseInt(tabpoint[0]),boo,boo1);
							compty ++;
							if(compty>10) {
								comptx++;
								compty = 0;
							}
							if(comptx>10) {
								comptx = 0;
							}
					line = br.readLine();
				}
				p = new Plateau(cas);
				//p.afficherPlateau();
				ia = new IA(munition, b2, p);
			}
		}
			//System.out.println(line);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		mc = new ModelClassique(factory, j1, ia);
		for(Bateau baazaaa : mc.getBateauIA()) {
			for(Point prout : baazaaa.getTouche()) {
			System.out.println(prout.toString());
			}
		}
		mc.save("testfinal");
		
		System.out.println("OKKKKKKK");
		
	}
}
