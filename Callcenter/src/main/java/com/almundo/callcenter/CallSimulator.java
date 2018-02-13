package com.almundo.callcenter;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.almundo.utils.Property;

/**
 * @author Ing. Oscar Rodríguez
 * @version 1.0
 * Esta clase se encarga de simular las llamadas telefonicas, basicamente genera hilos para ejecutar nuestro programa
 * concurrentemente
 */
public class CallSimulator extends Thread {

	//Variable de instancia encargada de la duración de la llamada
	private int callDuration;
	//Esta constante contiene el log, el cual nos ayuda a mostrar en pantalla la información errores, se trabajo con log4j
	private final static Logger log = Logger.getLogger(CallSimulator.class);

	/**
	 * Constructor encargado de inicializar el proceso de simulación
	 */
	public CallSimulator() {
		//Se encarga de ejecutar la fabrica de empleados
		new EmployeeFactory();		
		//Configura nuestra configuraciòn basica para el log
		BasicConfigurator.configure();
		//inicia las llamadas
		execute();
	}

	public CallSimulator(String str) {
		super(str);
	}

	/**
	 * Crea nuestros hilos, los cuales son analogos a las llamdas entrantes
	 */
	public void execute() {
		for (int i = 0; i < Property.CALL.getQuantity(); i++) {
			new CallSimulator("Call #" + (i+1)).start();
		}
	}

	/**
	 * Metodo propio de Thread, ejecuta la logica de nuestro programa
	 */
	public void run() {
		//Obtiene una duración aleatorea de la llamada
		callDuration = getCallDuration();
		try {
			//Se muestra en el log el inicio de la llamada
			log.info("Beginning call...");
		    Dispatcher dispatcher = new Dispatcher();
		    
			//Ejecuta la asignación de la llamada
			while(!dispatcher.dispatchCall(false)){
				//Si todos los empleados estan ocupados se da un tiempo máximo de 10 segundos
				sleep(10000);
			}			

			//Se muestra en el log a que empleado se le asigno la llamada
			log.info("Call take for "+dispatcher.getNameEmployee());
			
			//Simula el tiempo que tarda el empleado en atender la llamada de un usuario
			sleep(callDuration);
			
			//Finaliza la llamada
			dispatcher.endCall();			

			//Muestra en el log quien termino la llamada y la duraciòn en segundos de la misma
			log.info("Call end for "+dispatcher.getNameEmployee()+", duration " + (callDuration / 1000)	+ "sg");
		} catch (InterruptedException e) {
			log.error("Call losed, An error occurred in a call "+ e.getMessage());
		}

	}

	/**
	 * Este metodo genera un numero aleatoreo entre 5000 y 10000, el cual representa el intervalo de duración de una llamada
	 * de 5 a 10 segundos.
	 * @return
	 */
	public int getCallDuration() {
		int callDuration = new Random().nextInt(5000) + 5000;
		return callDuration;
	}
}
