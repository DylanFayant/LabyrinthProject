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
import fr.iutval.labyrinthgame.PositionInTheGameBoard;
import fr.iutval.labyrinthgame.exceptions.XisNotInGameboardException;
import fr.iutval.labyrinthgame.exceptions.YisNotInGameboardException;

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
					PanelImage panel = new PanelImage("img/"+(gameBoard.getGameBoard()[j-1][i-1]).getLink()+".png");
					
					PositionInTheGameBoard currentPosition = null;
					try {
						currentPosition = new PositionInTheGameBoard(j-1, i-1);
					} catch (XisNotInGameboardException | YisNotInGameboardException e) {
						// impossible
					}
					if(gameBoard.getPawns().containsValue(currentPosition))
					{
						if(gameBoard.getPawns().get(0).equals(currentPosition))
							panel.paintComponent("img/player0.png");
						if(gameBoard.getPawns().get(1).equals(currentPosition))
							panel.paintComponent("img/player1.png");
						if(gameBoard.getPawns().get(2).equals(currentPosition))
							panel.paintComponent("img/player2.png");
						if(gameBoard.getPawns().get(3).equals(currentPosition))
							panel.paintComponent("img/player3.png");
					}
					
					this.add(panel);
				}
			}
			
		}

		SwingUtilities.updateComponentTreeUI(this);
	}

}
