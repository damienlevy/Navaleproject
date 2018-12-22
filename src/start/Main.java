
package start;


import modele.Jeu;
import modele.ModelClassique;
import modele.factory.AntiquiteFactory;
import modele.factory.ModernFactory;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.Controleur;
import controleur.ControleurJeuxClassique;
import dao.DAOFactory;
import dao.DAOFactoryCSV;
import dao.JeuDAOCSV;
import vues.VueComplete;
import vues.VuePerso;
import vues.VuePlacement;

/**
 *
 * @author trabels33u
 */
public class Main { 

	private static JFileChooser jFC;

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String[] choix = { "Antiquite", "Moderne","Load"};
	    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    String nom = (String)jop.showInputDialog(null, 
	      "Veuillez indiquer le mode de lancement",
	      "NavaleProject",
	      JOptionPane.QUESTION_MESSAGE,
	      null,
	      choix,
	      choix[0]);
	    
	    Jeu model;
	    switch (nom) {
			case "Antiquite" :
				model = new ModelClassique(new AntiquiteFactory());
				break;
			case "Moderne" :
				model = new ModelClassique(new ModernFactory());
				break;
			case "Load":
				DAOFactoryCSV dao =(DAOFactoryCSV) DAOFactory.getInstance(0);
				model =  dao.getJEUDAO().load(fileChooser());
				break;
			default:
				model = new ModelClassique(new ModernFactory());
				break;
		}
		
		
		Controleur c  = new ControleurJeuxClassique(model);
		VueComplete vc = new VueComplete(c);
		VuePlacement vp = new VuePlacement(c);
		model.addVue(vc);
		model.addVue(vp);
		c.addVue(vc);
	}
	
	public static String fileChooser() {
		JFileChooser dialogue = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Fichiers csv", "csv");
		dialogue.addChoosableFileFilter(filter);
		dialogue.setAcceptAllFileFilterUsed(false);
		dialogue.showOpenDialog(null);
		jFC = dialogue;
		return dialogue.getSelectedFile().getPath(); 
	}

	public static String fileSaverChooser(){
		jFC.showSaveDialog(null);
		return jFC.getSelectedFile().getPath();		
	}

}
