
public class Test
{
	public static void main(String[] args)
	{
		TreasureDeck allTreasures = new TreasureDeck(Treasure.values(), Treasure.values().length);
		allTreasures.shuffle();
		TreasureDeck p1Deck = new TreasureDeck();
		TreasureDeck p2Deck = new TreasureDeck();
		TreasureDeck p3Deck = new TreasureDeck();
		TreasureDeck p4Deck = new TreasureDeck();
		for(int i = 0; i < TreasureDeck.DEFAULT_PLAYER_DECK_SIZE; i++)
		{
			try {
				p1Deck.setTreasure(allTreasures.pickTreasure());
				p2Deck.setTreasure(allTreasures.pickTreasure());
				p3Deck.setTreasure(allTreasures.pickTreasure());
				p4Deck.setTreasure(allTreasures.pickTreasure());
			} catch (DeckIsFullException e) {
				// never gone
			} catch (DeckIsEmptyException e) {
				// never gone
			}
		}
		System.out.println(p1Deck.toString());
		System.out.println(p2Deck.toString());
		System.out.println(p3Deck.toString());
		System.out.println(p4Deck.toString());
		
	}

}
