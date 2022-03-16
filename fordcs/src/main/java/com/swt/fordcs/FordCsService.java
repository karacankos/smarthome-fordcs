package com.swt.fordcs;

import org.springframework.stereotype.Service;

import com.swt.fordcs.FordCsFSM.Event;
import com.swt.fordcs.FordCsFSM.State;


@Service
public class FordCsService {
	// create the state machine as singleton!
	private static FordCsFSM fordCsFSM = FordCsFSM.getInstance();
	private FordCSSettingDataX fordCSSettingDataX = new FordCSSettingDataX(true);
	
	public State getState() {
		return fordCsFSM.getState();
	}

	public State transToState(Event event) {
		return fordCsFSM.triggerFMS(event);
	}

	public FordCSSettingDataX getDeviceFactorySettings() {
		return fordCSSettingDataX;
	}
	

}

