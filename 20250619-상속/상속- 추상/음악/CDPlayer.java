package com.abstractex;

public class CDPlayer extends Player {

	@Override
	void play(int pos) {
		
	}
	
	@Override
	void stop() {
		
	}
	
	int currentTrack;
	
	void nextTrack() {
		currentTrack++;
	}
	void preTrack() {
		if(currentTrack >1) {
			currentTrack--;
		}
			
	}
}
