
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
	private final String tileType;
	
	/**
	 * Generates a type of tile 
	 * @param tileType0 tile's type
	 */
	private TileType(String tileType0)
	{
		this.tileType = tileType0;
	}

	/**
	 * Returns the tile's type (the way)
	 * @return tileType
	 */
	public String getTileType()
	{
		return this.tileType;
	}
}
