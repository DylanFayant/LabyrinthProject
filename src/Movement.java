import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Exceptions.XisNotInGameboardException;
import Exceptions.YisNotInGameboardException;

/**
 * 
 * @author Rachid Taghat - Dylan Fayant			
 *
 */
public class Movement
{
	private List<PositionInTheGameBoard> aMovement;
	
	/**
	 * @param position
	 */
	public Movement(PositionInTheGameBoard position)
	{
		aMovement = new LinkedList<PositionInTheGameBoard>();
		this.aMovement.add(position);
	}
	
	/**
	 * @param direction 
	 * @throws YisNotInGameboardException 
	 * @throws XisNotInGameboardException 
	 */
	public void nextMove(Direction direction) throws XisNotInGameboardException, YisNotInGameboardException
	{
		PositionInTheGameBoard previousPosition = this.aMovement.get(aMovement.size()-1);
		PositionInTheGameBoard newPosition = null;
		if(direction == Direction.UP)
			newPosition = new PositionInTheGameBoard(previousPosition.getX(), previousPosition.getY()-1);
		else if(direction == Direction.DOWN)
			newPosition = new PositionInTheGameBoard(previousPosition.getX(), previousPosition.getY()+1);
		else if(direction == Direction.RIGHT)
			newPosition = new PositionInTheGameBoard(previousPosition.getX()+1, previousPosition.getY());
		else if(direction == Direction.LEFT)
			newPosition = new PositionInTheGameBoard(previousPosition.getX()-1, previousPosition.getY());
		this.aMovement.add(newPosition);
	}
	
}
