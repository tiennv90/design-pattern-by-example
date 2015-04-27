package com.tiennv.observer;

import java.util.Observable;

/**
 * 
 * @author tien nguyen
 *
 */
public class MagazinePublication extends Observable {
	
	private int numberOfissues;
	private String magazineName;
	private int espisode;
	private String content;
	
	public MagazinePublication() {}
	
	
	public void updateNewMagazineIssue(String magazineName, int espisode, String content, int numberOfissues) {
		this.magazineName = magazineName;
		this.espisode = espisode;
		this.content = content;
		this.numberOfissues = numberOfissues;
		
		publishNewMagazineIssue();
	}
	
	public void publishNewMagazineIssue() {
		
		//Marks this Observable object as having been changed; the hasChanged method will now return true.
		setChanged();
		
		//Each observer has its update method called
		notifyObservers();
	}


	public String getMagazineName() {
		return magazineName;
	}


	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}


	public int getEspisode() {
		return espisode;
	}


	public void setEspisode(int espisode) {
		this.espisode = espisode;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getNumberOfissues() {
		return numberOfissues;
	}


	public void setNumberOfissues(int numberOfissues) {
		this.numberOfissues = numberOfissues;
	}
	
}
