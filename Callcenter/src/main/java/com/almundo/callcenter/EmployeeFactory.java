package com.almundo.callcenter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.almundo.dto.Director;
import com.almundo.dto.Operator;
import com.almundo.dto.Employee;
import com.almundo.dto.Supervisor;
import com.almundo.utils.Property;

/**
 * @author Ing. Oscar Rodríguez
 * @version 1.0
 * Esta clase se encarga de llenar las listas con operadores,
 * supervidores y directores, con las cantidades establecidas en nuestra clase Property
 *
 */
public class EmployeeFactory {

	/*Esta variable de clase se encarga de contener la lista de operadores, la cual será la 
	 * misma para todos los hilos o llamadas*/
	public static List<Employee> operators;
	
	/*Esta variable de clase se encarga de contener la lista de supervisores, la cual será la 
	 * misma para todos los hilos o llamadas*/
	public static List<Employee> supervisors;
	
	/*Esta variable de clase se encarga de contener la lista de directores, la cual será la 
	 * misma para todos los hilos o llamadas*/
	public static List<Employee> directors;

	/**
	 * Constructor EmployeeFactory
	 */
	public EmployeeFactory() {
		//Inicializa la lista de operadores
		operators=new ArrayList<Employee>();	
		//Ejecuta la adición de operadores
		addEmployees(Property.OPERATOR);
		//Inicializa la lista de supervisores
		supervisors=new ArrayList<Employee>();
		//Ejecuta la adición de supervisores
		addEmployees(Property.SUPERVISOR);
		//Inicializa la lista de directores
		directors=new ArrayList<Employee>();
		//Ejecuta la adición de directores
		addEmployees(Property.DIRECTOR);
	}

	/**
	 * Se encarga de adicionar los empleados a su lista correspondiente dependiendo del tipo de empleado
	 * @param typeEmployee
	 */
	private void addEmployees(Property typeEmployee) {
		Employee employee = null;

		//Este ciclo recorre la cantidad de empleados dependiendo del tipo
		for (int i = 0; i < typeEmployee.getQuantity(); i++) {
			/*Dependiendo del tipo de empleado lo adiciona a la lista creando 
			 * previamente un objeto con su indice incrementado en uno*/
			if (typeEmployee.equals(Property.DIRECTOR)) {
				employee = new Director(i+1);
				directors.add(employee);
			} else if (typeEmployee.equals(Property.SUPERVISOR)) {
				employee = new Supervisor(i+1);
				supervisors.add(employee);
			} else if (typeEmployee.equals(Property.OPERATOR)) {
				employee = new Operator(i+1);
				operators.add(employee);
			}
		}
	}
	
	/**
	 * Metodo Predicate encargado de validar si el empleado esta disponible para contestar una llamada
	 * @return
	 */
	public static Predicate<Employee> isAvaibleToAnswer() {
		return p -> p.isAvaible();
	}
	
	/**
	 * Metodo Predicate encargado de validar si el empleado esta en una llamada para terminarla
	 * @return
	 */
	public static Predicate<Employee> isAvaibleToEnd() {
		return p -> !p.isAvaible();
	}

	/**
	 * Devuelve la lista filtrada de empleados según el Predicate enviado
	 * @param employees
	 * @param predicate
	 * @return
	 */
	public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
		return employees.stream().filter(predicate).collect(Collectors.<Employee> toList());
	}
}
