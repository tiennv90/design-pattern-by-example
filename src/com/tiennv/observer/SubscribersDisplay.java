package com.tiennv.observer;

import java.util.Observable;
import java.util.Observer;
/**
 * 
 * @author tien nguyen
 * This class implement  java.util.Observer so it can be added to Observable
 */
public class SubscribersDisplay implements DisplayElement, Observer {

	private String content;
	
	public SubscribersDisplay(Observable observable) {
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Subscriber received the new content: " + content);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof MagazinePublication) {
			MagazinePublication magazinePublication = (MagazinePublication) o;
			this.content = magazinePublication.getContent();
			display();
		}
	}

}
