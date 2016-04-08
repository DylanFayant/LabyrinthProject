/**
 * representes a position 2D
 * @author Rachid Taghat - Dylan Fayant
 *
 */
// todo : comparable
public class Position
{
	/**
	 * x coordinate
	 */
	private final int X;
	
	/**
	 * y coordinate
	 */
	private final int Y;
	
	/**
	 * generates a position
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Position(int x, int y)
	{
		this.X = x;
		this.Y = y;
	}

	public int getX()
	{
		return this.X;
	}

	public int getY()
	{
		return this.Y;
	}
}
