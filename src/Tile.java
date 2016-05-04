
/**
 * Tiles enum (all the tiles in the game)
 * @author Rachid Taghat - Dylan Fayant
 *
 */
@SuppressWarnings("javadoc")
public enum Tile
{
	TILE1(TileType.L, null),
	TILE2(TileType.I, null),
	TILE3(TileType.T, Treasure.KEY),
	TILE4(TileType.L, null),
	TILE5(TileType.T, Treasure.SKULL),
	TILE6(TileType.L, null),
	TILE7(TileType.L, null),
	TILE8(TileType.I, null),
	TILE9(TileType.L, null),
	TILE10(TileType.I, null),
	TILE11(TileType.I, null),
	TILE12(TileType.L, Treasure.RAT),
	TILE13(TileType.L, Treasure.MAP),
	TILE14(TileType.L, null),
	TILE15(TileType.T, Treasure.RING),
	TILE16(TileType.I, null),
	TILE17(TileType.T, Treasure.BAT),
    TILE18(TileType.L, Treasure.SPIDER),
    TILE19(TileType.T, Treasure.GHOST),
    TILE20(TileType.I, null),
    TILE21(TileType.T, Treasure.BUTTERFLY),
    TILE22(TileType.I, null),
    TILE23(TileType.I, null),
    TILE24(TileType.T, Treasure.CANDLESTICK),
    TILE25(TileType.T, Treasure.CROWN),
    TILE26(TileType.L, null),
    TILE27(TileType.I, null),
    TILE28(TileType.L, null),
    TILE29(TileType.T, Treasure.BOOK),
    TILE30(TileType.I, null),
    TILE31(TileType.T, Treasure.DRAKE),
    TILE32(TileType.L, null),
    TILE33(TileType.T, Treasure.DRAGON),
    TILE34(TileType.L, Treasure.OWLS),
    TILE35(TileType.T, Treasure.DOG),
    TILE36(TileType.L, null),
    TILE37(TileType.L, Treasure.SCARAB),
    TILE38(TileType.I, null),
    TILE39(TileType.T, Treasure.CHEST),
    TILE40(TileType.T, Treasure.LIZARD),
    TILE41(TileType.T, Treasure.PRINCESS),
    TILE42(TileType.T, Treasure.SWORD),
    TILE43(TileType.L, null),
    TILE44(TileType.I, null),
    TILE45(TileType.T, Treasure.PIRATE),
    TILE46(TileType.L, null),
    TILE47(TileType.T, Treasure.DIAMOND),
    TILE48(TileType.L, null),
    TILE49(TileType.L, null),
    TILE50(TileType.L, Treasure.PURSE);
	
	/**
	 * The tile's type (the way)
	 */
	private final TileType tileType;
	
	/**
	 * The treasure in the tile (null if there is no treasure in the tile)
	 */
	private final Treasure treasure;
	
	/**
	 * Generates a tile with a type and maybe a treasure (null if not)
	 * @param tileType0 a way of tile
	 * @param treasure0 a treasure (null if not)
	 */
	private Tile(TileType tileType0, Treasure treasure0)
	{
		this.tileType = tileType0;
		this.treasure = treasure0;
	}
	
	public TileType getTileType()
	{
		return this.tileType;
	}
	
	/**
	 * @see java.lang.Enum#toString()
	 */
	public String toString()
	{
		return this.treasure+" | "+this.tileType;
	}
	
}
