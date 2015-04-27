package com.tiennv.strategry;
/**
 * 
 * @author tien nguyen
 *
 */
public abstract class Dragon {

	protected Flyable flyable;
	
	public abstract void name();
	public abstract void attack();
	
	public void performFly() {
		flyable.fly();
	}
}
