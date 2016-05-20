package fr.iutval.labyrinthgame.gui;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.iutval.labyrinthgame.GameBoard;
import fr.iutval.labyrinthgame.PositionInTheGameBoard;
import fr.iutval.labyrinthgame.exceptions.XisNotInGameboardException;
import fr.iutval.labyrinthgame.exceptions.YisNotInGameboardException;
import fr.iutval.labyrinthgame.gameIO.GUIPlayer;

/**
 * Represents the top area of the window (the gameboard)
 * @author Rachid Taghat - Dylan Fayant
 */
@SuppressWarnings("serial")
public class TopArea extends JPanel {
	/**
	 * The reference to the main window
	 */
	public GUIPlayer mainWindow;
	/**
	 * The gameboard
	 */
	public GameBoard gameBoard;

	/**
	 * Generates the top area
	 * @param mainWindow
	 */
	public TopArea(GUIPlayer mainWindow) {
		// save the reference of the main window
		this.mainWindow = mainWindow;
		
		GridLayout layout = new GridLayout(GameBoard.WIDTH+2, GameBoard.HEIGHT+2);
		this.setLayout(layout);
		
		this.setVisible(true);
	}
	
	/**
	 * Load the gameboard (show the tiles, and the buttons for making insertion)
	 * @param gameBoard
	 */
	public void loadGameBoard(GameBoard gameBoard) { 
		this.gameBoard = gameBoard;
		
		this.removeAll();
		
		GridLayout layout = new GridLayout(GameBoard.WIDTH+2, GameBoard.HEIGHT+2);
		this.setLayout(layout);
		
		// course the showed area (The gameboard + the buttons)
		for(int i = 0; i < GameBoard.HEIGHT+2; i++)
		{
			for(int j = 0; j < GameBoard.WIDTH+2; j++)
			{				
				InsertionButton button = null;
				
				/* If we are in a border of the array we set the empty panel or the button*/
				if(i == 0)
				{
					if(j%2 != 0)
						this.add(new JPanel());
					else
					{
						button = new InsertionButton("\\/", j-1, i, this.mainWindow);
						this.add(button);
					}
				}
				else if(i == GameBoard.HEIGHT+1)
				{
					if(j%2 != 0)
						this.add(new JPanel());
					else
					{
						button = new InsertionButton("/\\", j-1, i-2, this.mainWindow);
						this.add(button);
					}					
				}
				else if(j == 0)
				{
					if(i%2 != 0)
						this.add(new JPanel());
					else
					{
						button = new InsertionButton(">", j, i-1, this.mainWindow);
						this.add(button);
					}
				}
				else if(j == GameBoard.WIDTH+1)
				{
					if(i%2 != 0)
						this.add(new JPanel());
					else
					{
						button = new InsertionButton("<", j-2, i-1, this.mainWindow);
						this.add(button);
					}
				}
				else if((j == 0 || j == GameBoard.WIDTH+1) && (i == 0 || i == GameBoard.HEIGHT+1))
				{
					// corner space
					this.add(new JPanel());
				}
				/* Else if we are in the array (the plate) */
				else
				{
					// Creates the panel with the image
					PanelImage panel = new PanelImage("img/"+(gameBoard.getGameBoard()[j-1][i-1]).getLink()+".png");
					
					// Create a position with the current coordinates
					PositionInTheGameBoard currentPosition = null;
					try {
						currentPosition = new PositionInTheGameBoard(j-1, i-1);
					} catch (XisNotInGameboardException | YisNotInGameboardException e) {
						// impossible
					}
					
					// Check if a pawn is in this coordinates + place the pawn
					if(gameBoard.getPawns().containsValue(currentPosition))
					{
						if(gameBoard.getPawns().get(0).equals(currentPosition))
							panel.paintComponent("img/player0.png");
						if(gameBoard.getPawns().get(1).equals(currentPosition))
							panel.paintComponent("img/player1.png");
						if(gameBoard.getPawns().get(2).equals(currentPosition))
							panel.paintComponent("img/player2.png");
						if(gameBoard.getPawns().get(3).equals(currentPosition))
							panel.paintComponent("img/player3.png");
					}
					
					this.add(panel);
				}
			}
		}
		SwingUtilities.updateComponentTreeUI(this.getParent());
	}

}
