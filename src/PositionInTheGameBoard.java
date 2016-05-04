import java.util.Random;

import Exceptions.XisNotInGameboardException;
import Exceptions.YisNotInGameboardException;

/**
 * representes a position 2D
 * @author Rachid Taghat - Dylan Fayant
 *
 */
// TODO (done) : make this comparable to a HashMap
public class PositionInTheGameBoard
{
	/**
	 * max width 
	 */
	private final static int max_X = GameBoard.WIDTH;
	
	/**
	 * max height
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
	 * generates a position
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
	 * generates a randomposition
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
	 * TODO
	 * @param direction
	 * @return
	 * @throws YisNotInGameboardException 
	 * @throws XisNotInGameboardException 
	 */
	public PositionInTheGameBoard nextPosition(Direction direction) throws XisNotInGameboardException, YisNotInGameboardException
	{
		return new PositionInTheGameBoard(this.getX()+direction.getxMove(), this.getY()+direction.getyMove());
	}
	
	/**
	 * Checks if the object comparated is equal to the current object
	 * @return boolean 
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
