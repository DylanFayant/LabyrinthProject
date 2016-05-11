
/**
 * Represents a player input
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public interface PlayerOutput
{
	/**
	 * Prints the string to a line in the player output
	 * @param gameBoard 
	 */
	public void gameBoardUpdate(GameBoard gameBoard);
	
	/**
	 * Prints the string in the player output
	 * @param playerIds 
	 * @param string
	 */
	public void gameIsOver(int playerIds);
}
