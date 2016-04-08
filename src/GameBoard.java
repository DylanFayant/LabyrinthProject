import java.util.ArrayList;

import Exceptions.*;

/**
 * This class is used to represent the labyrinth's GameBoard. 
 * This class contain the different cards (tiles) on the gameboard and the players' pawns.
 * @author Rachid Taghat - Dylan Fayant
 */
public class GameBoard {

	// TODO write comment
	private static final int WIDTH = 7;
	
	// TODO write comment
	private static final int HEIGHT = 7;
	
	// TODO write comment
	TilePositioned[][] gameBoard;
	
	/**
	 * Create a new gameboard with randomly placed mobile cards and players pawns placed to the corners
	 */
	public GameBoard() {
		gameBoard = new TilePositioned[GameBoard.WIDTH][GameBoard.HEIGHT];
		
		ArrayList tilesAvailable = new ArrayList();
		
		Tile[] listTiles = Tile.values();		
		for(Tile aTile : listTiles)
		{
			//tilesAvailable()
		}
		
		// generation of the fixed tiles
		gameBoard[0][0] = new TilePositioned(Tile.TILE1, Rotation.ROTATION2, true);
		gameBoard[2][0] = new TilePositioned(Tile.TILE3, Rotation.ROTATION1, true);
		gameBoard[4][0] = new TilePositioned(Tile.TILE5, Rotation.ROTATION1, true);
		gameBoard[6][0] = new TilePositioned(Tile.TILE7, Rotation.ROTATION3, true);

		gameBoard[0][2] = new TilePositioned(Tile.TILE15, Rotation.ROTATION4, true);
		gameBoard[2][2] = new TilePositioned(Tile.TILE17, Rotation.ROTATION4, true);
		gameBoard[2][2] = new TilePositioned(Tile.TILE19, Rotation.ROTATION1, true);
		gameBoard[6][2] = new TilePositioned(Tile.TILE21, Rotation.ROTATION2, true);

		gameBoard[0][4] = new TilePositioned(Tile.TILE29, Rotation.ROTATION4, true);
		gameBoard[2][4] = new TilePositioned(Tile.TILE31, Rotation.ROTATION3, true);
		gameBoard[4][4] = new TilePositioned(Tile.TILE33, Rotation.ROTATION2, true);
		gameBoard[6][4] = new TilePositioned(Tile.TILE35, Rotation.ROTATION2, true);

		gameBoard[0][6] = new TilePositioned(Tile.TILE43, Rotation.ROTATION1, true);
		gameBoard[2][6] = new TilePositioned(Tile.TILE45, Rotation.ROTATION3, true);
		gameBoard[4][6] = new TilePositioned(Tile.TILE47, Rotation.ROTATION3, true);
		gameBoard[6][6] = new TilePositioned(Tile.TILE49, Rotation.ROTATION4, true);
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
