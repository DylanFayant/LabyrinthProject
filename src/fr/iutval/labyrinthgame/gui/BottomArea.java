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
import fr.iutval.labyrinthgame.Treasure;

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
	public int playerId;
	/**
	 * 
	 */
	public Tile freeCard;
	/**
	 * 
	 */
	public Treasure searchedTreasure;
	
	/**
	 * @param mainWindow 
	 * 
	 */
	public BottomArea(MainWindow mainWindow, int playerId, Tile freeCard, Treasure searchedTreasure) {
		this.mainWindow = mainWindow;
		this.tileRotation = 0;
		this.playerId = playerId;
		this.freeCard = freeCard;
		this.searchedTreasure = searchedTreasure;
		
		GridLayout experimentLayout = new GridLayout();
		
	    this.setLayout(experimentLayout);
	    
	    this.theTile = new JButton(new ImageIcon("img/"+freeCard+this.tileRotation+".png"));
	    this.theTile.addActionListener(this);
	    this.thePlayer = new JButton("Player " + playerId);
	    this.thePlayer.setPreferredSize(new Dimension(20, 0));
	    this.searchedCard = new JButton(new ImageIcon("img/"+this.searchedTreasure+".png"));

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
		    
		    this.theTile = new JButton(new ImageIcon("img/"+freeCard+this.tileRotation+".png"));
		    this.theTile.addActionListener(this);
		    this.thePlayer = new JButton("Player " + playerId);
		    this.thePlayer.setPreferredSize(new Dimension(20, 0));
		    this.searchedCard = new JButton(new ImageIcon("img/"+this.searchedTreasure+".png"));

		    this.add(this.theTile);
		    this.add(this.thePlayer);
		    this.add(this.searchedCard);
			SwingUtilities.updateComponentTreeUI(this);
		}
	}
	
	/**
	 * @param playerId
	 * @param freeCard
	 * @param searchedTreasure
	 */
	public void refreshBottomArea(int playerId, Tile freeCard, Treasure searchedTreasure) {
		this.removeAll();
		this.tileRotation = 0;
		this.playerId = playerId;
		this.freeCard = freeCard;
		this.searchedTreasure = searchedTreasure;
		
		GridLayout experimentLayout = new GridLayout();
		
	    this.setLayout(experimentLayout);
	    
	    this.theTile = new JButton(new ImageIcon("img/"+freeCard+this.tileRotation+".png"));
	    this.theTile.addActionListener(this);
	    this.thePlayer = new JButton("Player " + playerId);
	    this.thePlayer.setPreferredSize(new Dimension(20, 0));
	    this.searchedCard = new JButton(new ImageIcon("img/"+this.searchedTreasure+".png"));

	    this.add(this.theTile);
	    this.add(this.thePlayer);
	    this.add(this.searchedCard);

		SwingUtilities.updateComponentTreeUI(this);
	}
}
