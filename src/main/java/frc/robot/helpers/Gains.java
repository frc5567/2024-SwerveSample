package frc.robot.helpers;

/**
 *  Class that organizes gains used when assigning values to slots.
 *  This is sample code straight ripped from CTRE's examples, so thank you CTRE
 */
public class Gains {
    public final double kP;
	public final double kI;
	public final double kD;
    public final double kS;
    public final double kV;
	public final double kA;
	
	/**
     * Contructor for Gains objects
     * These objects store PID constants for easier reading in the RobotMap
     * @param _kP the proportionality constant. How much to change the value/power by
     * @param _kI the integral constant. Error between the current and desired value. Bumps the value/power to actually hit the target
     * @param _kD the derivative constant. The rate of change. It helps to dampen oscillation
     * @param _kV the feed-forward constant. The minimum amount of power needed to overcome inertia (to actually get us to move). Use characterization to find this
	 */
	public Gains(double _kP, double _kI, double _kD, double _kS, double _kV, double _kA){
		kP = _kP;
		kI = _kI;
		kD = _kD;
        kS = _kS;
		kV = _kV;
        kA = _kA;
    }
}
