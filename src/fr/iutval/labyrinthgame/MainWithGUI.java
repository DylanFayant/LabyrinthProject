package fr.iutval.labyrinthgame;

import java.io.IOException;

import fr.iutval.labyrinthgame.gameIO.GUIPlayer;
import fr.iutval.labyrinthgame.gameIO.InFilePlayerOutput;
import fr.iutval.labyrinthgame.gameIO.PlayerInput;
import fr.iutval.labyrinthgame.gameIO.PlayerOutput;
import fr.iutval.labyrinthgame.gameIO.SimulatedPlayerInput;

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
		/* Generates the game with 3 simulated players and 1 GUI player */
		
		PlayerInput playerInput[] = new PlayerInput[4];
		for(int playerNum = 0; playerNum < 3; playerNum++)
			playerInput[playerNum] = new SimulatedPlayerInput();
		playerInput[3] = new GUIPlayer();
		
		PlayerOutput playerOutput[] = new PlayerOutput[4];
		for(int playerNum = 0; playerNum < 3; playerNum++)
			try {
				playerOutput[playerNum] = new InFilePlayerOutput("log.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		playerOutput[3] = (PlayerOutput) playerInput[3];

		new LabyrinthGame(playerInput, playerOutput).play(); 
	}

}
