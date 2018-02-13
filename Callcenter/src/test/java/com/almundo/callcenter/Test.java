package com.almundo.callcenter;
import static org.junit.Assert.*;

import com.almundo.callcenter.CallSimulator;
import com.almundo.callcenter.EmployeeFactory;
import com.almundo.utils.Property;

public class Test {

	@org.junit.Test
	public void callsDoneVsAttended() {
		Integer calls = Property.CALL.getQuantity();
		Integer totalCalls = 0;

		
		new EmployeeFactory();
		for (int i = 0; i < Property.CALL.getQuantity(); i++) {
			// Se muestra en el log el inicio de la llamada
			Dispatcher dispatcher = new Dispatcher();
			// Ejecuta la asignación de la llamada
			dispatcher.dispatchCall(false);
			// Finaliza la llamada
			dispatcher.endCall();
		}

		for (int i = 0; i < Property.OPERATOR.getQuantity(); i++) {
			totalCalls += EmployeeFactory.operators.get(i).getCalls();
		}

		for (int i = 0; i < Property.SUPERVISOR.getQuantity(); i++) {
			totalCalls += EmployeeFactory.supervisors.get(i).getCalls();
		}

		for (int i = 0; i < Property.DIRECTOR.getQuantity(); i++) {
			totalCalls += EmployeeFactory.directors.get(i).getCalls();
		}

		assertEquals(calls, totalCalls);
	}

}
