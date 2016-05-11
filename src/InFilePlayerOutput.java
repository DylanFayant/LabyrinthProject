import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


/**
 * Represents a simulated player input
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class InFilePlayerOutput implements PlayerOutput
{
	/**
	 * Representation of the output file
	 */
	private File logFile;
	/**
	 * Representation of the file output stream
	 */
	private FileOutputStream logs;
	/**
	 * Reference of the print stream object
	 */
	private PrintStream logsStream;

	/**
	 * Generates an InFile player output
	 * @param fileName String
	 * @throws IOException 
	 */
	public InFilePlayerOutput(String fileName) throws IOException
	{
		this.logFile = new File(fileName);
		
		if(this.logFile.exists())
			this.logFile.delete();
		
		this.logFile.createNewFile();
		
		this.logs = null;
		try {
			this.logs = new FileOutputStream(this.logFile, true);
		} catch (FileNotFoundException e1) {
			// impossible
		}
		
		this.logsStream = new PrintStream(this.logs);
	}
	/**
	 * @see PlayerOutput#gameBoardUpdate(java.lang.String)
	 */
	public void gameBoardUpdate(GameBoard gameBoard)
	{
		this.logsStream.println(gameBoard.toString());
	}

	/**
	 * @see PlayerOutput#gameIsOver(java.lang.String)
	 */
	public void gameIsOver(int playerId)
	{
		this.logsStream.println("Game is over !");
		this.logsStream.println("Winner: " + playerId);
	}
}
