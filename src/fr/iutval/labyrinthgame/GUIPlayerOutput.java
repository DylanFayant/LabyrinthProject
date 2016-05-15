package fr.iutval.labyrinthgame;

import fr.iutval.labyrinthgame.gui.MainWindow;

/**
 * @author TODO
 *
 */
public class GUIPlayerOutput implements PlayerOutput {
	
	/**
	 * 
	 */
	private MainWindow mainWindow;
	
	/**
	 * @param mainWindow
	 */
	public GUIPlayerOutput(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void gameBoardUpdate(GameBoard gameBoard) {
		this.mainWindow.topArea.loadGameBoard(gameBoard);
	}

	@Override
	public void gameIsOver(int playerIds) {
		// TODO

	}

	@Override
	public void playerHasChanged(int playerId, Tile freeCard, Treasure searchedTreasure) {
		this.mainWindow.bottomArea.refreshBottomArea(playerId, freeCard, searchedTreasure);
	}

}
