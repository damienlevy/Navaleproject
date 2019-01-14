package vues;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Controleur;

public class VuePlacement extends JPanel implements GameVue{
	private final static int w = 400;
	private final static int h = 400;
	public final static int CaseX = 37;
	public final static int CaseY =37 ;
	public static Image back;
	private BufferedImage para;
	private BufferedImage bateau;
	private JButton start;
	JFrame Game;
	private Controleur controleur;


	public VuePlacement(Controleur c)
	{
		controleur = c;
		try {
			back = ImageIO.read(getClass().getResourceAsStream("images/back.jpg"));
			para = ImageIO.read(getClass().getResourceAsStream("images/para.jpg"));
			bateau = ImageIO.read(getClass().getResourceAsStream("images/bateau.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.display();
	}

	@Override
	public void display() {      
		Game=new JFrame();
		Game.setTitle("Bataille navale");
		Game.setLocationRelativeTo(null);
		Game.setSize(500,500);     
		Game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		start = new JButton("START");
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controleur.start();
				Game.dispose();
			}
		});
		this.add(start, JPanel.BOTTOM_ALIGNMENT);
		Game.add(this);
		Game.setVisible(true);
	}

	@Override
	public void update() {

	}

	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		Font font = new Font( "Rockwell Extra Bold", Font.PLAIN, 20 );
		for( int i=0 ; i <= (w/CaseX); i++ )
		{

			for(int j = 0 ; j <=h/CaseY ; j++)
			{
				g.drawRect(i*CaseX,j*CaseY,CaseX,CaseY); 
				g.drawImage(back,i*CaseX,j*CaseY,CaseX-1,CaseY-1,this); 
				if(i==0 && j==0)
				{
					g.drawRect(i*CaseX,j*CaseY,CaseX,CaseY); 
					g.drawImage(bateau,i*CaseX,j*CaseY,CaseX-1,CaseY-1,this); 
				}
				if(i==0 && j>= 1)
				{
					g.drawRect(i*CaseX,j*CaseY,CaseX,CaseY); 
					g.drawImage(para,i*CaseX,j*CaseY,CaseX-1,CaseY-1,this); 

					g.setFont(font );
					String c = Character.toString((char)(65 + ((j-1)/26)*6 + (j-1)));
					g.drawString(c,i*CaseX+10,j*CaseY+20);
				}
				if(j==0 && i>= 1)
				{
					g.drawRect(i*CaseX,j*CaseY,CaseX,CaseY); 
					g.drawImage(para,i*CaseX,j*CaseY,CaseX-1,CaseY-1,this); 
					g.setFont(font );
					g.drawString(String.valueOf(i),i*CaseX+10,j*CaseY+20);
				}
			}
		}
	}
}