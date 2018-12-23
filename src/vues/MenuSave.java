
package vues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controleur.Controleur;

/**
 * @author levy54u
 *
 */
public class MenuSave extends JMenuBar {

	public MenuSave(final Controleur c) {
		super();

		JMenu file;
		JMenuItem save;
		

		file = new JMenu("File");
		save = new JMenuItem("Save");
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.save();
				
			}
		});
	
		file.add(save);
		
		this.add(file);

	}

}
