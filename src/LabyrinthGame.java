import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import Exceptions.*;

/**
 * This class represents a Labyrinth game.
 * http://jesweb.net/old/critique/labyrinthe/labyrinthe.html 
 * @author Rachid Taghat - Dylan Fayant
 */
public class LabyrinthGame {
	
	/**
	 * The players count
	 */
	private final static int DEFAULT_PLAYERS_COUNT = 4;
	
	/**
	 * the gameboard (plate + pawns + tiles)
	 */
	private GameBoard gameboard;

	/**
	 * the players.
	 */
	private final Player[] players;

	/**
	 * creates a new labyrinth game ready to be played (gameboard contains randomly placed mobile tiles and 4 pawns 
	 * linked to players in the gameboard's corners. Treasure cards have been distributed to players).
	 */
	public LabyrinthGame()
	{		
		this.players = new Player[LabyrinthGame.DEFAULT_PLAYERS_COUNT];
	
		/*
		 * Players' treasure stack generation.
		 */
		TreasureStack allTreasures = new TreasureStack(Treasure.values());
		allTreasures.shuffle();
		
		for(int i = 0; i < LabyrinthGame.DEFAULT_PLAYERS_COUNT; i++)
		{
			TreasureStack playerTreasureStack = new TreasureStack();
			
			for(int j = 0; j < TreasureStack.DEFAULT_PLAYER_STACK_SIZE; j++)
			{
				try {
					playerTreasureStack.setTreasure(allTreasures.pickTreasure());
				} catch (StackIsFullException e) {
					// never gone
				} catch (StackIsEmptyException e) {
					// never gone
				}
			}
			this.players[i] = new Player(playerTreasureStack);
		}
		
		// Make an array of all the players id's
		int[] playersId = new int[LabyrinthGame.DEFAULT_PLAYERS_COUNT];
		for(int i = 0; i < playersId.length; i++)
		{
			playersId[i] = this.players[i].getId();
		}
		// Generates the gameboard (with players id to link them to they pawns)
		this.gameboard = new GameBoard(playersId); 
	}
	
	/**
	 * Plays the game 
	 * 
	 * current player is player 1
	 * while (<game is not over>)
	 *    do
	 *      <ask current player for insertion>
	 *    while (<insertion is not valid>)
	 *    <perform action>
	 *	  do
	 *      <ask current player for move>
	 *    while (<move is not valid>)
	 *    <perform move>
	 *    if (<player is on a tile containing the treasure he is looking for>)
	 *    	<delete the treasure card from player stack>
	 *    if(<player stack is empty>)
	 *    	<game is over>
	 *    current player changes
	 * 
	 */
	public void play()
	{
		// Initialization
		Player currentPlayer = null;
		boolean gameIsOver = false;
		int playerPointer = 0;
		
		// Save the game logs
		File logFile = new File("log.txt");
		if(logFile.exists())
			logFile.delete();
		try {
			logFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		FileOutputStream logs = null;
		try {
			logs = new FileOutputStream(logFile, true);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		PrintStream logsStream = new PrintStream(logs);
		
		
		while(!gameIsOver)
		{
			currentPlayer = this.players[playerPointer];
			
			playerPointer = (playerPointer+1)%LabyrinthGame.DEFAULT_PLAYERS_COUNT;
			
			Insertion newInsertion = null;
			while(true)
			{
				newInsertion = currentPlayer.askInsertion();
				try
				{
					this.gameboard.processInsertion(newInsertion);
					break;
				}
				catch(InvalidInsertionException e)
				{
					// make the loop
				}
			}
			
			while(true)
			{
				Movement newMove = new Movement(this.gameboard.pawns.get(currentPlayer.getId()));
				Movement theMove = currentPlayer.askMove(newMove);
				try
				{
					this.gameboard.processMoving(theMove, currentPlayer.getId());
					break;
				}
				catch(InvalidMoveException e)
				{
					// make the loop
				}
			}
			
			if(this.gameboard.treasureInPlayerTile(currentPlayer.getId()) == currentPlayer.getCurrentTreasure())
			{
				try {
					currentPlayer.nextTreasure();
				} catch (StackIsEmptyException e) {
					gameIsOver = true;
				}
			}
			
			logsStream.print(this.gameboard.toString() + "\n");
		}

		System.out.println("Game is over !");
		System.out.println("Winner: " + currentPlayer.toString());
	}
}
