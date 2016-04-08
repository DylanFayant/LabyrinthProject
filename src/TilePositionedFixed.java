/**
 * This class represent a tile poisitioned fixed on the gameboard
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class TilePositionedFixed extends TilePositioned
{
	 /**
	 * Generates a tile positioned fixed in the game board 
	 * @param tile0 a tile
	 * @param rotation2 a rotation
	 * @param fixed0 true if the tile's position is fixed
	 */
	public TilePositionedFixed(Tile tile0, Rotation rotation2)
	{
		super(tile0, rotation2, true);
	}
}
