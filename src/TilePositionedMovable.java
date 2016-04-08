
/**
 * this class represents a tile positioned in the gameboard and who can be moved. 
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class TilePositionedMovable extends TilePositioned
{
	/**
	 * Generates a tile positioned and movable in the game board 
	 * @param tile0 a tile
	 * @param rotation2 a rotation
	 */
	public TilePositionedMovable(Tile tile0, Rotation rotation2)
	{
		super(tile0, rotation2, false);
	}
	
	/**
	 * Sets a new rotation to the tile.
	 * @param rotation
	 */
	public void setRotation(Rotation rotation)
	{
		this.rotation = rotation;
	}

}
