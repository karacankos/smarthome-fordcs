package com.swt.fordcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swt.fordcs.device.FordCsFSM.State;
import com.swt.fordcs.services.CsControlVehicleChargingStateService;
import com.swt.fordcs.services.CsMonitorVehicleChargingStateService;


//reference: https://spring.io/guides/tutorials/rest/
//http return codes: https://stackoverflow.com/questions/4268707/what-rest-put-post-delete-calls-should-return-by-a-convention
// webservice is specified in https://app.swaggerhub.com/apis/karacankos/fordcs/1.0-oas3

@RestController
@RequestMapping("/api/v1") 
public class CsControlVehicleChargingStateController {

 @Autowired // Service
 private CsControlVehicleChargingStateService csControlVehicleChargingStateService;

 //
 // call synopsis: curl -X PUT http://localhost:8080/api/v1/controlVehicleChargingState/allowed_user/allowed_event 
 // 			see 	for {allowed users}
 //
 @PutMapping("/controlVehicleChargingState/{user}/{event}")
 ResponseEntity<State> getRuntimeStatusReport(@PathVariable String user, @PathVariable String event) {
   
   State st = csControlVehicleChargingStateService.putControlVehicleChargingState(user, event);
   if (st.ordinal() != State.UNKNOWN.ordinal())
	   return new ResponseEntity<State>(st, HttpStatus.OK);
   return new ResponseEntity<State>(st, HttpStatus.UNAUTHORIZED);
 }
 
}

