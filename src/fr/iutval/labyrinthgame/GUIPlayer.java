package fr.iutval.labyrinthgame;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import fr.iutval.labyrinthgame.exceptions.XisNotInGameboardException;
import fr.iutval.labyrinthgame.exceptions.YisNotInGameboardException;
import fr.iutval.labyrinthgame.gui.BottomArea;
import fr.iutval.labyrinthgame.gui.TopArea;

/**
 * @author TODO
 *
 */
public class GUIPlayer extends JFrame implements PlayerOutput, PlayerInput {
	/**
	 * 
	 */
	public TopArea topArea;
	/**
	 * 
	 */
	public BottomArea bottomArea;
	/**
	 * Player Must enter an insertion
	 */
	public volatile boolean canInsert;
	
	/**
	 * 
	 */
	public volatile Insertion theInsertion;
	
	/**
	 * 
	 */
	public GUIPlayer() {
		this.canInsert = false;
		
		this.setTitle("Labyrinth Game");
		this.setResizable(true);
		this.setSize(540, 540);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
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

	@Override
	public void gameBoardUpdate(GameBoard gameBoard) {
		this.topArea.loadGameBoard(gameBoard);
	}

	@Override
	public void gameIsOver(int playerIds) {
		// TODO

	}

	@Override
	public void playerHasChanged(int playerId, Tile freeCard, Treasure searchedTreasure) {
		this.bottomArea.refreshBottomArea(playerId, freeCard, searchedTreasure);
	}

	@Override
	public Insertion askInsertion()
	{
		this.canInsert = true;
		this.theInsertion = null;
		this.bottomArea.theTile.setEnabled(true);
		this.bottomArea.validate();
		
		this.topArea.loadGameBoard(this.topArea.gameBoard);
		while(this.theInsertion == null)
		{
			// wait
		}

		this.canInsert = false;
		this.bottomArea.searchedCard.setEnabled(false);
		this.topArea.loadGameBoard(this.topArea.gameBoard);
		return this.theInsertion;
	}

	@Override
	public Movement askMove(Movement initialMove)
	{
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
