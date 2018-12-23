package dao;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modele.Case;
import modele.Humain;
import modele.IA;
import modele.Jeu;
import modele.Joueur;
import modele.ModelClassique;
import modele.Plateau;
import modele.bateau.Bateau;
import modele.factory.AntiquiteFactory;
import modele.factory.EpoqueFactory;
import modele.factory.ModernFactory;

/**
 * @author levy54u
 *
 */
public class JeuDAOCSV implements JeuDAO {
	private static final JeuDAOCSV instance = new JeuDAOCSV();

	@Override
	public void save(String name, ModelClassique jeu) {
		Joueur j = jeu.getj1();
		Case c = null;
		name += ".csv";
		try {
			String separator = "\n";
			String separatorArg = ",";
			FileWriter writer = new FileWriter(name);

			writer.append(jeu.getEpoque().toString());
			writer.append(separator);
			for (int a = 0; a < 2; a++) {
				writer.append("joueur");
				writer.append(separator);
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

					writer.append("listePosition");
					writer.append(separator);
					// position bateau
					if (b.getPosition().isEmpty()) {
						writer.append("null");
						writer.append(separator);
					} else {
						for (Point p : b.getPosition()) {
							// writer.append(p.toString());
							writer.append(new Integer(p.x).toString());
							writer.append(separatorArg);
							writer.append(new Integer(p.y).toString());
							writer.append(separator);

						}
					}
					// touche
					writer.append("touche");
					writer.append(separator);
					if (b.getTouche().isEmpty()) {
						writer.append("null");
						writer.append(separator);

					} else {
						for (Point p : b.getTouche()) {
							writer.append(new Integer(p.x).toString());
							writer.append(separatorArg);
							writer.append(new Integer(p.y).toString());
							// writer.append(p.toString());
							writer.append(separator);

						}
						writer.append(separator);

					}
				}
				// plateau
				writer.append("plateau");
				writer.append(separator);
				for (int i = 0; i < j.getPlateau().getPlateau().length; i++) {
					for (int k = 0; k < j.getPlateau().getPlateau()[0].length; k++) {
						c = j.getPlateau().getCase(i, k);
						writer.append(c.toString());
						writer.append(separator);
					}
					// writer.append(separator);
				}

				j = jeu.getIa();
			}

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Jeu load(String inputFileName) {

		String separatorArg = ",";
		BufferedReader br = null;
		String line = "";
		EpoqueFactory factory = null;
		Joueur j1 = null;
		Joueur ia = null;
		int munition = 0;
		ArrayList<Bateau> b1 = new ArrayList<>();
		ArrayList<Bateau> b2 = new ArrayList<>();
		ArrayList<Point> point = null;// new ArrayList<>();
		int id;
		int taille;
		Bateau b = null;
		String[] tabpoint = null;
		Case[][] cas = new Case[11][11];
		boolean boo = false, boo1 = false;
		Plateau p = null;
		try {

			br = new BufferedReader(new FileReader(inputFileName));
			line = br.readLine();
			// System.out.println(line);
			if (line.equals("AntiquiteFactory")) {
				factory = new AntiquiteFactory();
			} else {
				factory = new ModernFactory();
			}
			// System.out.println(line);
			line = br.readLine();
			// System.out.println(line);
			line = br.readLine();
			// System.out.println(line);
			for (int compteur = 0; compteur < 2; compteur++) {
				if (line.equals("humain")) {
					line = br.readLine();
					// System.out.println(line);
					munition = Integer.parseInt(line);
					line = br.readLine();
					// System.out.println(line);
					for (int ii = 0; ii < 5; ii++) {

						// line = br.readLine();
						id = Integer.parseInt(line);
						// System.out.println("id : "+id);
						line = br.readLine();
						// System.out.println(line);
						taille = Integer.parseInt(line);
						if (taille == 2) {
							b = factory.createBateau2(id);
							b1.add(b);
						} else if (taille == 3) {
							b = factory.createBateau3_1(id);
							b1.add(b);
						} else if (taille == 4) {
							b = factory.createBateau4(id);
							b1.add(b);
						} else if (taille == 5) {
							b = factory.createBateau5(id);
							b1.add(b);
						}

						line = br.readLine();
						// System.out.println(line);
						tabpoint = null;
						if (line.equals("listePosition")) {
							line = br.readLine();
							// System.out.println(line);
							if (!line.equals("null")) {

								while (!line.equals("touche")) {
									int x, y;
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
						// System.out.println(line);
						point = new ArrayList<>();
						if (line.equals("touche")) {
							line = br.readLine();
							// System.out.println(line);
							if (!line.equals("null")) {
								while (!line.equals("plateau")) {

									int x, y;
									tabpoint = line.split(separatorArg);
									x = Integer.parseInt(tabpoint[0]);
									y = Integer.parseInt(tabpoint[1]);
									b.touche(new Point(x, y));
									line = br.readLine();
								}
							}
							line = br.readLine();
							// System.out.println(line);

						}

					}
					int comptx = 0, compty = 0;
					line = br.readLine();
					// System.out.println(line);

					while ((!line.equals("joueur")) && ((line) != null)) {
						// System.out.println(line);
						tabpoint = line.split(separatorArg);
						// System.out.println(tabpoint[1]);
						if (tabpoint[1].equals("true")) {
							boo = true;
						} else {
							boo = false;
						}
						if (tabpoint[2].equals("true")) {
							boo1 = true;
						} else {
							boo1 = false;
						}
						cas[comptx][compty] = new Case(Integer.parseInt(tabpoint[0]), boo, boo1);
						compty++;
						if (compty > 10) {
							comptx++;
							compty = 0;

						}
						if (comptx > 10) {
							comptx = 0;
						}
						line = br.readLine();

					}
					p = new Plateau(cas);
					// p.afficherPlateau();

					line = br.readLine();
					// System.out.println(line);
					j1 = new Humain(munition, b1, p);
				} else if (line.equals("ia")) {
					cas = new Case[11][11];
					tabpoint = null;
					line = br.readLine();
					// System.out.println(line);
					munition = Integer.parseInt(line);
					line = br.readLine();
					// System.out.println(line);
					for (int ii = 0; ii < 5; ii++) {

						// line = br.readLine();
						id = Integer.parseInt(line);
						// System.out.println("id : "+id);
						line = br.readLine();
						System.out.println(line);
						taille = Integer.parseInt(line);
						if (taille == 2) {
							b = factory.createBateau2(id);
							b2.add(b);
						} else if (taille == 3) {
							b = factory.createBateau3_1(id);
							b2.add(b);
						} else if (taille == 4) {
							b = factory.createBateau4(id);
							b2.add(b);
						} else if (taille == 5) {
							b = factory.createBateau5(id);
							b2.add(b);
						}

						line = br.readLine();
						// System.out.println(line);

						point = new ArrayList<>();
						if (line.equals("listePosition")) {
							line = br.readLine();
							// System.out.println(line);
							if (!line.equals("null")) {

								while (!line.equals("touche")) {
									// System.out.println(line);
									int x, y;
									tabpoint = line.split(separatorArg);
									x = Integer.parseInt(tabpoint[0]);
									y = Integer.parseInt(tabpoint[1]);
									point.add(new Point(x, y));

									line = br.readLine();
									// System.out.println(line);
								}
								b.setPosition(point);
								// System.out.println(point);

							}
						}
						// line = br.readLine();
						// System.out.println(line);
						point = new ArrayList<>();
						if (line.equals("touche")) {
							line = br.readLine();
							// System.out.println(line);
							if (!line.equals("null")) {
								while (!line.equals("plateau")) {

									int x, y;
									tabpoint = line.split(separatorArg);
									x = Integer.parseInt(tabpoint[0]);
									y = Integer.parseInt(tabpoint[1]);
									b.touche(new Point(x, y));
									line = br.readLine();
								}
							}
							line = br.readLine();
							// System.out.println(line);
						}
					}
					int comptx = 0, compty = 0;
					line = br.readLine();
					// System.out.println(line);

					while (((line) != null) && (!line.equals("joueur"))) {
						// System.out.println(line);
						tabpoint = line.split(separatorArg);
						// System.out.println(tabpoint[1]);
						if (tabpoint[1].equals("true")) {
							boo = true;
						} else {
							boo = false;
						}
						if (tabpoint[2].equals("true")) {
							boo1 = true;
						} else {
							boo1 = false;
						}
						cas[comptx][compty] = new Case(Integer.parseInt(tabpoint[0]), boo, boo1);
						compty++;
						if (compty > 10) {
							comptx++;
							compty = 0;
						}
						if (comptx > 10) {
							comptx = 0;
						}
						line = br.readLine();
					}
					p = new Plateau(cas);
					// p.afficherPlateau();
					ia = new IA(munition, b2, p);
				}
			}
			// System.out.println(line);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelClassique(factory, j1, ia);

	}

	public static JeuDAO getInstance() {

		return instance;
	}

}
