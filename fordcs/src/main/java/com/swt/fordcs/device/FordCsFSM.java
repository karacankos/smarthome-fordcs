package com.swt.fordcs.device;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

// Ford Charging Station Finite State Machine - Model version: see application.properties
// The FSM is a Singleton class!
// Reference: Nested Switch Implementation in http://www.cs.fsu.edu/~lacher/courses/COP5385/lectures/QP3/script.html
public class FordCsFSM {
	public static enum Event {                      // enumeration for CParser signals
		Power_on,
		Ready_to_charge,
		Vehicle_disconnected,
		Start_charging,
		Stop_charging,
		Vehicle_connected,
		Failure_fixed,
		Failure,
		Power_off  // init state
	};
	public static enum State {
		INITIAL_STATE,
		POWER_OFF,
		POWER_PRESENT,
		READY_TO_CHARGE,
		VEHICLE_CONNECTED,
		VEHICLE_CHARGING,
		TROUBLE,
		UNKNOWN
	}
	public static class StateDescription {
		private static final Map<String, String> stateDescriptionMap = new HashMap<String, String>() {{
		    put(State.INITIAL_STATE.name(), new String("the CS is initialized!"));
		    put(State.POWER_OFF.name(), new String("the CS is in POWER_OFF!"));
		    put(State.POWER_PRESENT.name(), new String("the CS POWER_PRESENT!"));
		    put(State.READY_TO_CHARGE.name(), new String("the CS is READY_TO_CHARGE!"));
		    put(State.VEHICLE_CONNECTED.name(), new String("the CS VEHICLE_CONNECTED!"));
		    put(State.VEHICLE_CHARGING.name(), new String("the CS VEHICLE_CHARGING!"));
		    put(State.TROUBLE.name(), new String("the CS is in TROUBLE!"));
		    put(State.UNKNOWN.name(), new String("the CS state is UNKNOWN, no access to the state info!"));
		}};
		
		
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getStateDescription() {
			return stateDescription;
		}
		public void setStateDescription(String stateDescription) {
			this.stateDescription = stateDescription;
		}
		private String state;
		private String stateDescription;
		//
		public StateDescription(State st) {
			state = st.name();
			stateDescription = stateDescriptionMap.get(state);
		}		
	};
	// Singleton class
	private void FordCsFSM () {}
	private static FordCsFSM _this = null;
	public static FordCsFSM getInstance () {
		if (_this == null) {
			_this = new FordCsFSM();
			_this.init(); // set state to POWER_OFF
		}
		return _this;
	}
	@Value("${SWCnameFSM}")
	private String sSWCnameFSM;
	@Value("${SWCDescriptionFSM}")
	private String sSWCDescriptionFSM;
	@Value("${SWCValueFSM}")
	private String sSWCValueFSM;
	
	public String getsSWCnameFSM() {
		return sSWCnameFSM;
	}
	public String getsSWCDescriptionFSM() {
		return sSWCDescriptionFSM;
	}
	public String getsSWCValueFSM() {
		return sSWCValueFSM;
	}

	private State myState;
	private void init() {
		myState = State.INITIAL_STATE;   
	}
	private void transition_to(State target_state) {
		myState = target_state;
	}

	public State getState() {
	      return myState;   // default transition
	}
	// FMS
	public State triggerFMS(Event e) {
		// in any state, following events are valid: failure, power_off
		if ( e == Event.Failure) {
			transition_to(State.TROUBLE);
		}
		if (e == Event.Power_off) {
			transition_to(State.POWER_OFF);
		}
		switch (myState) {
			case INITIAL_STATE:
				// only following event(s) are valid: power_off
				switch (e) {
					case Power_off:
						transition_to(State.POWER_OFF);
						break;
				}
				break;
			case POWER_OFF:
				// only following event(s) are valid: power_on
				switch (e) {
					case Power_on:
						transition_to(State.POWER_PRESENT);
						break;
				}
				break;
			case POWER_PRESENT:
				// only following event(s) are valid: ready_to_charge
				switch (e) {
					case Ready_to_charge:
						transition_to(State.READY_TO_CHARGE);
						break;
				}
				break;
			case READY_TO_CHARGE:
				// only following event(s) are valid: vehicle_connected
				switch (e) {
					case Vehicle_connected:
						transition_to(State.VEHICLE_CONNECTED);
						break;
				}
				break;
			case VEHICLE_CONNECTED:
				// only following event(s) are valid: start_charging, vehicle_disconnected
				switch (e) {
					case Start_charging:
						transition_to(State.VEHICLE_CHARGING);
						break;
					case Vehicle_disconnected:
						transition_to(State.READY_TO_CHARGE);
						break;
				}
				break;
			case VEHICLE_CHARGING:
				switch (e) {
					// only following event(s) are valid: stop_charging
					case Stop_charging:
						transition_to(State.VEHICLE_CONNECTED);
						break;
				}
				break;
			case TROUBLE:
				switch (e) {
				// only following event(s) are valid: failer_fixed
					case Failure_fixed:
						transition_to(State.READY_TO_CHARGE);
						break;
				}
				break;
			
		}
		return getState();
	}

}
