package com.firststep.utils;

public class ClockHandAngle {

	public static void main(String[] args) {
		float hh = 3;
		float mm = 15;
		float angle = (hh*30 + mm/2) - (mm * 6);
		if (angle < 0 ){
			angle = angle * -1;
		}
		System.out.println("angle values - "+angle);
	}

}
