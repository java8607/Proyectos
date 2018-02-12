package com.almundo.utils;

public enum Property {

	OPERATOR("Operator",7),
	SUPERVISOR("Supervisor",2),
	DIRECTOR("Director",1),
	CALL("Calls", 10);

	private String description;	
	private int quantity;

	private Property(String description, int quantity) {
		this.description= description;
		this.quantity  = quantity;
	}

	public String getDescription() {
		return description;
	}
	public int getQuantity() {
		return quantity;
	}

}
