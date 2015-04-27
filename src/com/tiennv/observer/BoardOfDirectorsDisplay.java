package com.tiennv.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author tien nguyen
 * This class implement  java.util.Observer so it can be added to Observable
 */
public class BoardOfDirectorsDisplay implements DisplayElement, Observer {

	private int numberofIssues; 
	
	public BoardOfDirectorsDisplay(Observable observable) {
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out
				.println("Board Of Director updated number of issues: " + numberofIssues);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof MagazinePublication) {
			MagazinePublication magazinePublication = (MagazinePublication) o;
			this.numberofIssues = magazinePublication.getNumberOfissues();
			display();
		}
	}

	
}
