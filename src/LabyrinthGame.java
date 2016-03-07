
/**
 * This class represents a Labyrinth game.
 * http://jesweb.net/old/critique/labyrinthe/labyrinthe.html 
 * @author Rachid Taghat - Dylan Fayant
 */
public class LabyrinthGame {
	
	// TODO write comment
	private GameBoard gameboard;

	// TODO consider using a data structure to easily manage players as a single field
	// TODO write comment
	private Player playerA;
	
	// TODO write comment
	private Player playerB;
	
	// TODO write comment
	private Player playerC;
	
	// TODO write comment
	private Player playerD;

	// TODO write comment
	private Deck deck;

	/**
	 * creates a new game play ready to be played (gameboard contains randomly placed mobile cards and 4 pawns 
	 * linked to players in the gameboard's corners. Treasure cards have been distributed to players).
	 */
	public LabyrinthGame() {		
		// TODO remove useless implementation comments
		
		this.playerA = new Player(); // Create a new player
		this.playerB = new Player(); // Create a new player
		this.playerC = new Player(); // Create a new player
		this.playerD = new Player(); // Create a new player
		
		this.gameboard = new GameBoard(this.playerA.getPlayerId(), this.playerB.getPlayerId(), this.playerC.getPlayerId(), this.playerD.getPlayerId()); // Create a new gameboard with randomly placed mobile cards and players placed to the corners
		
		
		/*
		 * To redefine this idea of "deck" 
		 * maybe it's better to put it directly in the gameboard...
		 */
		this.deck = new Deck(); // Generate the common deck

		this.playerA.setOwnDeck(this.deck.getPartDeck()); // Give a part of the common deck to the player.
		this.playerB.setOwnDeck(this.deck.getPartDeck()); // Give a part of the common deck to the player.
		this.playerC.setOwnDeck(this.deck.getPartDeck()); // Give a part of the common deck to the player.
		this.playerD.setOwnDeck(this.deck.getPartDeck()); // Give a part of the common deck to the player.
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
