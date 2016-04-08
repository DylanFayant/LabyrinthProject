import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

import Exceptions.InvalidInsertionException;
import Exceptions.InvalidMoveException;

/**
 * This class is used to represent the labyrinth's GameBoard. 
 * This class contain the different cards (tiles) on the gameboard and the players' pawns.
 * @author Rachid Taghat - Dylan Fayant
 */
public class GameBoard {

	/**
	 * Gameboard's width
	 */
	public static final int WIDTH = 7;
	
	/**
	 * Gameboard's height
	 */
	private static final int HEIGHT = 7;
	
	/**
	 * Table containing the tiles
	 */
	TilePositioned[][] gameBoard;
	
	/**
	 * Creates and generates a HashMap who contains all the tiles fixed and their positions
	 */
	private final static HashMap<Position, TilePositionedFixed> tilesFixed = new HashMap<Position, TilePositionedFixed>();
	static {
		tilesFixed.put(new Position(0, 0), new TilePositionedFixed(Tile.TILE1, Rotation.ROTATION2));
		tilesFixed.put(new Position(2, 0), new TilePositionedFixed(Tile.TILE3, Rotation.ROTATION1));
		tilesFixed.put(new Position(4, 0), new TilePositionedFixed(Tile.TILE5, Rotation.ROTATION1));
		tilesFixed.put(new Position(6, 0), new TilePositionedFixed(Tile.TILE7, Rotation.ROTATION3));

		tilesFixed.put(new Position(0, 2), new TilePositionedFixed(Tile.TILE15, Rotation.ROTATION4));
		tilesFixed.put(new Position(2, 2), new TilePositionedFixed(Tile.TILE17, Rotation.ROTATION4));
		tilesFixed.put(new Position(4, 2), new TilePositionedFixed(Tile.TILE19, Rotation.ROTATION1));
		tilesFixed.put(new Position(6, 2), new TilePositionedFixed(Tile.TILE21, Rotation.ROTATION2));

		tilesFixed.put(new Position(0, 4), new TilePositionedFixed(Tile.TILE29, Rotation.ROTATION4));
		tilesFixed.put(new Position(2, 4), new TilePositionedFixed(Tile.TILE31, Rotation.ROTATION3));
		tilesFixed.put(new Position(4, 4), new TilePositionedFixed(Tile.TILE33, Rotation.ROTATION2));
		tilesFixed.put(new Position(6, 4), new TilePositionedFixed(Tile.TILE35, Rotation.ROTATION2));

		tilesFixed.put(new Position(0, 6), new TilePositionedFixed(Tile.TILE43, Rotation.ROTATION1));
		tilesFixed.put(new Position(2, 6), new TilePositionedFixed(Tile.TILE45, Rotation.ROTATION3));
		tilesFixed.put(new Position(4, 6), new TilePositionedFixed(Tile.TILE47, Rotation.ROTATION3));
		tilesFixed.put(new Position(6, 6), new TilePositionedFixed(Tile.TILE49, Rotation.ROTATION4));
	}
	
	/**
	 * The free tile (not in game)
	 */
	private Tile freeTile = Tile.TILE50;
	
	/**
	 * Create a new gameboard with randomly placed mobile cards and players pawns placed to the corners
	 */
	public GameBoard() {
		gameBoard = new TilePositioned[GameBoard.WIDTH][GameBoard.HEIGHT];
		
		// Generates the list who contains all the movable tiles
		LinkedList<TilePositionedMovable> tilesMovable = new LinkedList<TilePositionedMovable>();
		
		tilesMovable.add(new TilePositionedMovable(Tile.TILE2, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE4, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE6, Rotation.ROTATION1));
		
		tilesMovable.add(new TilePositionedMovable(Tile.TILE8, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE9, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE10, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE11, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE12, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE13, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE14, Rotation.ROTATION1));
		
		tilesMovable.add(new TilePositionedMovable(Tile.TILE16, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE18, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE20, Rotation.ROTATION1));
		
		tilesMovable.add(new TilePositionedMovable(Tile.TILE22, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE23, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE24, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE25, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE26, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE27, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE28, Rotation.ROTATION1));
		
		tilesMovable.add(new TilePositionedMovable(Tile.TILE30, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE32, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE34, Rotation.ROTATION1));
		
		tilesMovable.add(new TilePositionedMovable(Tile.TILE36, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE37, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE38, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE39, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE40, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE41, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE42, Rotation.ROTATION1));
		
		tilesMovable.add(new TilePositionedMovable(Tile.TILE44, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE46, Rotation.ROTATION1));
		tilesMovable.add(new TilePositionedMovable(Tile.TILE48, Rotation.ROTATION1));
		
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
