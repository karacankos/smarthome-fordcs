package com.swt.fordcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swt.fordcs.device.FordCsFSM.State;
import com.swt.fordcs.services.FordCsServiceRuntimeStatusReport;

//reference: https://spring.io/guides/tutorials/rest/
//http return codes: https://stackoverflow.com/questions/4268707/what-rest-put-post-delete-calls-should-return-by-a-convention
// webservice is specified in https://app.swaggerhub.com/apis/karacankos/fordcs/1.0-oas3

//runtimeStatusReport/{user}
@RestController
@RequestMapping("/api/v1") 
public class FordCsControllerRuntimeStatusReport {

 @Autowired // Service
 private FordCsServiceRuntimeStatusReport fordCsServiceRuntimeStatusReport;

// call synopsis: http://localhost:8080/api/v1/runtimeStatusReport/Home_resident // OR “Charging_Station_System_Operator”, "Building_Technology_System_Operator”,  “BEA”
 @GetMapping("/runtimeStatusReport/{user}")
 ResponseEntity<State> getRuntimeStatusReport(@PathVariable String user) {
   State st = fordCsServiceRuntimeStatusReport.getRuntimeStatusReport(user);
   if (st.ordinal() != State.UNKNOWN.ordinal())
	   return new ResponseEntity<State>(st, HttpStatus.OK);
   return new ResponseEntity<State>(st, HttpStatus.UNAUTHORIZED);
 }
 
}

