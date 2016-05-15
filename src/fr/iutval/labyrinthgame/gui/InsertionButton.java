package fr.iutval.labyrinthgame.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

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
	private MainWindow mainWindow;
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
	public InsertionButton(int x, int y, MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
		this.x = x;
		this.y = y;
		this.addActionListener(this);
		InsertionButton.theButtons.add(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/*
		 * Creates the insertion
		 * Process the insertion (TODO: find a way to link to the input system...)
		 * Make the buttons disabled + the rotation of the free card
		 */
		this.mainWindow.bottomArea.theTile.setEnabled(false);
		for(InsertionButton button : InsertionButton.theButtons)
		{
			button.setEnabled(false);
		}
		SwingUtilities.updateComponentTreeUI(this.mainWindow);		
	}

}
