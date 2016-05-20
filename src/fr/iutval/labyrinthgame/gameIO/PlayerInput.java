package fr.iutval.labyrinthgame.gameIO;

import fr.iutval.labyrinthgame.Insertion;
import fr.iutval.labyrinthgame.Movement;

/**
 * Represents a player input
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public interface PlayerInput
{
	/**
	 * Ask the player a tile insertion.
	 * @return Insertion, a tile insertion.
	 */
	public Insertion askInsertion();

	/**
	 * Ask the player a move.
	 * @param initialMove 
	 * @return Move, a move (position)
	 */
	public Movement askMove(Movement initialMove);
}
