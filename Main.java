/**
 * @author Helvetin Perkeleet
 */
package Robotti_Tanel_i;

import lejos.hardware.Button;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {
	static IRSensor sensor;

	public static void main(String[] args) {
		sensor = new IRSensor();
		sensor.setDaemon(true);
		sensor.start();
		
		Behavior b1 = new Moottorit();
		Behavior[] behaviorList = { b1 };
		Arbitrator arbitrator = new Arbitrator(behaviorList);
		/**
		 * Behavior m‰‰ritt‰‰ mit‰ robotti tekee miss‰kin tilanteessa
		 * Arbitrator tekee n‰ist‰ listan ja priorisoi ne. 
		 * action() ja suppress() komennoilla liikutetaan Behavioreita listassa jossa arbitrator priorisoi ne.
		 * 
		 */
		
		
		Button.LEDPattern(4);
		/**
		 * T‰m‰ vilkuttaa robotin ledi‰.
		 */
		arbitrator.go();
		/**
		 * T‰m‰ pist‰‰ arbitratorin p‰‰lle.
		 */
	}
}