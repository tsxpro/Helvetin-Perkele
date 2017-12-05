package Robotti_Tanel_i;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class IRSensor extends Thread {

	EV3IRSensor ir = new EV3IRSensor(SensorPort.S2);
	public int control = 0;

	public void run() {
		while (true) {
			control = ir.getRemoteCommand(1);

		}

	}
}
