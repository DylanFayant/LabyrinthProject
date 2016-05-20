package fr.iutval.labyrinthgame.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents the JPanel used to show the tiles pictures + sometimes the player pawn on the tile
 * @author Rachid Taghat - Dylan Fayant
 *
 */
@SuppressWarnings("serial")
public class PanelImage extends JPanel {
	/**
	 * The tile in background
	 */
	private BufferedImage image = null;
	
	/**
	 * Generates the jpanel with the background image
	 * @param path
	 */
	public PanelImage(String path){
		try {
			this.image = ImageIO.read(new File(path));
			
			/*
			 * Resizes the image
			 */
			Image imageResized = this.image.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
			
			this.image = new BufferedImage(imageResized.getWidth(null), imageResized.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics2D bGr = this.image.createGraphics();
		    bGr.drawImage(imageResized, 0, 0, null);
		    bGr.dispose();
		    
			this.add(new JLabel(new ImageIcon(this.image)));
		}
		catch (IOException e) {
				e.printStackTrace();
		}
	}
	
	/**
	 * Paint the pawn in the jpanel
	 * @param path 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(String path) {
		if(this.image != null)
		{
			BufferedImage pawnImage = null;
			try {
				pawnImage = ImageIO.read(new File(path));
			}
			catch (IOException e) {
					e.printStackTrace();
			}
			
			/*
			 * Resizes the pawn image
			 */
			Image resizedImage = pawnImage.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
			
			pawnImage = new BufferedImage(resizedImage.getWidth(null), resizedImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		    Graphics2D bGr = pawnImage.createGraphics();
		    bGr.drawImage(resizedImage, 0, 0, null);
		    bGr.dispose();

		    /* Make the fusion of the two images */
			Graphics2D g2d = this.image.createGraphics(); 
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			                RenderingHints.VALUE_ANTIALIAS_ON); 
			g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, 
			                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY); 
			g2d.drawImage(pawnImage, 20, 10, null);
			g2d.dispose(); 
		  
			this.removeAll();
			this.add(new JLabel(new ImageIcon(this.image)));
			this.repaint();
		}
	}
}