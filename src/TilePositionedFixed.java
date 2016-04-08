/**
 * This class represent a tile poisitioned and fixed on the gameboard
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class TilePositionedFixed extends TilePositioned
{
	 /**
	 * Generates a tile positioned and fixed in the game board 
	 * @param tile0 a tile
	 * @param rotation2 a rotation
	 */
	public TilePositionedFixed(Tile tile0, Rotation rotation2)
	{
		super(tile0, rotation2, true);
	}
}
