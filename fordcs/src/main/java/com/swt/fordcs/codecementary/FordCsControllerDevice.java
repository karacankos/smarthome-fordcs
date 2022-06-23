package com.swt.fordcs.codecementary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swt.fordcs.device.FordCSSettingDataX;
import com.swt.fordcs.device.FordCsFSM.Event;
import com.swt.fordcs.device.FordCsFSM.State;
import com.swt.fordcs.services.CsFactorySettingService;

//reference: https://spring.io/guides/tutorials/rest/
//http return codes: https://stackoverflow.com/questions/4268707/what-rest-put-post-delete-calls-should-return-by-a-convention
// webservice is specified in https://app.swaggerhub.com/apis/karacankos/fordcs/1.0-oas3
@RestController
@RequestMapping("/api/v1")
public class FordCsControllerDevice {

 @Autowired
 private CsFactorySettingService fordCsService;

//call synopsis: http://localhost:8080/api/v1/provideVehicleChargingState
 @GetMapping("/provideVehicleChargingState")
 ResponseEntity<State> provideVehicleChargingState() {
     return new ResponseEntity<State>(fordCsService.getState(), HttpStatus.OK);
 }
 
// call synopsis: http://localhost:8080/setVehicleChargingState/Power_on
 @GetMapping("/setVehicleChargingState/{event}")
 ResponseEntity<State> setVehicleChargingState(@PathVariable Event event) {
   
   return new ResponseEntity<State>(fordCsService.transToState(event), HttpStatus.OK);
 }
 
}

