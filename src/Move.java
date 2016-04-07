
/**
 * Represents a pawn's move (position X,Y)
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class Move
{
	/**
	 * The X coordinate
	 */
	private final int x;
	
	/**
	 * The Y coordinate
	 */
	private final int y;
	
	/**
	 * Generate a move with X and Y coordinates.
	 * @param x1 the x coordinate
	 * @param y1 the y coordinate
	 */
	public Move(int x1, int y1)
	{
		this.x = x1;
		this.y = y1;
	}

	/**
	 * Returns the x coordinate of the Move.
	 * @return x
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * Returns the y coordinate of the move
	 * @return y
	 */
	public int getY()
	{
		return this.y;
	}
	
}
