package fr.iutval.labyrinthgame;
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
		System.out.println(Tile.TILE1);
		System.out.println(Tile.TILE2);
		System.out.println(Tile.TILE3);
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
