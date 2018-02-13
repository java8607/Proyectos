package com.almundo.dto;

/**
 * @author Ing. Oscar Rodríguez
 * @version 1.0
  * Este Pojo define las caracteristicas del supevisor y las hereda de Employee
 */
public class Supervisor extends Employee{

	public Supervisor(int name) {
		setName("Supervisor "+name);
		setAvaible(true);
	}	

}
