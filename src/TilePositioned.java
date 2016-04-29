
/**
 * This class represents a tiles positioned in the game board
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public abstract class TilePositioned
{
	/**
	 * a tile 
	 */
	private final Tile tile;
	/**
	 * a rotation
	 */
	protected Rotation rotation;
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
	protected TilePositioned(Tile tile0, Rotation rotation2, boolean fixed0)
	{
		this.tile = tile0;
		this.rotation = rotation2;
		this.fixed = fixed0;
	}

	/**
	 * Gives the tile represented in the current tile positioned
	 * @return Tile
	 */
	public Tile getTile()
	{
		return this.tile;
	}

	/**
	 * Gives the rotation of the current tile positioned
	 * @return Rotation
	 */
	public Rotation getRotation()
	{
		return this.rotation;
	}

	/**
	 * Returns true if the tile is fixed and false if it's not
	 * @return boolean
	 */
	public boolean isFixed()
	{
		return this.fixed;
	}
	
	public String toString()
	{
		return "["+this.tile+" | "+this.fixed+" | "+this.rotation+"]";
	}
}
