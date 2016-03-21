
public class Test
{
	public static void main(String[] args)
	{
		TreasureStack allTreasures = new TreasureStack(Treasure.values());
		allTreasures.shuffle();
		TreasureStack p1Deck = new TreasureStack();
		TreasureStack p2Deck = new TreasureStack();
		TreasureStack p3Deck = new TreasureStack();
		TreasureStack p4Deck = new TreasureStack();
		for(int i = 0; i < TreasureStack.DEFAULT_PLAYER_STACK_SIZE; i++)
		{
			try {
				p1Deck.setTreasure(allTreasures.pickTreasure());
				p2Deck.setTreasure(allTreasures.pickTreasure());
				p3Deck.setTreasure(allTreasures.pickTreasure());
				p4Deck.setTreasure(allTreasures.pickTreasure());
			} catch (StackIsFullException e) {
				// never gone
			} catch (StackIsEmptyException e) {
				// never gone
			}
		}
		System.out.println(p1Deck.toString());
		System.out.println(p2Deck.toString());
		System.out.println(p3Deck.toString());
		System.out.println(p4Deck.toString());
		
	}

}
