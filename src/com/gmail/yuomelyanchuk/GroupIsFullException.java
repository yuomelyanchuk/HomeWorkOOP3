package com.gmail.yuomelyanchuk;

public class GroupIsFullException extends Exception {
		
	@Override
	public String getMessage() {		
		return "Group is full";
	}
	

}

