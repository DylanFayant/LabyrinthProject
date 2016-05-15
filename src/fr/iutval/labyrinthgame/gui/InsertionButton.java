package fr.iutval.labyrinthgame.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
	 * @param x
	 * @param y
	 */
	public InsertionButton(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 
		
		/*
		 * Creates the insertion
		 * Process the insertion
		 * Make the buttons disabled + the rotation of the free card
		 */
		
	}

}
