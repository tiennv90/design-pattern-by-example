package com.tiennv.observer;

import java.util.Observable;
import java.util.Observer;

public class EditorsDisplay implements DisplayElement, Observer {

	private int espisode;
	private String magazineName;
	
	public EditorsDisplay(Observable observable) {
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out
				.println("Editors get espisode: " + this.espisode + " Magazine name: " + this.magazineName);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof MagazinePublication) {
			MagazinePublication magazinePublication = (MagazinePublication) o;
			
			this.espisode = magazinePublication.getEspisode();
			this.magazineName = magazinePublication.getMagazineName();
			
			display();
		}
	}

}
