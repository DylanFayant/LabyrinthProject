
/**
 * TODO
 * @author fayantd
 *
 */
public enum Direction
{
	UP(0,-1),
	RIGHT(1,0),
	DOWN(0,1),
	LEFT(-1,0);
	
	/**
	 * 
	 */
	private int xMove;
	/**
	 * 
	 */
	private int yMove;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	private Direction(int x, int y) {
		this.xMove = x;
		this.yMove = y;
	}

	/**
	 * @return
	 */
	public int getxMove()
	{
		return this.xMove;
	}

	/**
	 * @return
	 */
	public int getyMove()
	{
		return this.yMove;
	}
	
}
