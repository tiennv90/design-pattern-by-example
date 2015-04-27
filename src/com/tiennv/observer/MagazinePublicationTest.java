package com.tiennv.observer;

/**
 * 
 * @author tien nguyen
 * 
 * In this class we can test to see how observer pattern works
 * when the magazine publish a new issue observers (Board Of Director, Editors, Subscribers) are notified and updated
 */
public class MagazinePublicationTest {

	public static void main(String[] args) {
		
		MagazinePublication magazinePublication = new MagazinePublication();
		
		BoardOfDirectorsDisplay boardOfDirectorsDisplay = new BoardOfDirectorsDisplay(magazinePublication);
		
		EditorsDisplay editorsDisplay = new EditorsDisplay(magazinePublication);
		
		SubscribersDisplay subscribersDisplay = new SubscribersDisplay(magazinePublication);
		
		magazinePublication.updateNewMagazineIssue("The Flash", 10, "the flash vs the arrow", 1000);
	}

}
