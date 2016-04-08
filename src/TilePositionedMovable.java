
/**
 * this class represents a tile positioned movable in the gameboard  
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class TilePositionedMovable extends TilePositioned
{
	/**
	 * Generates a tile positioned movable in the game board 
	 * @param tile0 a tile
	 * @param rotation2 a rotation
	 * @param fixed0 true if the tile's position is fixed
	 */
	public TilePositionedMovable(Tile tile0, Rotation rotation2)
	{
		super(tile0, rotation2, false);
		// TODO Auto-generated constructor stub
	}
	
	public void setRotation(Rotation rotation)
	{
		this.rotation = rotation;
	}

}
