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
	
	public void run() {
		// Initialization of the robot should be put here
		//setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		
		double inf = Double.POSITIVE_INFINITY;
		setTurnRadarRight(inf);
		execute();
		trackName = null;
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.white,Color.blue,Color.white);
		setBulletColor(Color.red);

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(75);
			turnRight(20);
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
			setTurnRight(e.getBearing());
			if (e.getDistance() > 50){
				setAhead(e.getDistance()/2);
			}
			if (e.getDistance() < 10){
				setBack(e.getDistance()*2);
			}
			fire(Rules.MAX_BULLET_POWER);
			setTurnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(50);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(50);
		turnLeft(50);
	}	
}
