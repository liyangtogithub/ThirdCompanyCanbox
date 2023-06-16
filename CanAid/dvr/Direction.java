package com.landsem.dvr;

public enum Direction {
	
	FRONT(1),
	BACK(2),
	LEFT(3),
	RIGHT(4);
	
	public int ID;
	
	private Direction(int ID) {
		this.ID = ID;
	}
	
	public static Direction check(int id) {
		switch (id) {
		case 1: return FRONT;
		case 2: return BACK;
		case 3: return LEFT;
		case 4: return RIGHT;
		default: return LEFT;
		}
	}
	
}
