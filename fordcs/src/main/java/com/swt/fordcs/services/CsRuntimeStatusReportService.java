package com.swt.fordcs.services;

import org.springframework.stereotype.Service;

import com.swt.fordcs.device.FordCSSettingDataX;
import com.swt.fordcs.device.FordCsFSM;
import com.swt.fordcs.device.FordCsRuntimeStatusReportUsers;
import com.swt.fordcs.device.FordCsFSM.Event;
import com.swt.fordcs.device.FordCsFSM.State;


@Service
public class CsRuntimeStatusReportService {

	
	// create the state machine as singleton!
	private static FordCsFSM fordCsFSM = FordCsFSM.getInstance();
	
	// if user is authorized then the state is returned otherwise State.UNKNOWN!
	public State getRuntimeStatusReport(String user) {
		// validate the user
		if (FordCsRuntimeStatusReportUsers.getInstance().findUser(user) != null) 
			return fordCsFSM.getState();
		return State.UNKNOWN;
	}
	

}

