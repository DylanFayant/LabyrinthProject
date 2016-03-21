import java.util.Arrays;

// TODO if the deck is a stakc, call it stack ;-)
/**
 * This class represent a deck of treasures.
 * A deck is a stack of treasures put in a given order and that can be picked one by one.
 * @author Rachid Taghat - Dylan Fayant
 */

public class TreasureDeck {
	/**
	 * default deck size setted to a player.
	 */
	public final static int DEFAULT_PLAYER_DECK_SIZE = 6;
	
	/**
	 * maximum of treasures in a deck.
	 */
	public final static int MAX_DECK_SIZE = 24;
	
	/**
	 * treasures contained in the deck
	 */
	private Treasure[] treasures;
	
	/**
	 * deck size
	 */
	private int deckSize;
	
	/**
	 * Generate an empty deck
	 */
	public TreasureDeck()
	{
		this.treasures = new Treasure[TreasureDeck.DEFAULT_PLAYER_DECK_SIZE];
		this.deckSize = 0;
	}
	
	/**
	* Generate a deck with a treasures list and the deck size.
	* @param treasures Treasures cards list
	* @param deckSize The deck size
	*/
	public TreasureDeck(Treasure[] treasures, int deckSize)
	{
		this.treasures = new Treasure[deckSize];
		this.treasures = treasures;
		this.deckSize = deckSize;
	}
	
	/**
	 * Pick a treasure
	 * @return Treasures, the next treasure in the top of the deck
	 * @throws DeckIsEmptyException, the deck is empty
	 */
	public Treasure pickTreasure() throws DeckIsEmptyException
	{
		if(this.deckSize == 0) throw new DeckIsEmptyException();
		this.deckSize--;
		return this.treasures[this.deckSize];
	}
	
	/**
	 * Add a new treasure card to the deck
	 * @param treasure, a treasure card
	 * @throws DeckIsFullException, the deck is full
	 */
	public void setTreasure(Treasure treasure) throws DeckIsFullException
	{
		if(this.deckSize == TreasureDeck.DEFAULT_PLAYER_DECK_SIZE) throw new DeckIsFullException();
		this.treasures[this.deckSize] = treasure;
		this.deckSize++;
	}

	/**
	 * Shuffles the current deck
	 */
	public void shuffle()
	{
		Treasure temporaryCard;
		for(int i = 0; i < this.deckSize*10; i++)
		{
			int p1 = (int)(Math.random()*this.deckSize);
			int p2 = (int)(Math.random()*this.deckSize);
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
		return "Deck [treasures=" + Arrays.toString(this.treasures) + ", deckSize=" + this.deckSize + "]";
	}
}
