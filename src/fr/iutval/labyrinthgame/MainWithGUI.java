package fr.iutval.labyrinthgame;


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

		PlayerInput playerInput[] = new PlayerInput[4];
		for(int playerNum = 0; playerNum < 4; playerNum++)
			playerInput[playerNum] = new GUIPlayer();
		
		PlayerOutput playerOutput[] = new PlayerOutput[4];
		for(int playerNum = 0; playerNum < 4; playerNum++)
			playerOutput[playerNum] = (PlayerOutput) playerInput[playerNum];

		new LabyrinthGame(playerInput, playerOutput).play(); 
	}

}
