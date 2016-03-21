
/**
 * This class represent a player
 * It's used to manage the interaction between the player and the game.
 * @author Rachid Taghat - Dylan Fayant
 */
public class Player {
	
	/**
	 * The next id gived to a user (to make that unique)
	 */
	private static int currentMaxId = 0;
	
	/**
	 * The player id, used to identify the player.
	 */
	private final int id;

	/** 
	 * Player's deck
	 */
	private final TreasureDeck deck;
	
	/**
	 * Create a new player with an unique id
	 */
	public Player(TreasureDeck deck) {
		Player.currentMaxId++;
		this.id = currentMaxId;
		this.deck = deck;
	}

	/**
	 * Return the player id.
	 * @return Player id
	 */
	public int getId() {
		return this.id;
	}

}
