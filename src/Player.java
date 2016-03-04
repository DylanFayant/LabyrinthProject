
/**
 * This class represent a Player
 * It's used to manage the interaction between the player and the gameplay.
 * @author Rachid Taghat - Dylan Fayant
 */
public class Player {
	
	private final int playerId; // The id who represent the player.
	private Deck playerDeck; // This is the current player's deck.
	
	public Player() {
		this.playerId = 0;
	}

	public int getPlayerId() {
		return playerId;
	}

	/**
	 * This is a temporary class used to set the player's deck.
	 * @param partDeck
	 */
	public void setOwnDeck(Deck partDeck) {
		this.playerDeck = partDeck;
		
	}

}
