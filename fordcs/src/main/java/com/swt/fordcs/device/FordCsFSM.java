package com.swt.fordcs.device;

// Ford Charging Station Finite State Machine - Model version: 2021.02-1
// The FSM is a Singleton class!
// Reference: Nested Switch Implementation in http://www.cs.fsu.edu/~lacher/courses/COP5385/lectures/QP3/script.html
public class FordCsFSM {
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
		POWER_OFF,
		POWER_PRESENT,
		READY_TO_CHARGE,
		VEHICLE_CONNECTED,
		VEHICLE_CHARGING,
		TROUBLE
	}
	private State myState;
	private void init() {
	      transition_to(State.POWER_OFF);   // default transition
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
