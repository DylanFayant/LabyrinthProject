
/**
 * This class represents a Labyrinth game.
 * http://jesweb.net/old/critique/labyrinthe/labyrinthe.html 
 * @author Rachid Taghat - Dylan Fayant
 */
public class LabyrinthGame {
	
	private GameBoard gameboard;
	private Player playerA;
	private Player playerB;
	private Player playerC;
	private Player playerD;
	private Deck deck;

	/**
	 * creates a new game play ready to be played (gameboard contains randomly placed mobile cards,
	 * , treasure cards have been distributed to players).
	 */
	public LabyrinthGame() {
		this.gameboard = new GameBoard(); // Create a new gameboard with randomly placed mobile cards
		
		this.playerA = new Player(); // Create a new player (link a player to a pion)
		this.playerB = new Player(); // Create a new player
		this.playerC = new Player(); // Create a new player
		this.playerD = new Player(); // Create a new player
		
		this.deck = new Deck(); // Generate the common deck
	}
	
	/**
	 * Plays the game 
	 * It's a turn by turn game. The game starts by placing players on the gameboard 
	 * and giving them them decks. Each player check his first card who give him his goal on the gameboard.
	 * Loop(The current player insert the free labyrinth's card in a line or a column and can move his pion in the way created.
	 * If he can go to his goal he gets a new card with a new aim. Next player turn)
	 * When a player gets all his goals, the game plays stops and he is the winner.
	 */
	public void play() {
		this.gameboard.movePlayer(this.playerA); // Put the player to the gameboard move to the constructor.
		this.gameboard.movePlayer(this.playerB); // Put the player to the gameboard
		this.gameboard.movePlayer(this.playerC); // Put the player to the gameboard
		this.gameboard.movePlayer(this.playerD); // Put the player to the gameboard
		
		this.playerA.setOwnDeck(this.deck.getPartDeck()); // Give a part of the deck to the player.
		this.playerB.setOwnDeck(this.deck.getPartDeck()); // Give a part of the deck to the player.
		this.playerC.setOwnDeck(this.deck.getPartDeck()); // Give a part of the deck to the player.
		this.playerD.setOwnDeck(this.deck.getPartDeck()); // Give a part of the deck to the player.

	}

}
