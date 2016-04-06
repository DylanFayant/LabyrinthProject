import java.util.Arrays;

import Exceptions.*;
/**
 * This class represent a deck of treasures.
 * A deck is a stack of treasures put in a given order and that can be picked one by one.
 * @author Rachid Taghat - Dylan Fayant
 */

public class TreasureStack {
	/**
	 * default stack size setted to a player.
	 */
	public final static int DEFAULT_PLAYER_STACK_SIZE = 6;
	
	/**
	 * maximum of treasures in a stack.
	 */
	public final static int MAX_STACK_SIZE = 24;
	
	/**
	 * treasures contained in the stack
	 */
	private Treasure[] treasures;
	
	/**
	 * stack size
	 */
	private int stackSize;
	
	/**
	 * Generate an empty stack
	 */
	public TreasureStack()
	{
		this.treasures = new Treasure[TreasureStack.DEFAULT_PLAYER_STACK_SIZE];
		this.stackSize = 0;
	}
	
	/**
	* Generate a deck with a treasures list and the deck size.
	* @param treasures Treasures cards list
	*/
	public TreasureStack(Treasure[] treasures)
	{
		this.treasures = new Treasure[treasures.length];
		this.treasures = treasures;
		this.stackSize = treasures.length;
	}
	
	/**
	 * Pick a treasure
	 * @return Treasures, the next treasure in the top of the deck
	 * @throws StackIsEmptyException, the deck is empty
	 */
	public Treasure pickTreasure() throws StackIsEmptyException
	{
		if(this.stackSize == 0) throw new StackIsEmptyException();
		this.stackSize--;
		return this.treasures[this.stackSize];
	}
	
	/**
	 * Add a new treasure card to the deck
	 * @param treasure a treasure card
	 * @throws StackIsFullException, the deck is full
	 */
	public void setTreasure(Treasure treasure) throws StackIsFullException
	{
		if(this.stackSize == TreasureStack.DEFAULT_PLAYER_STACK_SIZE) throw new StackIsFullException();
		this.treasures[this.stackSize] = treasure;
		this.stackSize++;
	}

	/**
	 * Shuffles the current deck
	 */
	public void shuffle()
	{
		Treasure temporaryCard;
		for(int i = 0; i < this.stackSize*10; i++)
		{
			int p1 = (int)(Math.random()*this.stackSize);
			int p2 = (int)(Math.random()*this.stackSize);
			temporaryCard = this.treasures[p1];
			this.treasures[p1] = this.treasures[p2];
			this.treasures[p2] = temporaryCard;
		}
	}
	
	/**
	 * Return a deck's description
	 * @return String, the deck description
	 */
	public String toString()
	{
		return "Deck [treasures=" + Arrays.toString(this.treasures) + ", deckSize=" + this.stackSize + "]";
	}
}
