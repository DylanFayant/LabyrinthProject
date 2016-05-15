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
	 * 
	 */
	private int playerId;
	/**
	 * 
	 */
	private Tile freeCard;
	
	/**
	 * @param mainWindow 
	 * 
	 */
	public BottomArea(MainWindow mainWindow, int rotation, int playerId, Tile freeCard) {
		this.mainWindow = mainWindow;
		this.tileRotation = rotation;
		this.playerId = playerId;
		this.freeCard = freeCard;
		
		GridLayout experimentLayout = new GridLayout();
		
	    this.setLayout(experimentLayout);
	    
	    this.theTile = new JButton(new ImageIcon("img/"+freeCard+this.tileRotation+".png"));
	    this.theTile.addActionListener(this);
	    this.theTile.setEnabled(false);
	    this.thePlayer = new JButton("Player " + playerId);
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
			this.mainWindow.bottomArea = new BottomArea(this.mainWindow, this.tileRotation, this.playerId, this.freeCard);
			SwingUtilities.updateComponentTreeUI(this.mainWindow);
		}
		
	}
}
