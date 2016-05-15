package fr.iutval.labyrinthgame;
import java.util.LinkedList;
import java.util.List;

import Exceptions.XisNotInGameboardException;
import Exceptions.YisNotInGameboardException;

/**
 * Represents a movement
 * It's a list of linked positions
 * @author Rachid Taghat - Dylan Fayant			
 *
 */
public class Movement
{
	/**
	 * A list of all the positions
	 */
	private List<PositionInTheGameBoard> movement;
	
	/**
	 * Generates the movement with an initial position
	 * @param position (the current pawn's position)
	 */
	public Movement(PositionInTheGameBoard position)
	{
		movement = new LinkedList<PositionInTheGameBoard>();
		this.movement.add(position);
	}
	
	/**
	 * Get the movement
	 * @return movement
	 */
	public List<PositionInTheGameBoard> getMovement()
	{
		return this.movement;
	}
	
	/**
	 * Add the next move (linked to the next move)
	 * @param direction 
	 * @throws YisNotInGameboardException 
	 * @throws XisNotInGameboardException 
	 */
	public void nextMove(Direction direction) throws XisNotInGameboardException, YisNotInGameboardException
	{
		PositionInTheGameBoard previousPosition = this.movement.get(movement.size()-1);
		this.movement.add(previousPosition.nextPosition(direction));
	}
	
}
