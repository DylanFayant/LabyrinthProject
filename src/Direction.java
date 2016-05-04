
/**
 * All the directions availables to move the pawn
 * @author Rachid Taghat - Dylan Fayant
 */
public enum Direction
{
	/**
	 * Up direction
	 */
	UP(0,-1),
	/**
	 * Right direction
	 */
	RIGHT(1,0),
	/**
	 * Down direction
	 */
	DOWN(0,1),
	/**
	 * Left direction
	 */
	LEFT(-1,0);
	
	/**
	 * The x position we moves on
	 */
	private int xMove;
	/**
	 * The y position we moves on
	 */
	private int yMove;
	
	/**
	 * Set the xMove and Move when we construct the enum
	 * @param x move
	 * @param y move
	 */
	private Direction(int x, int y) {
		this.xMove = x;
		this.yMove = y;
	}

	/**
	 * Get the x move for the direction
	 * @return xMove
	 */
	public int getxMove()
	{
		return this.xMove;
	}

	/**
	 * Get the y move for the direction
	 * @return yMove
	 */
	public int getyMove()
	{
		return this.yMove;
	}
	
}
