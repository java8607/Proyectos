package com.almundo.dto;

/**
 * @author Ing. Oscar Rodríguez
 * @version 1.0
 * Este Pojo define las caracteristicas del operador y las hereda de Employee
 */
public class Operator extends Employee{
	
	public Operator(int name) {
		setName("Operator "+name);
		setAvaible(true);
	}

}
