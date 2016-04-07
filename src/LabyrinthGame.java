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
	 * the current player
	 */
	private Player currentPlayer;
	
	/** 
	 * Is the game over ?.
	 */
	private boolean gameIsOver;

	/**
	 * creates a new labyrinth game ready to be played (gameboard contains randomly placed mobile tiles and 4 pawns 
	 * linked to players in the gameboard's corners. Treasure cards have been distributed to players).
	 */
	public LabyrinthGame() {		
		
		this.players = new Player[LabyrinthGame.DEFAULT_PLAYERS_COUNT];
		
		this.gameboard = new GameBoard(); 
	
		/*
		 * Players' treasure stack generation.
		 */
		TreasureStack allTreasures = new TreasureStack(Treasure.values());
		allTreasures.shuffle();
		TreasureStack treasureStacks[] = new TreasureStack[LabyrinthGame.DEFAULT_PLAYERS_COUNT]; 
		
		for(int i = 0; i < LabyrinthGame.DEFAULT_PLAYERS_COUNT; i++)
		{
			treasureStacks[i] = new TreasureStack();
			
			for(int j = 0; j < TreasureStack.DEFAULT_PLAYER_STACK_SIZE; j++)
			{
				try {
					treasureStacks[i].setTreasure(allTreasures.pickTreasure());
				} catch (StackIsFullException e) {
					// never gone
				} catch (StackIsEmptyException e) {
					// never gone
				}
			}
			this.players[i] = new Player(treasureStacks[i]);
		}
		
		this.gameIsOver = false;
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
	 *    current player changes
	 * 
	 */
	public void play() {
		int playerPointer = 0;
		
		while(!this.gameIsOver)
		{
			this.currentPlayer = this.players[playerPointer];
			
			// TODO (done) use modulus (%)
			playerPointer = (playerPointer+1)%LabyrinthGame.DEFAULT_PLAYERS_COUNT;
			
			Insertion newInsertion = null;
			while(true)
			{
				newInsertion = this.currentPlayer.askInsertion();
				try
				{
					this.gameboard.processInsertion(newInsertion);
					break;
				}
				// TODO (done) isInsertionValid should not raise an exception in that case
				// (ask for advice)
				catch(InvalidInsertionException e)
				{
					// make the loop
				}
			}
			
			
			Move newMove = null;
			while(true)
			{
				newMove = this.currentPlayer.askMove();
				try
				{
					this.gameboard.processMoving(newMove);
					break;
				}
				catch(InvalidMoveException e)
				{
					// make the loop
				}
			}
		}
	}
}
