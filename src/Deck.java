// TODO fix comment (ask for advice)
/**
 * This class represent a deck of cards.
 * A deck is a stack of cards put in a given order and that can be picked one by one.
 * @author Rachid Taghat - Dylan Fayant
 */

public class Deck {
	/**
	 * maximum of cards in a deck.
	 */
	public final static int MAX_DECK_SIZE = 24;
	
	/**
	 * cards contained in the deck
	 */
	private Card[] cards;
	
	/**
	 * deck size
	 */
	private int deckSize;
		
	/**
	 * Generate the common deck by picking randomly 24 cards in the cards array
	 */
	public Deck(Card[] cards)
	{
		this.cards = new Card[Deck.MAX_DECK_SIZE];
		this.cards = cards;
		this.deckSize = cards.length;
	}
	

	// TODO returning null is relevant, but try to use exception (for training purpose)
	/**
	 * Pick a card
	 * @return the next card in the top of the deck, if the deck is empty null
	 */
	public Card pickCard()
	{
		if(this.deckSize == 0)
			return null;
		this.deckSize--;
		return this.cards[this.deckSize];
	}
	
	// TODO override toString to be able to view the deck content (for debug purpose for the moment)
}
