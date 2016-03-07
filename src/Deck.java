
// TODO fix comment (ask for advice)
/**
 * This class represent a deck of cards.
 * The deck is a stack of cards put in a given order and that can be picked one by one.
 * @author Rachid Taghat - Dylan Fayant
 */


public class Deck {
	
	public final static int MAX_DECK_SIZE = 24;
	
	private final Card[] cards;
	private int deckSize;
	
	// TODO (done) consider writing a constructor instead of this (from where the cards come?)	
	/**
	 * Generate the common deck by picking randomly 24 cards in the cards array
	 */
	public Deck(Card[] cards)
	{
		this.cards = new Card[Deck.MAX_DECK_SIZE];
		
		/*
		 * Make the deck (a stack)
		 */
	}
	

	/**
	 * Pick a card
	 * @return the next card in the top of the deck
	 */
	public String pickCard()
	{
		return null;
	}

}
