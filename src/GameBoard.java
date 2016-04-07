import Exceptions.*;

/**
 * This class is used to represent the labyrinth's GameBoard. 
 * This class contain the different cards (tiles) on the gameboard and the players' pawns.
 * @author Rachid Taghat - Dylan Fayant
 */
public class GameBoard {

	private static final int WIDTH = 7;
	private static final int HEIGHT = 7;
	TilePositioned[][] gameBoard;
	
	/**
	 * Create a new gameboard with randomly placed mobile cards and players pawns placed to the corners
	 */
	public GameBoard() {
		gameBoard = new TilePositioned[GameBoard.WIDTH][GameBoard.HEIGHT];
		
		// TODO: finish the generation of the fixed tiles
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE3, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE5, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);

		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);

		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);

		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
	}

	/**
	 * Process the insertion into the gameboard.
	 * @param newInsertion an insertion
	 */
	public void processInsertion(Insertion newInsertion) throws InvalidInsertionException
	{
		
	}

	/**
	 * Process the player's moving.
	 * @param newMove a move.
	 */
	public void processMoving(Move newMove) throws InvalidMoveException
	{
		
	}

}
