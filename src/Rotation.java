
/**
 * The enum of the rotations available
 * @author Rachid Taghat - Dylan Fayant
 *
 */
public enum Rotation
{
	ROTATION1(0),
	ROTATION2(90),
	ROTATION3(180),
	ROTATION4(270);
	
	/**
	 * The rotation in degree of the tile (0 = the tile is in the position of the letter T or I or L)
	 */
	private int rotation;
	
	/**
	 * Generate a rotation
	 * @param rotation0 the rotation in degree
	 */
	private Rotation(int rotation0)
	{
		this.rotation = rotation0;
	}
	
	/**
	 * Returns the rotation of the enum
	 * @return rotation an integer rotation
	 */
	public int getRotation()
	{
		return this.rotation;
	}

}
