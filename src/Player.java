
/**
 * This class represent a Player
 * It's used to manage the interaction between the player and the gameplay.
 * @author Rachid Taghat - Dylan Fayant
 */
public class Player {
	
	// TODO write javadoc comment
	private final int playerId; // The id who represent the player.
	
	// TODO write javadoc comment
	private Deck playerDeck; // This is the current player's deck.
	
	// TODO write comment
	public Player() {
		this.playerId = 0;
	}

	// TODO write comment
	public int getPlayerId() {
		return playerId;
	}

	// TODO fix comment (this is not a class but a method...)
	// TODO think about a better way to "initially distribute cards to players"
	/**
	 * This is a temporary class used to set the player's deck.
	 * @param partDeck
	 */
	public void setOwnDeck(Deck partDeck) {
		this.playerDeck = partDeck;
		
	}

}
