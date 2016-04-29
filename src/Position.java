/**
 * representes a position 2D
 * @author Rachid Taghat - Dylan Fayant
 *
 */
// TODO (done?) : make this comparable to a HashMap
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

	/**
	 * Returns the X coordinate
	 * @return int the X
	 */
	public int getX()
	{
		return this.X;
	}

	/**
	 * Returns the Y coordinate
	 * @return int the Y
	 */
	public int getY()
	{
		return this.Y;
	}
	
	/**
	 * Checks if the object comparated is equal to the current object
	 * @return boolean 
	 */
	public boolean equals(Object o)
	{
		if(o == null) return false;
		if(!(o instanceof Position)) return false;
		if (this == o) return true;
		
		Position toCompare = (Position)o;
		
		if(this.getX() == toCompare.getX() && this.getY() == toCompare.getY())
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the only hash code (auto-generated)
	 * @return int
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.X;
		result = prime * result + this.Y;
		return result;
	}	
}
