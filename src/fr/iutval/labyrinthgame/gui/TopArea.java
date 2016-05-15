package fr.iutval.labyrinthgame.gui;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	@SuppressWarnings("deprecation")
	public void loadGameBoard(GameBoard gameBoard) {
		this.removeAll();
		InsertionButton.theButtons = new ArrayList<InsertionButton>();
		
		GridLayout layout = new GridLayout(GameBoard.WIDTH+2, GameBoard.HEIGHT+2);
		this.setLayout(layout);
		
		for(int i = 0; i < GameBoard.HEIGHT+2; i++)
		{
			for(int j = 0; j < GameBoard.WIDTH+2; j++)
			{
				InsertionButton button = new InsertionButton(j, i, this.mainWindow);
				if(i == 0 || i == GameBoard.HEIGHT+1)
				{
					if(j == 0 || j == GameBoard.HEIGHT+1)
						this.add(new JPanel());
					else if(j%2 != 0)
						this.add(new JPanel());
					else
						this.add(button);
				}
				else if(j == 0 || j == GameBoard.WIDTH+1)
				{
					if(i == 0 || i == GameBoard.WIDTH+1)
						this.add(new JPanel());
					else if(i%2 != 0)
						this.add(new JPanel());
					else
						this.add(button);
				}
				else
				{
					JPanel panel = new JPanel();
					JLabel picLabel = new JLabel(new ImageIcon("img/"+(gameBoard.getGameBoard()[i-1][j-1]).getLink()+".png"));
					panel.add(picLabel);
					this.add(panel);
				}
			}
			
		}

		SwingUtilities.updateComponentTreeUI(this);
	}

}
