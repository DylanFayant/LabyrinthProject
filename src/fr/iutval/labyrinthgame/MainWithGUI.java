package fr.iutval.labyrinthgame;
import java.io.IOException;

import fr.iutval.labyrinthgame.gui.MainWindow;


/**
 * Application that launches a Labyrinth game
 * @author Rachid Taghat - Dylan Fayant
 */
public class MainWithGUI {
	
	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		
		PlayerInput playerInput = new SimulatedPlayerInput();
		PlayerOutput playerOutput = new GUIPlayerOutput(new MainWindow());
		new LabyrinthGame(playerInput, playerOutput).play(); 
	}

}
