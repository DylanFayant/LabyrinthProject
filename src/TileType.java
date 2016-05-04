
/**
 * The 3 tiles types in the game (ways created)
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public enum TileType
{
	/**
	 * A tile with a T shape
	 */
	T("T"),
	/**
	 * A tile with a I shape
	 */
	I("I"),
	/**
	 * A tile with a L shape
	 */
	L("L");
	
	/**
	 * The way created by the tile described in a letter
	 */
	private final String tileString;
	
	/**
	 * Generates a type of tile 
	 * @param tileString tile's type
	 */
	private TileType(String tileString)
	{
		this.tileString = tileString;
	}

	/**
	 * @see java.lang.Enum#toString()
	 */
	public String toString()
	{
		return this.tileString;
	}
}
