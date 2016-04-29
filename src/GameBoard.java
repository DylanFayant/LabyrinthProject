import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
	 * HashMap containing the players pawns
	 */
	Map<Player, Position> pawns = new HashMap<Player, Position>();
	
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
	 * @param players The players list
	 */
	public GameBoard(Player players[]) {
		this.gameBoard = new TilePositioned[GameBoard.WIDTH][GameBoard.HEIGHT];
		
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
		
		Collections.shuffle(tilesMovable);
		Rotation[] theRotations = Rotation.values();
		
		for(int i = 0; i < GameBoard.WIDTH; i++)
		{
			for(int j = 0; j < GameBoard.HEIGHT; j++)
			{
				if(tilesFixed.containsKey(new Position(j, i)))
				{
					this.gameBoard[j][i] = tilesFixed.get(new Position(j, i));
				}
				else
				{
					Rotation aRotation = theRotations[(int)(Math.random()*theRotations.length)];
					TilePositionedMovable aTile = tilesMovable.removeFirst();
					aTile.setRotation(aRotation);
					this.gameBoard[j][i] = aTile;
				}
				System.out.print(this.gameBoard[j][i].toString());
			}
			System.out.println();
		}
		
		// save the pawns positions
		this.pawns.put(players[0], new Position(0,0));
		this.pawns.put(players[1], new Position(0,GameBoard.WIDTH));
		this.pawns.put(players[2], new Position(GameBoard.HEIGHT,0));
		this.pawns.put(players[3], new Position(GameBoard.HEIGHT,GameBoard.WIDTH));
	}

	/**
	 * Process the insertion into the gameboard.
	 * @param newInsertion an insertion
	 * @throws InvalidInsertionException 
	 */
	public void processInsertion(Insertion newInsertion) throws InvalidInsertionException
	{
		// The insertion must be in the border of the map
		if(newInsertion.getaPosition().getX() != 0 && 
				   newInsertion.getaPosition().getX() != GameBoard.WIDTH-1 &&
				   newInsertion.getaPosition().getY() != 0 && 
				   newInsertion.getaPosition().getY() != GameBoard.HEIGHT-1) throw new InvalidInsertionException();
		
		// The insertion must be in the map
		if(newInsertion.getaPosition().getX() < 0 && 
				   newInsertion.getaPosition().getX() >= GameBoard.WIDTH &&
				   newInsertion.getaPosition().getY() < 0 && 
				   newInsertion.getaPosition().getY() >= GameBoard.HEIGHT) throw new InvalidInsertionException();
		
		// The insertion must be in a tile movable
		if(this.gameBoard[newInsertion.getaPosition().getX()][newInsertion.getaPosition().getY()].isFixed()) throw new InvalidInsertionException();
		
		this.freeTile = this.slideForInsertion(newInsertion, this.freeTile);
	}
	
	/**
	 * Slides the tiles in the table for an insertion
	 * @param insertion an Insertion (Position, Rotation)
	 * @param freeTile the old free tile
	 * @return the new free tile
	 */
	private Tile slideForInsertion(Insertion newInsertion, Tile freeTile)
	{
		/**
		 * The new Free Tile
		 */
		Tile exitTile = null;
		
		if(newInsertion.getaPosition().getX() == GameBoard.WIDTH-1 || newInsertion.getaPosition().getX() == 0)
		{
			exitTile = this.lineSlideForInsertion(newInsertion);
		} 
		else if(newInsertion.getaPosition().getY() == GameBoard.HEIGHT-1 || newInsertion.getaPosition().getY() == 0)
		{
			exitTile = this.columnSlideForInsertion(newInsertion);
		}
		
		// Process the insertion of the old free tile
		this.gameBoard[newInsertion.getaPosition().getX()][newInsertion.getaPosition().getY()] = new TilePositionedMovable(freeTile, newInsertion.getaRotation());	

		return exitTile;
	}
	
	/**
	 * Proceed the line' slide for the insertion 
	 * @param newInsertion the insertion
	 * @return the new free tile
	 */
	private Tile lineSlideForInsertion(Insertion newInsertion)
	{
		if(newInsertion.getaPosition().getX() == 0)
			return this.leftLineSlideForInsertion(newInsertion);
		return this.rightLineSlideForInsertion(newInsertion);
	}
	
	/**
	 * Proceed the line' slide from the left for the insertion
	 * @param newInsertion the insertion
	 * @return the new free tile
	 */
	private Tile leftLineSlideForInsertion(Insertion newInsertion)
	{
		Tile newFreeTile = this.gameBoard[GameBoard.WIDTH-1][newInsertion.getaPosition().getY()].getTile();
		for(int i = GameBoard.WIDTH-2; i >= 0; i--)
		{
			this.gameBoard[i+1][newInsertion.getaPosition().getY()] = this.gameBoard[i][newInsertion.getaPosition().getY()];
		}
		return newFreeTile;
	}
	
	/**
	 * Proceed the line' slide from the right for the insertion
	 * @param newInsertion the insertion
	 * @return the new free tile
	 */
	private Tile rightLineSlideForInsertion(Insertion newInsertion)
	{
		Tile newFreeTile = this.gameBoard[0][newInsertion.getaPosition().getY()].getTile();
		for(int i = 1; i < GameBoard.WIDTH; i++)
		{
			this.gameBoard[i-1][newInsertion.getaPosition().getY()] = this.gameBoard[i][newInsertion.getaPosition().getY()];
		}
		return newFreeTile;
	}
	
	/**
	 * Proceed the column' slide for the insertion 
	 * @param newInsertion the insertion
	 * @return the new free tile
	 */
	private Tile columnSlideForInsertion(Insertion newInsertion)
	{
		if(newInsertion.getaPosition().getY() == 0)
			return this.topColumnSlideForInsertion(newInsertion);
		return this.bottomColumnSlideForInsertion(newInsertion);
	}
	
	/**
	 * Proceed the column' slide from the top for the insertion
	 * @param newInsertion the insertion
	 * @return the new free tile
	 */
	private Tile topColumnSlideForInsertion(Insertion newInsertion)
	{
		Tile newFreeTile = this.gameBoard[newInsertion.getaPosition().getX()][GameBoard.HEIGHT-1].getTile();
		for(int i = GameBoard.HEIGHT-2; i >= 0; i--)
		{
			this.gameBoard[newInsertion.getaPosition().getX()][i+1] = this.gameBoard[newInsertion.getaPosition().getX()][i];
		}
		return newFreeTile;
	}
	
	/**
	 * Proceed the column' slide from the bottom for the insertion
	 * @param newInsertion the insertion
	 * @return the new free tile
	 */
	private Tile bottomColumnSlideForInsertion(Insertion newInsertion)
	{
		Tile newFreeTile = this.gameBoard[newInsertion.getaPosition().getX()][0].getTile();
		for(int i = 1; i < GameBoard.HEIGHT; i++)
		{
			this.gameBoard[newInsertion.getaPosition().getX()][i-1] = this.gameBoard[newInsertion.getaPosition().getX()][i];
		}
		return newFreeTile;
	}

	/**
	 * Process the player's moving.
	 * @param newMove a move.
	 * @throws InvalidMoveException 
	 */
	public void processMoving(Position newMove) throws InvalidMoveException
	{
		// TODO
	}

}
