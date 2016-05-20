package fr.iutval.labyrinthgame;
import fr.iutval.labyrinthgame.exceptions.*;
import fr.iutval.labyrinthgame.gameIO.PlayerInput;
import fr.iutval.labyrinthgame.gameIO.PlayerOutput;

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
	 * the players inputs
	 */
	private final PlayerInput[] playerInput;
	
	/**
	 * the players outputs
	 */
	private PlayerOutput[] playerOutput;

	/**
	 * creates a new labyrinth game ready to be played (gameboard contains randomly placed mobile tiles and 4 pawns 
	 * linked to players in the gameboard's corners. Treasure cards have been distributed to players).
	 * @param playerInput PlayerInput
	 * @param playerOutput PlayerOutput
	 */
	public LabyrinthGame(PlayerInput[] playerInput, PlayerOutput[] playerOutput)
	{
		/* Set the player and their i/o */
		this.players = new Player[LabyrinthGame.DEFAULT_PLAYERS_COUNT];
		this.playerInput = playerInput;
		this.playerOutput = playerOutput;
	
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
		
		while(!gameIsOver)
		{
			currentPlayer = this.players[playerPointer];
			
			/* Show that the player has changed for every player */
			for(int playerNum = 0; playerNum < this.playerOutput.length; playerNum++)
				this.playerOutput[playerNum].playerHasChanged(currentPlayer.getId(), this.gameboard.getFreeTile(), currentPlayer.getCurrentTreasure());
			
			/* Show that the gameboard update for every player */
			for(int playerNum = 0; playerNum < this.playerOutput.length; playerNum++)
				this.playerOutput[playerNum].gameBoardUpdate(this.gameboard);
			
			Insertion newInsertion = null;
			while(true)
			{
				newInsertion = this.playerInput[playerPointer].askInsertion();
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

			/* Show that the gameboard update for every player */
			for(int playerNum = 0; playerNum < this.playerOutput.length; playerNum++)
				this.playerOutput[playerNum].gameBoardUpdate(this.gameboard);
			
			while(true)
			{
				Movement newMove = new Movement(this.gameboard.pawns.get(currentPlayer.getId()));
				Movement theMove = this.playerInput[playerPointer].askMove(newMove);
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

			/* Show that the gameboard update for every player */
			for(int playerNum = 0; playerNum < this.playerOutput.length; playerNum++)
				this.playerOutput[playerNum].gameBoardUpdate(this.gameboard);
			
			/* Check if the game is over or get the next treasure */
			if(this.gameboard.treasureInPlayerTile(currentPlayer.getId()) == currentPlayer.getCurrentTreasure())
			{
				try {
					currentPlayer.nextTreasure();
				} catch (StackIsEmptyException e) {
					gameIsOver = true;
				}
			}
			
			/* Change of player */
			playerPointer = (playerPointer+1)%LabyrinthGame.DEFAULT_PLAYERS_COUNT;
		}
		
		/* Show that the game is over for every player */
		for(int playerNum = 0; playerNum < this.playerOutput.length; playerNum++)
			this.playerOutput[playerNum].gameIsOver(currentPlayer.getId());
	}
}
