
/**
 * This class represent a Player
 * It's used to manage the interaction between the player and the gameplay.
 * @author Rachid Taghat - Dylan Fayant
 */
public class Player {
	
	// TODO (done) write javadoc comment
	/**
	 * Attribut representing the player id
	 */
	private final int playerId; // The id who represent the player.
	
	// TODO (done) write comment
	/**
	 * Initialise a new player with an unique id
	 */
	public Player() {
		this.playerId = 0;
	}

	// TODO (done) write comment
	/**
	 * This method is used to return the player id.
	 * @return Player id
	 */
	public int getPlayerId() {
		return playerId;
	}

}
