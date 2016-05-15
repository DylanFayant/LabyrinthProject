import java.io.IOException;

import ihm.MainWindow;


/**
 * Application that launches a Labyrinth game
 * @author Rachid Taghat - Dylan Fayant
 */
public class Main {
	
	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {
		new MainWindow();
		
		PlayerInput playerInput = new SimulatedPlayerInput();
		PlayerOutput playerOutput = null;
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
