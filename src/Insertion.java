
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
	private final Position aPosition;
	
	/**
	 * A rotation for the inserted tile
	 */
	private final Rotation aRotation;
	
	/**
	 * Generates an insertion with a position (in a valid border of the map) and a rotation
	 * @param position
	 * @param rotation
	 */
	public Insertion(Position position, Rotation rotation)
	{
		this.aPosition = position;
		this.aRotation = rotation;
	}

	/**
	 * Returns the current obect's position
	 * @return position
	 */
	public Position getaPosition() {
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
