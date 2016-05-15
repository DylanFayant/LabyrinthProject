package ihm;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.iutval.labyrinthgame.GameBoard;

/**
 * @author TODO
 *
 */
public class TopArea extends JPanel {

	private MainWindow mainWindow;

	/**
	 * @param mainWindow
	 */
	public TopArea(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		GridLayout layout = new GridLayout(GameBoard.WIDTH+2, GameBoard.HEIGHT+2);
		this.setLayout(layout);
		
		this.setVisible(true);
	}
	
	/**
	 * @param gameBoard
	 */
	public void loadGameBoard(GameBoard gameBoard) {
		this.removeAll();
		for(int i = 0; i < GameBoard.WIDTH; i++)
		{
			for(int j = 0; j < GameBoard.HEIGHT; j++)
			{
				JButton button = new JButton(new ImageIcon("img/"+gameBoard.getGameBoard()[i][j]+".png"));
			}			
		}

		SwingUtilities.updateComponentTreeUI(this);
	}

}
