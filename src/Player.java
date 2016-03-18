
/**
 * This class represent a player
 * It's used to manage the interaction between the player and the game.
 * @author Rachid Taghat - Dylan Fayant
 */
public class Player {
	
	// TODO (done) rename field (remove "player")
	/**
	 * the player identifier
	 */
	
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
	
	// TODO (done) think about it: how the identifier can be unique
	// since the constructor can be called several times
	/**
	 * Create a new player with an unique id
	 */
	public Player(TreasureDeck deck) {
		Player.currentMaxId++;
		this.id = currentMaxId;
		this.deck = deck;
	}

	// TODO (done) rename method (after having renamed field)
	/**
	 * Return the player id.
	 * @return Player id
	 */
	public int getId() {
		return this.id;
	}

}
