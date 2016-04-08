
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
	TILE16(TileType.TILEI, null),
	TILE17(TileType.TILET, Treasure.BAT),
    TILE18(TileType.TILEL, Treasure.SPIDER),
    TILE19(TileType.TILET, Treasure.GHOST),
    TILE20(TileType.TILEI, null),
    TILE21(TileType.TILET, Treasure.BUTTERFLY),
    TILE22(TileType.TILEI, null),
    TILE23(TileType.TILEI, null),
    TILE24(TileType.TILET, Treasure.CANDLESTICK),
    TILE25(TileType.TILET, Treasure.CROWN),
    TILE26(TileType.TILEL, null),
    TILE27(TileType.TILEI, null),
    TILE28(TileType.TILEL, null),
    TILE29(TileType.TILET, Treasure.BOOK),
    TILE30(TileType.TILEI, null),
    TILE31(TileType.TILET, Treasure.DRAKE),
    TILE32(TileType.TILEL, null),
    TILE33(TileType.TILET, Treasure.DRAGON),
    TILE34(TileType.TILEL, Treasure.OWLS),
    TILE35(TileType.TILET, Treasure.DOG),
    TILE36(TileType.TILEL, null),
    TILE37(TileType.TILEL, Treasure.SCARAB),
    TILE38(TileType.TILEI, null),
    TILE39(TileType.TILET, Treasure.CHEST),
    TILE40(TileType.TILET, Treasure.LIZARD),
    TILE41(TileType.TILET, Treasure.PRINCESS),
    TILE42(TileType.TILET, Treasure.SWORD),
    TILE43(TileType.TILEL, null),
    TILE44(TileType.TILEI, null),
    TILE45(TileType.TILET, Treasure.PIRATE),
    TILE46(TileType.TILEL, null),
    TILE47(TileType.TILET, Treasure.DIAMOND),
    TILE48(TileType.TILEL, null),
    TILE49(TileType.TILEL, null),
    TILE50(TileType.TILEL, Treasure.PURSE);
	
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
