
/**
 * Represents an insertion (a tile, a position X Y, a direction).
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public class Insertion
{
	/**
	 * A position of insertion in a border of the map
	 */
	private final PositionInTheGameBoard aPosition;
	
	/**
	 * A rotation for the inserted tile
	 */
	private final Rotation aRotation;
	
	/**
	 * Generates an insertion with a position and a rotation
	 * @param position
	 * @param rotation
	 */
	public Insertion(PositionInTheGameBoard position, Rotation rotation)
	{
		this.aPosition = position;
		this.aRotation = rotation;
	}
	
	/**
	 * Generates a random insertion with a position and a rotation
	 * @param position
	 * @param rotation
	 */
	public Insertion()
	{
		this.aPosition = new PositionInTheGameBoard();
		this.aRotation = Rotation.getRandomRotation();
	}

	/**
	 * Returns the current obect's position
	 * @return position
	 */
	public PositionInTheGameBoard getaPosition() {
		return this.aPosition;
	}

	/**
	 * Returns the current obect's rotation
	 * @return rotation
	 */
	public Rotation getaRotation() {
		return this.aRotation;
	}
}
