
/**
 * The 3 tiles types in the game (ways created)
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public enum TileType
{
	T("T"),
	I("I"),
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
