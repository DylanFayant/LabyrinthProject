import java.util.Random;

import Exceptions.XisNotInGameboardException;
import Exceptions.YisNotInGameboardException;

/**
 * Represents a 2D position
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class PositionInTheGameBoard
{
	/**
	 * gameboard max width 
	 */
	private final static int max_X = GameBoard.WIDTH;
	
	/**
	 * gameboard max height
	 */
	private final static int max_Y = GameBoard.HEIGHT;
	
	/**
	 * x coordinate
	 */
	private final int X;
	
	/**
	 * y coordinate
	 */
	private final int Y;
	
	/**
	 * generates a position in the gameboard
	 * @param x coordinate
	 * @param y coordinate
	 * @throws XisNotInGameboardException 
	 * @throws YisNotInGameboardException 
	 */
	public PositionInTheGameBoard(int x, int y) throws XisNotInGameboardException, YisNotInGameboardException
	{
		if(x < 0 || x >= PositionInTheGameBoard.max_X) throw new XisNotInGameboardException();
		if(y < 0 || y >= PositionInTheGameBoard.max_Y) throw new YisNotInGameboardException();
		this.X = x;
		this.Y = y;
	}
	
	/**
	 * generates a random position in the gameboard
	 */
	public PositionInTheGameBoard()
	{
		this.X = new Random().nextInt(PositionInTheGameBoard.max_X);
		this.Y = new Random().nextInt(PositionInTheGameBoard.max_Y);
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
	 * Returns the next position to a given direction for the current position
	 * @param direction Direction
	 * @return the next position 
	 * @throws YisNotInGameboardException 
	 * @throws XisNotInGameboardException 
	 */
	public PositionInTheGameBoard nextPosition(Direction direction) throws XisNotInGameboardException, YisNotInGameboardException
	{
		return new PositionInTheGameBoard(this.getX()+direction.getxMove(), this.getY()+direction.getyMove());
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o)
	{
		if(o == null) return false;
		if(!(o instanceof PositionInTheGameBoard)) return false;
		if (this == o) return true;
		
		PositionInTheGameBoard toCompare = (PositionInTheGameBoard)o;
		
		if(this.getX() == toCompare.getX() && this.getY() == toCompare.getY())
			return true;
		else
			return false;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.X;
		result = prime * result + this.Y;
		return result;
	}	
}
