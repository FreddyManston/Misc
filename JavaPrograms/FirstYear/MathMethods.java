class Maths
{
	public static void main (String[] args)
	{
		double sin_angle = Math.sin(Math.PI/4);	// Assumes the the angle given is in radians
		int angle = 90;
		double angle_degrees = Math.sin(angle * (2*Math.PI) / 360.0);	

		System.out.print ("The sin of the angle in radians is: " + sin_angle + ".");
		System.out.println (" The sin of the angle in degrees is the same, i.e. " + angle_degrees + ".");

		double root = Math.sqrt(17);
		System.out.print ("The square root of 17 is: " + root);
		System.out.println (". Rounded off it is: " + Math.round(root));
	}
}
