import java.util.Random;

import Exceptions.StackIsEmptyException;
import Exceptions.XisNotInGameboardException;
import Exceptions.YisNotInGameboardException;

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
	 * Current objectif treasure for the player
	 */
	private Treasure currentTreasure;
	
	/**
	 * Create a new player with an unique id
	 * @param treasureStack 
	 */
	public Player(TreasureStack treasureStack) {
		Player.currentMaxId++;
		this.id = currentMaxId;
		this.treasureStack = treasureStack;
		try {
			this.currentTreasure = this.treasureStack.pickTreasure();
		} catch (StackIsEmptyException e) {
			// impossible
		}
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
		// TODO : Other way than random insertion
		return new Insertion();
	}

	/**
	 * Ask the player a move.
	 * @param aMove 
	 * @return Move, a move (position)
	 */
	public Movement askMove(Movement aMove)
	{
		Direction[] directions = Direction.values();
		while(true)
		{
			try {
				aMove.nextMove(directions[new Random().nextInt(directions.length)]);
				break;
			} catch (XisNotInGameboardException e) {
				// make a loop
			} catch (YisNotInGameboardException e) {
				// make a loop
			}
		}
		return aMove;
	}

	/**
	 * Get the player's treasure stack
	 * @return treasureStack
	 */
	public TreasureStack getTreasureStack()
	{
		return this.treasureStack;
	}
	
	/**
	 * Get the current treasure card of the player
	 * @return Treasure
	 */
	public Treasure getCurrentTreasure()
	{
		return this.currentTreasure;
	}
	
	/**
	 * Pick the next treasure in the stack
	 * @throws StackIsEmptyException
	 */
	public void nextTreasure() throws StackIsEmptyException 
	{
		this.currentTreasure = this.treasureStack.pickTreasure();
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
	
	public String toString() 
	{
		return "Player's id: " + this.id;
	}
}
