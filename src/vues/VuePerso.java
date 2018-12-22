package vues;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author TRABELSI
 */
public class VuePerso extends JPanel implements GameVue {
	public static Image back;
	private final static int w = 400;
	private final static int h = 400;
	public final static int CaseX = 37;
	public final static int CaseY = 37;
	public JPanel perso;
	private BufferedImage para;
	private BufferedImage bateau;

	public VuePerso() {
		this.display();
	}

	@Override
	public void display() {
		perso = new JPanel();
		perso.setPreferredSize(new Dimension(w, h));
		// adversaire.setSize(w,h);
	}

	@Override
	public void update() {

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			back = ImageIO.read(new File("./src/vues/images/back.jpg"));
			para = ImageIO.read(new File("./src/vues/images/para.jpg"));
			bateau = ImageIO.read(new File("./src/vues/images/bateau.png"));
			Font font = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
			for (int i = 0; i <= (w / CaseX); i++) {

				for (int j = 0; j <= h / CaseY; j++) {
					g.drawRect(i * CaseX, j * CaseY, CaseX, CaseY);
					g.drawImage(back, i * CaseX, j * CaseY, CaseX - 1, CaseY - 1, this);
					if (i == 0 && j == 0) {
						g.drawRect(i * CaseX, j * CaseY, CaseX, CaseY);
						g.drawImage(bateau, i * CaseX, j * CaseY, CaseX - 1, CaseY - 1, this);
					}
					if (i == 0 && j >= 1) {
						g.drawRect(i * CaseX, j * CaseY, CaseX, CaseY);
						g.drawImage(para, i * CaseX, j * CaseY, CaseX - 1, CaseY - 1, this);

						g.setFont(font);
						String c = Character.toString((char) (65 + ((j - 1) / 26) * 6 + (j - 1)));
						g.drawString(c, i * CaseX + 10, j * CaseY + 20);
					}
					if (j == 0 && i >= 1) {
						g.drawRect(i * CaseX, j * CaseY, CaseX, CaseY);
						g.drawImage(para, i * CaseX, j * CaseY, CaseX - 1, CaseY - 1, this);
						g.setFont(font);
						g.drawString(String.valueOf(i), i * CaseX + 10, j * CaseY + 20);
					}
				}
			}

		} catch (IOException ex) {
			Logger.getLogger(VuePerso.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
