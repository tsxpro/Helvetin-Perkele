package Robotti_Tanel_i;

import java.io.File;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;

public class Moottorit implements Behavior {

	static RegulatedMotor leftMotor = Motor.D;
	static RegulatedMotor rightMotor = Motor.A;
	static RegulatedMotor puristin = Motor.B;
	static RegulatedMotor nostin = Motor.C;

	private boolean _suppressed = false;

	public boolean takeControl() {
		if (Button.readButtons() != 0) {
			_suppressed = true;
			leftMotor.stop();
			rightMotor.stop();
		}
		return true;
	}

	
	
	public void suppress() {
		_suppressed = true;
	}

	public void action() {
		_suppressed = false;

		
		while (!_suppressed) {
			leftMotor.synchronizeWith(new RegulatedMotor[] { rightMotor });

			leftMotor.startSynchronization();


			switch (Main.sensor.control) {
			
			case 0:
				leftMotor.stop();
				rightMotor.stop();
				nostin.stop();
				puristin.stop();
				if(Button.ESCAPE.isDown()) {
					System.exit(0);
				}
				
				break;

			case 1:
				leftMotor.setAcceleration(12000);
				rightMotor.setAcceleration(12000);
				leftMotor.setSpeed((int) leftMotor.getMaxSpeed());
				rightMotor.setSpeed((int) rightMotor.getMaxSpeed());
				leftMotor.backward();
				rightMotor.backward();

				break;

			case 2:
				leftMotor.setAcceleration(12000);
				rightMotor.setAcceleration(12000);
				leftMotor.setSpeed((int) leftMotor.getMaxSpeed());
				rightMotor.setSpeed((int) rightMotor.getMaxSpeed());
				leftMotor.forward();
				rightMotor.forward();

				break;

			case 3:
				leftMotor.setAcceleration(12000);
				leftMotor.setSpeed((int) leftMotor.getMaxSpeed());
				leftMotor.forward();
				break;

			case 4:
				rightMotor.setAcceleration(12000);
				rightMotor.setSpeed((int) rightMotor.getMaxSpeed());
				rightMotor.forward();
				break;

			case 5:
				puristin.setAcceleration(2000);
				nostin.setAcceleration(2000);
				puristin.setSpeed(200);
				nostin.setSpeed(200);
				puristin.rotate(55);
				nostin.rotate(-50);
				break;
				
			case 8:
				puristin.setAcceleration(2000);
				nostin.setAcceleration(2000);
				puristin.setSpeed(200);
				nostin.setSpeed(200);
				nostin.rotate(50);
				puristin.rotate(-55);

				break;
				
			case 9:
				File music = new File("musiikki2.wav");
				Sound.playSample(music, 100);
				
			case 10:
				leftMotor.setAcceleration(12000);
				rightMotor.setAcceleration(12000);
				leftMotor.setSpeed((int) leftMotor.getMaxSpeed());
				rightMotor.setSpeed((int) rightMotor.getMaxSpeed());
				leftMotor.backward();
				rightMotor.forward();

				break;

			case 11:
				leftMotor.setAcceleration(12000);
				rightMotor.setAcceleration(12000);
				leftMotor.setSpeed((int) leftMotor.getMaxSpeed());
				rightMotor.setSpeed((int) rightMotor.getMaxSpeed());
				leftMotor.forward();
				rightMotor.backward();
				break;

			}
			Thread.yield();
			leftMotor.endSynchronization();
		}

	}
}
//* 1 TOP-LEFT
//* 2 BOTTOM-LEFT
//* 3 TOP-RIGHT
//* 4 BOTTOM-RIGHT
//* 5 TOP-LEFT + TOP-RIGHT
//* 6 TOP-LEFT + BOTTOM-RIGHT
//* 7 BOTTOM-LEFT + TOP-RIGHT
//* 8 BOTTOM-LEFT + BOTTOM-RIGHT
//* 9 CENTRE/BEACON
//* 10 BOTTOM-LEFT + TOP-LEFT
//* 11 TOP-RIGHT + BOTTOM-RIGHT