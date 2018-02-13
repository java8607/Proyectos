package com.almundo.dto;

/**
 * @author Ing. Oscar Rodríguez
 * @version 1.0
 * Este Pojo define las caracteristicas del director y las hereda de Employee
 */
public class Director extends Employee {

	public Director(int name) {
		setName("Director " + name);
		setAvaible(true);
	}
}
