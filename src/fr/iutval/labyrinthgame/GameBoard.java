package fr.iutval.labyrinthgame;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import fr.iutval.labyrinthgame.exceptions.InvalidInsertionException;
import fr.iutval.labyrinthgame.exceptions.InvalidMoveException;
import fr.iutval.labyrinthgame.exceptions.XisNotInGameboardException;
import fr.iutval.labyrinthgame.exceptions.YisNotInGameboardException;

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
	public static final int HEIGHT = 7;
	
	/**
	 * Table containing the tiles
	 */
	TilePositioned[][] gameBoard;

	/**
	 * HashMap containing the players pawns
	 */
	Map<Integer, PositionInTheGameBoard> pawns;
	
	/**
	 * Creates and generates a HashMap who contains all the tiles fixed and their positions
	 */
	private final static HashMap<PositionInTheGameBoard, TilePositionedFixed> tilesFixed = new HashMap<PositionInTheGameBoard, TilePositionedFixed>();
	static {
		try
		{
			tilesFixed.put(new PositionInTheGameBoard(0, 0), new TilePositionedFixed(Tile.TILE1, Rotation.ROTATION2));
			tilesFixed.put(new PositionInTheGameBoard(2, 0), new TilePositionedFixed(Tile.TILE3, Rotation.ROTATION1));
			tilesFixed.put(new PositionInTheGameBoard(4, 0), new TilePositionedFixed(Tile.TILE5, Rotation.ROTATION1));
			tilesFixed.put(new PositionInTheGameBoard(6, 0), new TilePositionedFixed(Tile.TILE7, Rotation.ROTATION3));

			tilesFixed.put(new PositionInTheGameBoard(0, 2), new TilePositionedFixed(Tile.TILE15, Rotation.ROTATION4));
			tilesFixed.put(new PositionInTheGameBoard(2, 2), new TilePositionedFixed(Tile.TILE17, Rotation.ROTATION4));
			tilesFixed.put(new PositionInTheGameBoard(4, 2), new TilePositionedFixed(Tile.TILE19, Rotation.ROTATION1));
			tilesFixed.put(new PositionInTheGameBoard(6, 2), new TilePositionedFixed(Tile.TILE21, Rotation.ROTATION2));

			tilesFixed.put(new PositionInTheGameBoard(0, 4), new TilePositionedFixed(Tile.TILE29, Rotation.ROTATION4));
			tilesFixed.put(new PositionInTheGameBoard(2, 4), new TilePositionedFixed(Tile.TILE31, Rotation.ROTATION3));
			tilesFixed.put(new PositionInTheGameBoard(4, 4), new TilePositionedFixed(Tile.TILE33, Rotation.ROTATION2));
			tilesFixed.put(new PositionInTheGameBoard(6, 4), new TilePositionedFixed(Tile.TILE35, Rotation.ROTATION2));

			tilesFixed.put(new PositionInTheGameBoard(0, 6), new TilePositionedFixed(Tile.TILE43, Rotation.ROTATION1));
			tilesFixed.put(new PositionInTheGameBoard(2, 6), new TilePositionedFixed(Tile.TILE45, Rotation.ROTATION3));
			tilesFixed.put(new PositionInTheGameBoard(4, 6), new TilePositionedFixed(Tile.TILE47, Rotation.ROTATION3));
			tilesFixed.put(new PositionInTheGameBoard(6, 6), new TilePositionedFixed(Tile.TILE49, Rotation.ROTATION4));
		}
		catch (XisNotInGameboardException | YisNotInGameboardException e)
		{
			// never happens
		}
	}
	
	/**
	 * The free tile (not in game)
	 */
	private Tile freeTile;
	
	/**
	 * Create a new gameboard with randomly placed mobile cards and players pawns placed to the corners
	 * @param playersId the players ids
	 */
	public GameBoard(int playersId[]) {
		// Initialization 
		this.pawns = new HashMap<Integer, PositionInTheGameBoard>();
		this.gameBoard = new TilePositioned[GameBoard.WIDTH][GameBoard.HEIGHT];
		this.freeTile = Tile.TILE50;
		
		// Make the list of the movable tiles
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
		
		// For all the cells in the array, we put the good tile (the fixed or a random tile)
		for(int i = 0; i < GameBoard.WIDTH; i++)
		{
			for(int j = 0; j < GameBoard.HEIGHT; j++)
			{
				try
				{
					if(tilesFixed.containsKey(new PositionInTheGameBoard(j, i)))
					{
						this.gameBoard[j][i] = tilesFixed.get(new PositionInTheGameBoard(j, i));
					}
					else
					{
						Rotation aRotation = theRotations[(int)(Math.random()*theRotations.length)];
						TilePositionedMovable aTile = tilesMovable.removeFirst();
						aTile.setRotation(aRotation);
						this.gameBoard[j][i] = aTile;
					}
				}
				catch (XisNotInGameboardException | YisNotInGameboardException e)
				{
					// never happens
				}
			}
		}
		
		// save the pawns positions
		try
		{
			this.pawns.put(playersId[0], new PositionInTheGameBoard(0,0));
			this.pawns.put(playersId[1], new PositionInTheGameBoard(0,GameBoard.WIDTH-1));
			this.pawns.put(playersId[2], new PositionInTheGameBoard(GameBoard.HEIGHT-1,0));
			this.pawns.put(playersId[3], new PositionInTheGameBoard(GameBoard.HEIGHT-1,GameBoard.WIDTH-1));
		}
		catch (XisNotInGameboardException | YisNotInGameboardException e)
		{
			// never happens
		}
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
		
		// The insertion must be in a movable tile
		if(this.gameBoard[newInsertion.getaPosition().getX()][newInsertion.getaPosition().getY()].isFixed()) throw new InvalidInsertionException();
		
		this.freeTile = this.slidesAndInsert(newInsertion, this.freeTile);
	}
	
	/**
	 * Slides the tiles in the table for an insertion
	 * @param insertion an Insertion (Position, Rotation)
	 * @param freeTile the old free tile
	 * @return the new free tile
	 */
	private Tile slidesAndInsert(Insertion newInsertion, Tile freeTile)
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
	 * @param playerId 
	 * @throws InvalidMoveException 
	 */
	public void processMoving(Movement newMove, int playerId) throws InvalidMoveException
	{
		/*
		 * We have a list of moves
		 * We must verify if each move is possible
		 * if one of theme is not possible => InvalidMoveException
		 * if they are all possible => Moves to the last position of the Movement 
		 */
		Iterator<PositionInTheGameBoard> moveIterator = newMove.getMovement().iterator();
		PositionInTheGameBoard provisionalStep = moveIterator.next();
		while(moveIterator.hasNext())
		{
			PositionInTheGameBoard previousPosition = provisionalStep;
			PositionInTheGameBoard nextPosition = moveIterator.next();
			if(!this.moveIsValid(previousPosition, nextPosition)) throw new InvalidMoveException();
			provisionalStep = nextPosition;
		}
		this.pawns.replace(playerId, newMove.getMovement().get(newMove.getMovement().size()-1));
	}
	
	/**
	 * Check if the move is valid
	 * @param previousPosition PositionInTheGameBoard
	 * @param nextPosition PositionInTheGameBoard
	 * @return boolean
	 */
	private boolean moveIsValid(PositionInTheGameBoard previousPosition, PositionInTheGameBoard nextPosition) {
		// Make the differences between the new and the old position (to know the direction of the move)
		int xMove = nextPosition.getX()-previousPosition.getX();
		int yMove = nextPosition.getY()-previousPosition.getY();
		
		// Get information about the tile in the old position
		TilePositioned previousTilePositioned = this.gameBoard[previousPosition.getX()][previousPosition.getY()];
		Rotation previousTileRotation = previousTilePositioned.getRotation();
		Tile previousTile = previousTilePositioned.getTile();
		
		// Get information about the tile in the new position
		TilePositioned nextTilePositioned = this.gameBoard[nextPosition.getX()][nextPosition.getY()];
		Rotation nextTileRotation = nextTilePositioned.getRotation();
		Tile nextTile = nextTilePositioned.getTile();
		
		boolean moveIsValid = false;
		
		if(xMove == 1) // right move
		{
			if(this.rightWay(previousTile, previousTileRotation) && this.leftWay(nextTile, nextTileRotation))
				moveIsValid = true;
		}
		if(xMove == -1) // left move
		{
			if(this.leftWay(previousTile, previousTileRotation) && this.rightWay(nextTile, nextTileRotation))
				moveIsValid = true;
		}
		if(yMove == 1) // down move
		{
			if(this.downWay(previousTile, previousTileRotation) && this.upWay(nextTile, nextTileRotation))
				moveIsValid = true;
		}
		if(yMove == -1) // up move
		{
			if(this.upWay(previousTile, previousTileRotation) && this.downWay(nextTile, nextTileRotation))
				moveIsValid = true;
		}
		
		return moveIsValid;
	}
	
	/**
	 * Check if the way is available to the up of the tile
	 * @param tile
	 * @param tileRotation
	 * @return boolean
	 */
	private boolean upWay(Tile tile, Rotation tileRotation) {
		if(tile.getTileType() == TileType.I && tileRotation == Rotation.ROTATION2)
			return false;
		if(tile.getTileType() == TileType.I && tileRotation == Rotation.ROTATION4)
			return false;
		if(tile.getTileType() == TileType.L && tileRotation == Rotation.ROTATION2)
			return false;
		if(tile.getTileType() == TileType.L && tileRotation == Rotation.ROTATION3)
			return false;
		if(tile.getTileType() == TileType.T && tileRotation == Rotation.ROTATION1)
			return false;
		return true;
	}
	
	/**
	 * Check if the way is available to the down of the tile
	 * @param previousTile
	 * @param previousTileRotation
	 * @return boolean
	 */
	private boolean downWay(Tile tile, Rotation tileRotation) {
		if(tile.getTileType() == TileType.I && tileRotation == Rotation.ROTATION2)
			return false;
		if(tile.getTileType() == TileType.I && tileRotation == Rotation.ROTATION4)
			return false;
		if(tile.getTileType() == TileType.L && tileRotation == Rotation.ROTATION1)
			return false;
		if(tile.getTileType() == TileType.L && tileRotation == Rotation.ROTATION4)
			return false;
		if(tile.getTileType() == TileType.T && tileRotation == Rotation.ROTATION3)
			return false;
		return true;
	}
	
	/**
	 * Check if the way is available to the left of the tile
	 * @param previousTile
	 * @param previousTileRotation
	 * @return boolean
	 */
	private boolean leftWay(Tile tile, Rotation tileRotation) {
		if(tile.getTileType() == TileType.I && tileRotation == Rotation.ROTATION1)
			return false;
		if(tile.getTileType() == TileType.I && tileRotation == Rotation.ROTATION3)
			return false;
		if(tile.getTileType() == TileType.L && tileRotation == Rotation.ROTATION1)
			return false;
		if(tile.getTileType() == TileType.L && tileRotation == Rotation.ROTATION2)
			return false;
		if(tile.getTileType() == TileType.T && tileRotation == Rotation.ROTATION4)
			return false;
		return true;
	}
	
	/**
	 * Check if the way is available to the right of the tile
	 * @param previousTile
	 * @param previousTileRotation
	 * @return boolean
	 */
	private boolean rightWay(Tile tile, Rotation tileRotation) {
		if(tile.getTileType() == TileType.I && tileRotation == Rotation.ROTATION1)
			return false;
		if(tile.getTileType() == TileType.I && tileRotation == Rotation.ROTATION3)
			return false;
		if(tile.getTileType() == TileType.L && tileRotation == Rotation.ROTATION3)
			return false;
		if(tile.getTileType() == TileType.L && tileRotation == Rotation.ROTATION4)
			return false;
		if(tile.getTileType() == TileType.T && tileRotation == Rotation.ROTATION2)
			return false;
		return true;
	}
	
	/**
	 * Get the treasure in the tile where the player is placed
	 * @param playerId
	 * @return Treasure
	 */
	public Treasure treasureInPlayerTile(int playerId)
	{
		return this.gameBoard[this.pawns.get(playerId).getX()][this.pawns.get(playerId).getY()].getTile().getTreasure();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String aString = "";
		for(int i = 0; i < GameBoard.WIDTH; i++)
		{
			for(int j = 0; j < GameBoard.HEIGHT; j++)
			{
				try {
					String allPlayers = "";
					if(this.pawns.containsValue(new PositionInTheGameBoard(j, i)))
					{
						for(int players = 0; players < this.pawns.size(); players++) 
						{							
							if(this.pawns.get(players).equals(new PositionInTheGameBoard(j, i)))
							{
								allPlayers += players + ",";
							}
						}
					}
					if(allPlayers == "")
						aString += this.gameBoard[j][i].toString();
					else
						aString += this.gameBoard[j][i].toString(allPlayers);
				} catch (XisNotInGameboardException | YisNotInGameboardException e) {
					// never happens
				}
			}
			aString += "\n";
		}
		return aString;
	}
	
	/**
	 * Returns the gameboard
	 * @return gameBoard
	 */
	public TilePositioned[][] getGameBoard() {
		return this.gameBoard;
	}

	/**
	 * Returns the pawns
	 * @return pawns
	 */
	public Map<Integer, PositionInTheGameBoard> getPawns() {
		return this.pawns;
	}

	/**
	 * Returns the free tile
	 * @return freeTile
	 */
	public Tile getFreeTile() {
		return this.freeTile;
	}

}
