package com.swt.fordcs.services;

import org.springframework.stereotype.Service;

import com.swt.fordcs.device.*;
import com.swt.fordcs.device.FordCsFSM.State;

@Service
public class CsMonitorVehicleChargingStateService {

	// create the state machine as singleton!
	private static FordCsFSM fordCsFSM = FordCsFSM.getInstance();

	public State getMonitorVehicleChargingState(String user) {
		// validate the user
		if (FordCsMonitorVehicleChargingStateUsers.getInstance().findUser(user) != null) 
			return fordCsFSM.getState();
		return State.UNKNOWN;
	}

}
