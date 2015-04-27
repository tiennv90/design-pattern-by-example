package com.tiennv.strategry;
/**
 * 
 * @author tien nguyen
 *
 */
public class FireDragon extends Dragon {

	public FireDragon() {
		this.flyable = new Flying();
	}
	
	@Override
	public void name() {
		System.out.println("I'm fire dragon");
	}

	@Override
	public void attack() {
		System.out.println("The equalizer");
	}

}
