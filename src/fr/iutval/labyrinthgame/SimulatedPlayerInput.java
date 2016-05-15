package fr.iutval.labyrinthgame;
import java.util.Random;

import fr.iutval.labyrinthgame.exceptions.XisNotInGameboardException;
import fr.iutval.labyrinthgame.exceptions.YisNotInGameboardException;

/**
 * Represents a simulated player input
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class SimulatedPlayerInput implements PlayerInput
{
	/**
	 * Returns a random insertion
	 * @return Insertion, a tile insertion.
	 */
	public Insertion askInsertion()
	{
		return new Insertion();
	}

	/**
	 * Returns a random move
	 * @param initialMove 
	 * @return Move, a move (position)
	 */
	public Movement askMove(Movement initialMove)
	{
		Direction[] directions = Direction.values();
		int random = new Random().nextInt(4);
		while(initialMove.getMovement().size() < random)
		{
			while(true)
			{
				try {
					initialMove.nextMove(directions[new Random().nextInt(directions.length)]);
					break;
				} catch (XisNotInGameboardException e) {
					// make a loop
				} catch (YisNotInGameboardException e) {
					// make a loop
				}
			}
		}
		return initialMove;
	}

}
