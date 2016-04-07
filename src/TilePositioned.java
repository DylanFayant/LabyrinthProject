
/**
 * This class represents a tiles positioned in the game board
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class TilePositioned
{
	/**
	 * a tile 
	 */
	private final Tile tile;
	/**
	 * a rotation
	 */
	private Rotation rotation;
	/**
	 * the tile's position is fixed
	 */
	private final boolean fixed;
	
	/**
	 * Generates a tile positioned in the game board 
	 * @param tile0 a tile
	 * @param rotation2 a rotation
	 * @param fixed0 true if the tile's position is fixed
	 */
	public TilePositioned(Tile tile0, Rotation rotation2, boolean fixed0)
	{
		this.tile = tile0;
		this.rotation = rotation2;
		this.fixed = fixed0;
	}
	
}
