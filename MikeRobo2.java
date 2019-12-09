package wlv;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * MikeRobo1 - a robot by (your name here)
 */
public class MikeRobo2 extends AdvancedRobot
{
	/**
	 * run: MikeRobo1's default behavior
	 */
	String trackName;
	int count = 0;
	private byte moveDirection = 1;
	public void run() {
		// Initialization of the robot should be put here
		setAdjustGunForRobotTurn(true);
		//setAdjustRadarForGunTurn(true);

		double inf = Double.POSITIVE_INFINITY;
		setTurnGunRight(inf);
		execute();
		trackName = null;
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.white,Color.blue,Color.white);
		setBulletColor(Color.red);

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			count++;
			if (count > 5 && count < 11){
				setTurnGunLeft(inf);
			}
			if (count > 11){
				trackName = null;
			}
			if (trackName == null){
				setTurnGunRight(inf);
			}
			if (getVelocity() == 0){
				moveDirection *=-1;
			}
			setAhead(50 * moveDirection);
			execute();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		if (trackName == null){
			trackName = e.getName();
		}
		if (trackName == e.getName()) {
			if (getVelocity()!=0){
				setTurnRight(e.getBearing() + 90); 
			}
			if (e.getDistance() > 150){
				setAhead(e.getDistance()/2);
			}
			if (e.getDistance() < 100){
				setBack(e.getDistance()*2);
			}
			
			fire(Rules.MAX_BULLET_POWER);
			setTurnGunRight(getHeading() - getRadarHeading() + e.getBearing());
		}
	}
	public void onWin(WinEvent e) {
		for (int i = 0; i < 50; i++) {
			turnRight(30);
			turnLeft(30);
		}
	}
	public void onRobotDeath(RobotDeathEvent e){
		if (trackName == e.getName()) {
			trackName = null;
		}
		out.println("Bye " + e.getName());
	}
	public void onHitRobot(HitRobotEvent e){
		trackName = e.getName();
		setTurnGunRight(getHeading() - getRadarHeading() + e.getBearing());
		fire(Rules.MAX_BULLET_POWER);
	}
	
}
