
/**
 * This class represents a Labyrinth game.
 * http://jesweb.net/old/critique/labyrinthe/labyrinthe.html 
 * @author Rachid Taghat - Dylan Fayant
 */
public class LabyrinthGame {
	
	// TODO (done) write comment
	/**
	 * this attribut represents the reference to the game's gameboard
	 */
	private GameBoard gameboard;

	// TODO (done) consider using a data structure to easily manage players as a single field
	// TODO (done) write comment
	/**
	 * the players.
	 */
	private final Player[] players;

	// TODO (done) write comment
	/**
	 * the cards in the game
	 */
	private Deck deck;

	/**
	 * creates a new game play ready to be played (gameboard contains randomly placed mobile cards and 4 pawns 
	 * linked to players in the gameboard's corners. Treasure cards have been distributed to players).
	 */
	public LabyrinthGame() {		
		// TODO (done) remove useless implementation comments
		
		this.players = new Player[4];
		this.gameboard = new GameBoard(); 
	
		// TODO: this.deck = new Deck();
		/*
		 * Cards divide.
		 */
		
	}
	
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
