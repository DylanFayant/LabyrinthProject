package fr.iutval.labyrinthgame;
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
		MainWindow theWindow = new MainWindow();
		PlayerInput playerInput = new SimulatedPlayerInput();
		PlayerOutput playerOutput = new GUIPlayerOutput(theWindow);
		new LabyrinthGame(playerInput, playerOutput).play(); 
	}

}
