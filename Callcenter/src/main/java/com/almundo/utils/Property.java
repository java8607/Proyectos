package com.almundo.utils;

/**
 * @author Ing. Oscar Rodríguez
 * @version 1.0
 * Esta clase contiene las propiedad generales de nuestro programa, en ella se determina la cantidad
 * de operadores, supervisores, directores y llamadas entrantes simultaneamente
 */
public enum Property {
	//Cantidad de operadores
	OPERATOR(7),
	//Cantidad de supervisores
	SUPERVISOR(2),
	//Cantidad de directores
	DIRECTOR(1),
	//Cantidad de llamadas
	CALL(10);

	//Atributo cantidad
	private int quantity;

	//Constructor del enum
	private Property(int quantity) {
		this.quantity  = quantity;
	}

	/*
	 * Getters
	 */	
	public int getQuantity() {
		return quantity;
	}

}
