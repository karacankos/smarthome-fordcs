package com.swt.fordcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swt.fordcs.device.FordCsFSM;
import com.swt.fordcs.device.FordCsFSM.State;
import com.swt.fordcs.device.FordCsFSM.StateDescription;
import com.swt.fordcs.services.CsRuntimeStatusReportService;

//reference: https://spring.io/guides/tutorials/rest/
//http return codes: https://stackoverflow.com/questions/4268707/what-rest-put-post-delete-calls-should-return-by-a-convention
// webservice is specified in https://app.swaggerhub.com/apis/karacankos/fordcs/1.0-oas3

//runtimeStatusReport/{user}
@RestController
@RequestMapping("/api/v1") 
public class CsRuntimeStatusReportController {

 @Autowired // Service
 private CsRuntimeStatusReportService csRuntimeStatusReportService;

 //
 // call synopsis: http://localhost:8080/api/v1/runtimeStatusReport/allowed_user 
 // 			see FordCsRuntimeStatusReportUsers.java	for {allowed users}
 //
 @GetMapping("/runtimeStatusReport/{user}")
 ResponseEntity<StateDescription> getRuntimeStatusReport(@PathVariable String user) {
	State st = csRuntimeStatusReportService.getRuntimeStatusReport(user);
	StateDescription sd = new FordCsFSM.StateDescription(State.INITIAL_STATE); 

	if (st.ordinal() != State.UNKNOWN.ordinal())
		return new ResponseEntity<StateDescription>(sd, HttpStatus.OK);
	return new ResponseEntity<StateDescription>(sd, HttpStatus.UNAUTHORIZED);
 }
 
}

