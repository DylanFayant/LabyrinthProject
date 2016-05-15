package fr.iutval.labyrinthgame;
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