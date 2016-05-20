package fr.iutval.labyrinthgame.gui;

import java.awt.Graphics;
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
 * @author TODO
 *
 */
public class PanelImage extends JPanel {

	private BufferedImage image = null;
	
	/**
	 * @param path
	 */
	public PanelImage(String path){
		try {
			this.image = ImageIO.read(new File(path));
			
			Image anotherImage = this.image.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
			
			this.image = new BufferedImage(anotherImage.getWidth(null), anotherImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		    // Draw the image on to the buffered image
			Graphics2D bGr = this.image.createGraphics();
		    bGr.drawImage(anotherImage, 0, 0, null);
		    bGr.dispose();
		    
			this.add(new JLabel(new ImageIcon(this.image)));
		}
		catch (IOException e) {
				//e.printStackTrace();
		}
	}
	
	/**
	 * @param path 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(String path) {
		if(this.image != null)
		{
			BufferedImage otherImage = null;
			try {
				otherImage = ImageIO.read(new File(path));
			}
			catch (IOException e) {
					e.printStackTrace();
			}
			
			Image anotherImage = otherImage.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
			
			otherImage = new BufferedImage(anotherImage.getWidth(null), anotherImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		    // Draw the image on to the buffered image
		    Graphics2D bGr = otherImage.createGraphics();
		    bGr.drawImage(anotherImage, 0, 0, null);
		    bGr.dispose();
			
			anotherImage = this.image.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
			
			this.image = new BufferedImage(anotherImage.getWidth(null), anotherImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		    // Draw the image on to the buffered image
		    bGr = this.image.createGraphics();
		    bGr.drawImage(anotherImage, 0, 0, null);
		    bGr.dispose();
		    
			Graphics2D g2d = this.image.createGraphics(); 
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			                RenderingHints.VALUE_ANTIALIAS_ON); 
			g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, 
			                RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY); 
		  
			g2d.drawImage(otherImage, 20, 10, null); 
		  
			g2d.dispose(); 
		  
			this.removeAll();
			this.add(new JLabel(new ImageIcon(this.image)));
			this.repaint();
		}
	}

}