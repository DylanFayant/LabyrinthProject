package fr.iutval.labyrinthgame;
import java.io.IOException;

import fr.iutval.labyrinthgame.gameIO.InFilePlayerOutput;
import fr.iutval.labyrinthgame.gameIO.PlayerInput;
import fr.iutval.labyrinthgame.gameIO.PlayerOutput;
import fr.iutval.labyrinthgame.gameIO.SimulatedPlayerInput;


/**
 * Application that launches a Labyrinth game
 * @author Rachid Taghat - Dylan Fayant
 */
public class MainSimulated {
	
	/**
	 * Application's main
	 * @param args command-line arguments (unused)
	 */
	public static void main(String[] args) {		
		PlayerInput playerInput[] = new SimulatedPlayerInput[4];
		for(int playerNum = 0; playerNum < 4; playerNum++)
			playerInput[playerNum] = new SimulatedPlayerInput();
		
		PlayerOutput playerOutput[] = new InFilePlayerOutput[4];
		try
		{
			for(int playerNum = 0; playerNum < 4; playerNum++)
				playerOutput[playerNum] = new InFilePlayerOutput("logPlayer" + playerNum + ".txt");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		new LabyrinthGame(playerInput, playerOutput).play(); 
	}

}
