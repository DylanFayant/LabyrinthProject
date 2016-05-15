package fr.iutval.labyrinthgame.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import fr.iutval.labyrinthgame.Tile;

/**
 * @author TODO
 *
 */
public class BottomArea extends JPanel implements ActionListener{
	/**
	 * 
	 */
	public JButton theTile;
	/**
	 * 
	 */
	public MainWindow mainWindow;
	/**
	 * 
	 */
	public int tileRotation;
	/**
	 * 
	 */
	public JButton thePlayer;
	/**
	 * 
	 */
	public JButton searchedCard;
	
	/**
	 * @param mainWindow 
	 * 
	 */
	public BottomArea(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.tileRotation = 0;
		
		GridLayout experimentLayout = new GridLayout();
		
	    this.setLayout(experimentLayout);
	    
	    this.theTile = new JButton(new ImageIcon("img/"+Tile.TILE1+this.tileRotation+".png"));
	    this.theTile.addActionListener(this);
	    this.thePlayer = new JButton("Player 1");
	    this.thePlayer.setPreferredSize(new Dimension(20, 0));
	    this.searchedCard = new JButton(new ImageIcon("img/"+Tile.TILE1+"0.png"));

	    this.add(this.theTile);
	    this.add(this.thePlayer);
	    this.add(this.searchedCard);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent)arg0.getSource();
		
		if(source == this.theTile)
		{
			this.tileRotation = (this.tileRotation+90)%360;
			this.removeAll();
			this.theTile = new JButton(new ImageIcon("img/"+Tile.TILE1+this.tileRotation+".png"));
		    this.theTile.addActionListener(this);
		    JButton btn2 = new JButton("Player 1");
		    btn2.setPreferredSize(new Dimension(20, 0));
		    JButton btn3 = new JButton(new ImageIcon("img/"+Tile.TILE1+"0.png"));

		    this.add(this.theTile);
		    this.add(btn2);
		    this.add(btn3);
		    
			SwingUtilities.updateComponentTreeUI(this);
		}
		
	}
}
