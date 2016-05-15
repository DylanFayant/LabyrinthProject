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
		// TODO Auto-generated method stub

	}

	@Override
	public void playerHasChanged(Player currentPlayer) {
		// TODO Auto-generated method stub

	}

}
