package com.swt.fordcs.device;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.swt.fordcs.device.FordCsFSM.FSMEVENT;
import com.swt.fordcs.device.FordCsFSM.FSMState;
import com.swt.fordcs.device.FordCsFSM.StateDescription;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FSM_TC_Test_Ford_State_Transitions {
	
	FordCsFSM fsm = FordCsFSM.getInstance();
	

	@Test
	@Order(1)
	void FSM_TC_0_Test_Tansition_From_INITIAL_STATE_to_POWER_OFF() {
		StateDescription sd = new FordCsFSM.StateDescription(FSMState.INITIAL_STATE); 
		System.out.println(sd.getStateDescription());
		
		assertEquals(fsm.triggerFMS(FSMEVENT.Power_off),FSMState.POWER_OFF);
		System.out.println(fsm.getState());
	}
	@Test
	@Order(2)
	void FSM_TC_1_Test_Tansition_From_POWER_OFF_to_POWER_PRESENT() {
		assertEquals(fsm.triggerFMS(FSMEVENT.Power_on),FSMState.POWER_PRESENT);
		System.out.println(fsm.getState());

	}

	@Test
	@Order(3)
	void FSM_TC_2_Test_Tansition_From_POWER_PRESENT_to_READY_TO_CHARGE() {
		assertEquals(fsm.triggerFMS(FSMEVENT.Ready_to_charge),FSMState.READY_TO_CHARGE);
		System.out.println(fsm.getState());
		
	}
	@Test
	@Order(4)
	void FSM_TC_3_Test_Tansition_From_READY_TO_CHARGE_to_VEHICLE_CONNECTED() {
		assertEquals(fsm.triggerFMS(FSMEVENT.Vehicle_connected),FSMState.VEHICLE_CONNECTED);
		System.out.println(fsm.getState());
		
	}
	@Test
	@Order(5)
	void FSM_TC_4_Test_Tansition_From_VEHICLE_CONNECTED_to_VEHICLE_CHARGING() {
		assertEquals(fsm.triggerFMS(FSMEVENT.Start_charging),FSMState.VEHICLE_CHARGING);
		System.out.println(fsm.getState());
		
	}
	@Test
	@Order(6)
	void FSM_TC_5_Test_Tansition_From_VEHICLE_CHARGING_to_VEHICLE_CONNECTED() {
		assertEquals(fsm.triggerFMS(FSMEVENT.Stop_charging),FSMState.VEHICLE_CONNECTED);
		System.out.println(fsm.getState());
		
	}
	@Test
	@Order(7)
	void FSM_TC_6_Test_Tansition_From_VEHICLE_CONNECTED_to_READY_TO_CHARGE() {
		assertEquals(fsm.triggerFMS(FSMEVENT.Vehicle_disconnected),FSMState.READY_TO_CHARGE);
		System.out.println(fsm.getState());
		
	}
	@Test
	@Order(8)
	void FSM_TC_7_Test_Tansition_From_POWER_OFF_to_TROUBLE() {
		assertEquals(fsm.triggerFMS(FSMEVENT.Failure),FSMState.TROUBLE);
		System.out.println(fsm.getState());
	}
	@Test
	@Order(9)
	void FSM_TC_8_Test_Tansition_From_READY_TO_CHARGE() {
		assertEquals(fsm.triggerFMS(FSMEVENT.Failure_fixed),FSMState.READY_TO_CHARGE);
		System.out.println(fsm.getState());
	}


	
	

	
}
