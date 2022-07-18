package com.swt.fordcs.device;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.swt.fordcs.device.FordCsFSM.Event;
import com.swt.fordcs.device.FordCsFSM.State;
import com.swt.fordcs.device.FordCsFSM.StateDescription;

//@TestMethodOrder(MethodOrderer.MethodName.class)
class FSM_TC_Test_Ford_State_Transitions {

	
	FordCsFSM fsm = FordCsFSM.getInstance();
	

	@Test
	@Order(1)
	void FSM_TC_0_Test_Tansition_From_INITIAL_STATE_to_POWER_OFF() {
		StateDescription sd = new FordCsFSM.StateDescription(State.INITIAL_STATE); 
		System.out.println(sd.getStateDescription());
		
		assertEquals(fsm.triggerFMS(Event.Power_off),State.POWER_OFF);
	}
	@Test
	@Order(2)
	void FSM_TC_1_Test_Tansition_From_POWER_OFF_to_POWER_PRESENT() {
		assertEquals(fsm.triggerFMS(Event.Power_on),State.POWER_PRESENT);
	}

	@Test
	@Order(3)
	void FSM_TC_2_Test_Tansition_From_POWER_PRESENT_to_READY_TO_CHARGE() {
		assertEquals(fsm.triggerFMS(Event.Ready_to_charge),State.READY_TO_CHARGE);
		
	}
	@Test
	@Order(4)
	void FSM_TC_3_Test_Tansition_From_READY_TO_CHARGE_to_VEHICLE_CONNECTED() {
		assertEquals(fsm.triggerFMS(Event.Vehicle_connected),State.VEHICLE_CONNECTED);
		
	}
	@Test
	@Order(5)
	void FSM_TC_4_Test_Tansition_From_VEHICLE_CONNECTED_to_VEHICLE_CHARGING() {
		assertEquals(fsm.triggerFMS(Event.Start_charging),State.VEHICLE_CHARGING);
		
	}
	@Test
	@Order(6)
	void FSM_TC_5_Test_Tansition_From_VEHICLE_CHARGING_to_VEHICLE_CONNECTED() {
		assertEquals(fsm.triggerFMS(Event.Stop_charging),State.VEHICLE_CONNECTED);
		
	}
	@Test
	@Order(7)
	void FSM_TC_6_Test_Tansition_From_VEHICLE_CONNECTED_to_READY_TO_CHARGE() {
		assertEquals(fsm.triggerFMS(Event.Vehicle_disconnected),State.READY_TO_CHARGE);
		
	}
	@Test
	@Order(8)
	void FSM_TC_7_Test_Tansition_From_POWER_OFF_to_TROUBLE() {
		assertEquals(fsm.triggerFMS(Event.Failure),State.TROUBLE);
	}
	@Test
	@Order(9)
	void FSM_TC_8_Test_Tansition_From_READY_TO_CHARGE() {
		assertEquals(fsm.triggerFMS(Event.Failure_fixed),State.READY_TO_CHARGE);
	}


	
	

	
}
