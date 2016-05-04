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
		// Random insertion
		return new Insertion();
	}

	/**
	 * Ask the player a move.
	 * @return Move, a move (position)
	 */
	public Movement askMove()
	{
		// TODO : Random move
		return null;
	}

	/**
	 * Get the player's treasure stack
	 * @return treasureStack
	 */
	public TreasureStack getTreasureStack() {
		return this.treasureStack;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (this.id != other.id)
			return false;
		return true;
	}
}
