package fr.iutval.labyrinthgame;
import java.util.Random;

import fr.iutval.labyrinthgame.exceptions.PositionIsNotInGameboardException;

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
	 * @throws PositionIsNotInGameboardException 
	 * @throws YisNotInGameboardException 
	 */
	public PositionInTheGameBoard(int x, int y) throws PositionIsNotInGameboardException
	{
		if(x < 0 || x >= PositionInTheGameBoard.max_X || y < 0 || y >= PositionInTheGameBoard.max_Y) throw new PositionIsNotInGameboardException();
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
	 * @throws PositionIsNotInGameboardException 
	 */
	public PositionInTheGameBoard nextPosition(Direction direction) throws PositionIsNotInGameboardException
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
