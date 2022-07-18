package com.swt.fordcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swt.fordcs.device.FordCsFSM.State;
import com.swt.fordcs.services.CsMonitorVehicleChargingStateService;


//reference: https://spring.io/guides/tutorials/rest/
//http return codes: https://stackoverflow.com/questions/4268707/what-rest-put-post-delete-calls-should-return-by-a-convention
// webservice is specified in https://app.swaggerhub.com/apis/karacankos/fordcs/1.0-oas3

@RestController
@RequestMapping("/api/v1") 
public class CsMonitorVehicleChargingStateController {

 @Autowired // Service
 private CsMonitorVehicleChargingStateService csMonitorVehicleChargingStateService;

 //
 // call synopsis: http://localhost:8080/api/v1/monitorVehicleChargingState/allowed_user 
 // 			see /fordcs/src/main/java/com/swt/fordcs/device/FordCsMonitorVehicleChargingStateUsers.java	for {allowed users}
 //
 @GetMapping("/monitorVehicleChargingState/{user}")
 ResponseEntity<String> getMonitorVehicleChargingState(@PathVariable String user) {
   State st = csMonitorVehicleChargingStateService.getMonitorVehicleChargingState(user);
   if (st.ordinal() != State.UNKNOWN.ordinal())
	   return new ResponseEntity<String>(st.name(), HttpStatus.OK);
   return new ResponseEntity<String>(st.name(), HttpStatus.UNAUTHORIZED);
 }
 
}

