
/**
 * Tiles enum (all the tiles in the game)
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public enum Tile
{
	TILE1(TileType.TILEL, null),
	TILE2(TileType.TILEI, null),
	TILE3(TileType.TILET, Treasure.KEY),
	TILE4(TileType.TILEL, null),
	TILE5(TileType.TILET, Treasure.SKULL),
	TILE6(TileType.TILEL, null),
	TILE7(TileType.TILEL, null),
	TILE8(TileType.TILEI, null),
	TILE9(TileType.TILEL, null),
	TILE10(TileType.TILEI, null),
	TILE11(TileType.TILEI, null),
	TILE12(TileType.TILEL, Treasure.RAT),
	TILE13(TileType.TILEL, Treasure.MAP),
	TILE14(TileType.TILEL, null),
	TILE15(TileType.TILET, Treasure.RING),
	TILE16(TileType.TILEI, null);
	
	/**
	 * The tile's type (the way)
	 */
	private final TileType tileType;
	
	/**
	 * The treasure in the tile (null if there is no treasure in the tile)
	 */
	private final Treasure treasure;
	
	private Tile(TileType tileType0, Treasure treasure0)
	{
		this.tileType = tileType0;
		this.treasure = treasure0;
	}

	/**
	 * Returns the tile's type (the way)
	 * @return tileType
	 */
	public TileType getTileType()
	{
		return this.tileType;
	}

	/**
	 * Returns the treasure in the tile (null if no treasure)
	 * @return treasure
	 */
	public Treasure getTreasure()
	{
		return this.treasure;
	}
}
