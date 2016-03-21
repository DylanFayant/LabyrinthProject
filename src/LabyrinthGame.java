
/**
 * This class represents a Labyrinth game.
 * http://jesweb.net/old/critique/labyrinthe/labyrinthe.html 
 * @author Rachid Taghat - Dylan Fayant
 */
public class LabyrinthGame {
	
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
	 * the cards in the game
	 */
	private TreasureDeck deck;

	/**
	 * creates a new labyrinth game ready to be played (gameboard contains randomly placed mobile tiles and 4 pawns 
	 * linked to players in the gameboard's corners. Treasure cards have been distributed to players).
	 */
	public LabyrinthGame() {		
		
		this.players = new Player[LabyrinthGame.DEFAULT_PLAYERS_COUNT];
		
		this.gameboard = new GameBoard(); 
	
		// TODO: this.deck = new Deck();
		/*
		 * Cards divide.
		 */
		
	}
	
	// TODO detail algorithm (ask for advice)
	/**
	 * Plays the game 
	 * It's a turn by turn game. The game starts by checking all players first card
	 * who give them they goal on the gameboard.
	 * Loop(The current player insert the free labyrinth's card in a line or a column 
	 * and can move his pion in the way created. If he can go to his goal he gets a new 
	 * card with a new aim. Next player turn)
	 * When a player gets all his goals, the game play stops and he is the winner.
	 */
	public void play() {

	}

}
