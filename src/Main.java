
/**
 * Labyrinth main class who represent the application
 * @author Rachid Taghat - Dylan Fayant
 */
public class Main {
	
	/**
	 * The main method of the Main is the beggining of the application.
	 * It's used to lunch the LabyrinthGame class.
	 * @param args
	 */
	public static void main(String[] args) {
		new LabyrinthGame().play(); // The unique line in this method is used to load a gameplay (initialise it) and start it (do the play)
	}

}
