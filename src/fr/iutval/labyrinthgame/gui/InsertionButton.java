package fr.iutval.labyrinthgame.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import fr.iutval.labyrinthgame.Insertion;
import fr.iutval.labyrinthgame.PositionInTheGameBoard;
import fr.iutval.labyrinthgame.Rotation;
import fr.iutval.labyrinthgame.exceptions.PositionIsNotInGameboardException;
import fr.iutval.labyrinthgame.gameIO.GUIPlayer;

/**
 * Represents the button for insertion
 * @author Rachid Taghat - Dylan Fayant
 */
@SuppressWarnings("serial")
public class InsertionButton extends JButton implements ActionListener{
	/**
	 * x position for the insertion
	 */
	private int x;
	/**
	 * y position for the insertion
	 */
	private int y;
	/**
	 * save the reference to the main window
	 */
	private GUIPlayer mainWindow;
	/**
	 * The button's name
	 */
	@SuppressWarnings("unused")
	private String name;

	/**
	 * Generates the button with coordinate informations saved
	 * @param name 
	 * @param x
	 * @param y
	 * @param mainWindow 
	 */
	public InsertionButton(String name, int x, int y, GUIPlayer mainWindow) {
		super(name);
		this.mainWindow = mainWindow;
		this.x = x;
		this.y = y;
		this.addActionListener(this);
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		try
		{
			// returns the insertion selected by the player in the main window 
			this.mainWindow.theInsertion = new Insertion(new PositionInTheGameBoard(this.x, this.y), Rotation.values()[this.mainWindow.bottomArea.tileRotation/90]);
		}
		catch (PositionIsNotInGameboardException e)
		{
			// impossible
		}
	}

}
