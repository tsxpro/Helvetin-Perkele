package Robotti_Tanel_i;

import java.io.File;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;

public class Main {

	static IRSensor sensor;

	public static void main(String[] args) {
		File music = new File("MUSIIKKII.wav");
		Sound.playSample(music, 100);
		Sound.setVolume(100);

		sensor = new IRSensor();
		sensor.setDaemon(true);
		sensor.start();
		Behavior b1 = new Moottorit();
		Behavior[] behaviorList = { b1 };
		Arbitrator arbitrator = new Arbitrator(behaviorList);
		Button.LEDPattern(4);
		arbitrator.go();

	}
}