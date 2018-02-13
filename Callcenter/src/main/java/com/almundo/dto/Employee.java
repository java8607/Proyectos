package com.almundo.dto;

/**
 * @author Ing. Oscar Rodríguez
 * @version 1.0
 * Este Pojo define las caracteristicas comunes entre los empleados del Call Center
 */
public class Employee {
	
	//Contiene el nombre o identificador de un empleado, el cual consta del tipo de empleado y un indice entero
	private String name;	
	
	/*Si es true el empleado estará disponible para contestar una llamada, 
	 * pero si es false significa que esta ocupado en una llamada*/
	private boolean avaible;
	
	//Cantidad de llamadas tomadas
	private int calls;
	/**
	 * Constructor
	 */
	public Employee() {
	}
	
	/*Getters and Setters*/
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAvaible() {
		return avaible;
	}
	public void setAvaible(boolean avaible) {
		this.avaible = avaible;
	}

	public int getCalls() {
		return calls;
	}

	public void setCalls(int calls) {
		this.calls = calls;
	}
	
}
