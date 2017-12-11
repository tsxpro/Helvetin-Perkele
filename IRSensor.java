/**
 * @author Helvetin Perkeleet
 * 
 */

package Robotti_Tanel_i;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;

public class IRSensor extends Thread {

	EV3IRSensor ir = new EV3IRSensor(SensorPort.S2);
	/**
	 * Sensori on portissa nro:2 kiinni
	 */
	public int control = 0;

	public void run() {
		while (true)
		/**
		 * Sensori on kokoajan p‰‰ll‰ 
		 */
		{
			control = ir.getRemoteCommand(1);
			/**
			 * T‰ss‰ m‰ritet‰‰n taajuudeksi 1 v‰lilt‰ 0-3 Sensori otttaa ohjeita vastaan
			 * vain 1 taajuudella olevalta kauko-ohjaimelta
			 */

		}

	}
}
