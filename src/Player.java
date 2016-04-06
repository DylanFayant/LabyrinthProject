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
	private final TreasureStack treasureStack;
	
	/**
	 * Create a new player with an unique id
	 * @param treasureStack 
	 */
	public Player(TreasureStack treasureStack) {
		Player.currentMaxId++;
		this.id = currentMaxId;
		this.treasureStack = treasureStack;
	}

	/**
	 * Returns the player id.
	 * @return Player id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Ask the player a tile insertion.
	 * @return Insertion, a tile insertion.
	 */
	public Insertion askInsertion()
	{
		return null;
	}

	/**
	 * Ask the player a move.
	 * @return Move, a move (position)
	 */
	public Move askMove()
	{
		return null;
	}

}
