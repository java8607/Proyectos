package com.almundo.callcenter;

import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.almundo.utils.Property;

public class CallSimulator extends Thread {

	private int callDuration;
	private final static Logger log = Logger.getLogger(CallSimulator.class);

	public CallSimulator() {
		new EmployeeFactory();		
		BasicConfigurator.configure();
		execute();
	}

	public CallSimulator(String str) {
		super(str);
	}

	public void execute() {
		for (int i = 0; i < Property.CALL.getQuantity(); i++) {
			new CallSimulator("Call #" + (i+1)).start();
		}
	}

	public void run() {
		callDuration = getCallDuration();
		try {
			log.info("Beginning call...");
		    Dispatcher dispatcher = new Dispatcher();
			while(!dispatcher.dispatchCall(false)){
				sleep(10000);
			}

			log.info("Call take for "+dispatcher.getNameEmployee());
			sleep(callDuration);
			
			while(!dispatcher.endCall(true)){
				sleep(10000);
			}

			log.info("Call end for "+dispatcher.getNameEmployee()+", duration " + (callDuration / 1000)	+ "sg");
		} catch (InterruptedException e) {
			log.error("An error occurred in a call "
					+ e.getMessage());
		}

	}

	public int getCallDuration() {
		int callDuration = new Random().nextInt(5000) + 5000;
		return callDuration;
	}
}
