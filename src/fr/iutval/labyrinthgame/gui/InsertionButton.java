package fr.iutval.labyrinthgame.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import fr.iutval.labyrinthgame.GUIPlayer;
import fr.iutval.labyrinthgame.Insertion;
import fr.iutval.labyrinthgame.PositionInTheGameBoard;
import fr.iutval.labyrinthgame.Rotation;
import fr.iutval.labyrinthgame.exceptions.XisNotInGameboardException;
import fr.iutval.labyrinthgame.exceptions.YisNotInGameboardException;

/**
 * @author TODO
 *
 */
public class InsertionButton extends JButton implements ActionListener{
	/**
	 * 
	 */
	private int x;
	/**
	 * 
	 */
	private int y;
	/**
	 * 
	 */
	private GUIPlayer mainWindow;
	/**
	 * 
	 */
	public static List<InsertionButton> theButtons = new ArrayList<InsertionButton>();

	/**
	 * TODO
	 * @param x
	 * @param y
	 * @param mainWindow 
	 */
	public InsertionButton(int x, int y, GUIPlayer mainWindow) {
		super();
		this.mainWindow = mainWindow;
		this.x = x;
		this.y = y;
		this.addActionListener(this);
		InsertionButton.theButtons.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try
		{
			this.mainWindow.theInsertion = new Insertion(new PositionInTheGameBoard(this.x, this.y), Rotation.values()[this.mainWindow.bottomArea.tileRotation]);
		}
		catch (XisNotInGameboardException | YisNotInGameboardException e)
		{
			// TODO
		}
	}

}
