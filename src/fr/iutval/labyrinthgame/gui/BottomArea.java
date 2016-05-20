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
import fr.iutval.labyrinthgame.gameIO.GUIPlayer;

/**
 * Represents the bottom area (player informations)
 * @author Rachid Taghat - Dylan Fayant
 */
@SuppressWarnings("serial")
public class BottomArea extends JPanel implements ActionListener{
	/**
	 * Button representing the free tile
	 */
	public JButton freeTileButton;
	/**
	 * Save the reference to the main window
	 */
	public GUIPlayer mainWindow;
	/**
	 * The tile rotation
	 */
	public int tileRotation;
	/**
	 * Current player id
	 */
	public JButton currentPlayerIdButton;
	/**
	 * The searched card
	 */
	public JButton searchedCardButton;
	/**
	 * The free card tile
	 */
	public Tile freeCard;
	/**
	 * The searched treasure
	 */
	public Treasure searchedTreasure;
	/**
	 * Current player id
	 */
	public int playerId;
	
	/**
	 * Generates the bottom area
	 * @param mainWindow 
	 * @param playerId 
	 * @param freeCard 
	 * @param searchedTreasure 
	 */
	public BottomArea(GUIPlayer mainWindow, int playerId, Tile freeCard, Treasure searchedTreasure) {
		/*
		 * Save the informations
		 */
		this.mainWindow = mainWindow;
		this.tileRotation = 0;
		this.freeCard = freeCard;
		this.searchedTreasure = searchedTreasure;
		this.playerId = playerId;
		
		GridLayout experimentLayout = new GridLayout();
	    this.setLayout(experimentLayout);
	    
	    this.freeTileButton = new JButton(new ImageIcon("img/"+this.freeCard+this.tileRotation+".png"));
	    this.freeTileButton.addActionListener(this);
	    this.currentPlayerIdButton = new JButton("Player " + this.playerId);
	    this.currentPlayerIdButton.setPreferredSize(new Dimension(20, 0));
	    this.searchedCardButton = new JButton(new ImageIcon("img/"+this.searchedTreasure+".png"));
	    
	    /*
	     * By default the rotation of the free tile isn't available
	     */
	    this.freeTileButton.setEnabled(false);
	    
	    this.add(this.freeTileButton);
	    this.add(this.currentPlayerIdButton);
	    this.add(this.searchedCardButton);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComponent source = (JComponent)arg0.getSource();
		if(source == this.freeTileButton)
		{
			this.tileRotation = (this.tileRotation+90)%360;
			
			this.removeAll();
		    
		    this.freeTileButton = new JButton(new ImageIcon("img/"+this.freeCard+this.tileRotation+".png"));
		    this.freeTileButton.addActionListener(this);
		    this.currentPlayerIdButton = new JButton("Player " + this.playerId);
		    this.currentPlayerIdButton.setPreferredSize(new Dimension(20, 0));
		    this.searchedCardButton = new JButton(new ImageIcon("img/"+this.searchedTreasure+".png"));
		    
		    this.add(this.freeTileButton);
		    this.add(this.currentPlayerIdButton);
		    this.add(this.searchedCardButton);
		    
			SwingUtilities.updateComponentTreeUI(this);
		}
	}
	
	/**
	 * @param playerId
	 * @param freeCard
	 * @param searchedTreasure
	 */
	public void refreshBottomArea(int playerId, Tile freeCard, Treasure searchedTreasure) {
		this.freeCard = freeCard;
		this.searchedTreasure = searchedTreasure;
		this.playerId = playerId;
		
		/* By default the free tile button is not enabled */
		this.freeTileButton.setEnabled(false);
		
		this.removeAll();
	    
	    this.freeTileButton = new JButton(new ImageIcon("img/"+this.freeCard+this.tileRotation+".png"));
	    this.freeTileButton.addActionListener(this);
	    this.currentPlayerIdButton = new JButton("Player " + this.playerId);
	    this.searchedCardButton = new JButton(new ImageIcon("img/"+this.searchedTreasure+".png"));

	    this.freeTileButton.setEnabled(false);

	    this.add(this.freeTileButton);
	    this.add(this.currentPlayerIdButton);
	    this.add(this.searchedCardButton);

		SwingUtilities.updateComponentTreeUI(this);
	}
}
