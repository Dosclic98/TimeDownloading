package dosclic.util;

import java.lang.Math;
public class OutCalc {
	public static String time(double size, double speed) {
		int sec = (int) ((size*Math.pow(10,3)) / speed);
		String out = String.format("%02d hours, %02d min, %02d sec", 
				((sec / (60*60)) % 24), ((sec / 60) % 60), (sec % 60)
		);
		return out;
	}
}
