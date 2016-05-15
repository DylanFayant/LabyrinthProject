package fr.iutval.labyrinthgame;
import java.io.IOException;

import ihm.MainWindow;


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
		PlayerOutput playerOutput = new GUIPlayerOutput();
		try
		{
			playerOutput = new InFilePlayerOutput("log.txt");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		new LabyrinthGame(playerInput, playerOutput).play(); 
	}

}
