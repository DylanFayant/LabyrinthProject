package fr.iutval.labyrinthgame.gameIO;
import fr.iutval.labyrinthgame.Direction;
import fr.iutval.labyrinthgame.Insertion;

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
	 * Returns a random direction
	 * @return Insertion, a tile insertion.
	 */
	public Direction askDirection()
	{
		return Direction.getRandomDirection();
	}

}
