package com.tiennv.strategry;

/**
 * 
 * @author tien nguyen
 * Sea Dragon live most of its life in water so it can't fly
 */
public class SeaDragon extends Dragon {

	public SeaDragon() {
		this.flyable = new FlyNoWay();
	}
	
	@Override
	public void name() {
		System.out.println("I am sea dragon");
	}

	@Override
	public void attack() {
		System.out.println("Tidal wave");
		
	}

	
	
	
	
}
