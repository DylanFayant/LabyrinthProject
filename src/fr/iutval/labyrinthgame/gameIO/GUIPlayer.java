package fr.iutval.labyrinthgame.gameIO;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import fr.iutval.labyrinthgame.Direction;
import fr.iutval.labyrinthgame.GameBoard;
import fr.iutval.labyrinthgame.Insertion;
import fr.iutval.labyrinthgame.Movement;
import fr.iutval.labyrinthgame.Tile;
import fr.iutval.labyrinthgame.Treasure;
import fr.iutval.labyrinthgame.exceptions.XisNotInGameboardException;
import fr.iutval.labyrinthgame.exceptions.YisNotInGameboardException;
import fr.iutval.labyrinthgame.gui.BottomArea;
import fr.iutval.labyrinthgame.gui.TopArea;

/**
 * Represents the Input/Output of the GUI + the Frame of the window
 * @author Rachid Taghat - Dylan Fayant
 */
@SuppressWarnings("serial")
public class GUIPlayer extends JFrame implements PlayerOutput, PlayerInput {
	/**
	 * The top area (the gameboard)
	 */
	public TopArea topArea;
	/**
	 * The bottom area (the player information part)
	 */
	public BottomArea bottomArea;
	/**
	 * Player can select an insertion
	 */
	public volatile boolean canInsert;
	/**
	 * The insertion selected by the player
	 */
	public volatile Insertion theInsertion;
	
	/**
	 * Generates the player's GUI
	 */
	public GUIPlayer() {
		/*
		 * Initialization of the frame
		 */
		this.setTitle("Labyrinth Game");
		this.setResizable(true);
		this.setSize(540, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		/* The player can't insert in the initialization */
		this.canInsert = false;
		
		/* Set the areas */
		this.topArea = new TopArea(this);
		this.bottomArea = new BottomArea(this, -1, Tile.TILE1, Treasure.BAT);
		
		/*
		 * Split the page
		 */
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, this.topArea, this.bottomArea);
		splitPane.setOneTouchExpandable(true);
		
		/*
		 * Set divider location to 500px
		 */
		splitPane.setDividerLocation(400);
		
		/*
		 * Disable divider control
		 */
		splitPane.setEnabled(false);
		
		/*
		 * Set divider size to 1 px
		 */
		splitPane.setDividerSize(1);
		
		/*
		 * Add splitpane to basic Pane
		 */
		this.getContentPane().add(splitPane);
		
		/*
		 * Set the result visible
		 */
		this.setVisible(true);
	}

	/**
	 * @see fr.iutval.labyrinthgame.gameIO.PlayerOutput#gameBoardUpdate(fr.iutval.labyrinthgame.GameBoard)
	 */
	public void gameBoardUpdate(GameBoard gameBoard) {
		this.topArea.loadGameBoard(gameBoard);
	}

	/**
	 * @see fr.iutval.labyrinthgame.gameIO.PlayerOutput#gameIsOver(int)
	 */
	public void gameIsOver(int playerIds) {
		// TODO

	}

	/**
	 * @see fr.iutval.labyrinthgame.gameIO.PlayerOutput#playerHasChanged(int, fr.iutval.labyrinthgame.Tile, fr.iutval.labyrinthgame.Treasure)
	 */
	public void playerHasChanged(int playerId, Tile freeCard, Treasure searchedTreasure) {
		this.bottomArea.refreshBottomArea(playerId, freeCard, searchedTreasure);
	}

	/**
	 * @see fr.iutval.labyrinthgame.gameIO.PlayerInput#askInsertion()
	 */
	public Insertion askInsertion()
	{
		/* The player can insert */
		this.canInsert = true;
		/* Init the insertion */
		this.theInsertion = null;
		/* Allows the rotation of the free tile */
		this.bottomArea.freeTileButton.setEnabled(true);
		this.bottomArea.validate();
		/* Refresh the gameboard */
		this.topArea.loadGameBoard(this.topArea.gameBoard);
		while(this.theInsertion == null)
		{
			// wait
		}
		/* The user can't insert */
		this.canInsert = false;
		this.bottomArea.refreshBottomArea(this.bottomArea.playerId, this.bottomArea.freeCard, this.bottomArea.searchedTreasure);
		/* Refresh the gameboard */
		this.topArea.loadGameBoard(this.topArea.gameBoard);
		
		return this.theInsertion;
	}

	/**
	 * @see fr.iutval.labyrinthgame.gameIO.PlayerInput#askMove(fr.iutval.labyrinthgame.Movement)
	 */
	public Movement askMove(Movement initialMove)
	{
		// TODO : For now random move...
		Direction[] directions = Direction.values();
		int random = new Random().nextInt(4);
		while(initialMove.getMovement().size() < random)
		{
			while(true)
			{
				try {
					initialMove.nextMove(directions[new Random().nextInt(directions.length)]);
					break;
				} catch (XisNotInGameboardException e) {
					// make a loop
				} catch (YisNotInGameboardException e) {
					// make a loop
				}
			}
		}
		return initialMove;
	}
}
