package com.tiennv.strategry;

/**
 * 
 * @author tien nguyen
 * 
 * In this example i manipulate strategy pattern to perform fly for Fire Dragon and Sea Dragon
 * fly behavior was moved out the inheritance hierarchy. Each dragon have a Flyable interface
 * so they can define Flyable at the sub classes.
 */
public class DragonGame {

	public static void main(String[] args) {
		
		FireDragon fireDragon = new FireDragon();
		
		fireDragon.performFly();
		fireDragon.name();
		fireDragon.attack();
		
		SeaDragon seaDragon = new SeaDragon();
		seaDragon.performFly();
		seaDragon.name();
		seaDragon.attack();

	}

}
