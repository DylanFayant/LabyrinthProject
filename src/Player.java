
/**
 * This class represent a player
 * It's used to manage the interaction between the player and the game.
 * @author Rachid Taghat - Dylan Fayant
 */
public class Player {
	
	// TODO rename field (remove "player")
	/**
	 * the player identifier
	 */
	private final int playerId;
	
	// TODO think about it: how the identifier can be unique
	// since the constructor can be called several times
	/**
	 * Create a new player with an unique id
	 */
	public Player() {
		this.playerId = 0;
	}

	// TODO rename method (after having renamed field)
	/**
	 * Return the player id.
	 * @return Player id
	 */
	public int getPlayerId() {
		return playerId;
	}

}
