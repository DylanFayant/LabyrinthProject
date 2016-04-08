
/**
 * The 3 tiles types in the game (ways created)
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public enum TileType
{
	TILET("T"),
	TILEI("I"),
	TILEL("L");
	
	private final String tileType;
	
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