// TODO (done) update README.md (what/who)

/**
 * Labyrinth main class who represent the application
 * @author Rachid Taghat - Dylan Fayant
 */
public class Main {
	
	// TODO (done) fix comment (what is the purpose of args?)
	/**
	 * The main method of the Main class is the begining of the application.
	 * It's used to lunch the LabyrinthGame class.
	 * @param args The application's arguments passed in parameters to debug.
	 */
	public static void main(String[] args) {
		new LabyrinthGame().play(); // The unique line in this method is used to load a gameplay (initialise it) and start it (do the play)
	}

}
