package com.swt.fordcs.services;

import org.springframework.stereotype.Service;

import com.swt.fordcs.device.FordCsControlVehicleChargingStateUsers;
import com.swt.fordcs.device.FordCsFSM;
import com.swt.fordcs.device.FordCsMonitorVehicleChargingStateUsers;
import com.swt.fordcs.device.FordCsFSM.Event;
import com.swt.fordcs.device.FordCsFSM.State;

@Service
public class CsControlVehicleChargingStateService {
	// create the state machine as singleton!
	private static FordCsFSM fordCsFSM = FordCsFSM.getInstance();

	public State putControlVehicleChargingState(String user, String event) {
		// validate the user
		if (FordCsControlVehicleChargingStateUsers.getInstance().findUser(user) != null) {
			fordCsFSM.triggerFMS(Event.valueOf(event));
			return fordCsFSM.getState();
		}
		return State.UNKNOWN;
	}

}
