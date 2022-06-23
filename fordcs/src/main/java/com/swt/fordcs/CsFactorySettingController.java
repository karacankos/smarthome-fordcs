package com.swt.fordcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swt.fordcs.device.FordCSSettingDataX;
import com.swt.fordcs.services.CsFactorySettingService;

//reference: https://spring.io/guides/tutorials/rest/
//http return codes: https://stackoverflow.com/questions/4268707/what-rest-put-post-delete-calls-should-return-by-a-convention

// webservice is specified in https://app.swaggerhub.com/apis/karacankos/fordcs/1.0-oas3
/*
 * ToDO:
 *  * Implement the http-responses with 401, 403, and 405 according to SwaggerHub API design!
 */
@RestController
@RequestMapping("/api/v1")
public class CsFactorySettingController {

 @Autowired
 private CsFactorySettingService fordCsService;

//call synopsis: http://localhost:8080/api/v1/reportCsFactorySetting
 @GetMapping("/reportCsFactorySetting")
 ResponseEntity<FordCSSettingDataX> getReportCsFactorySetting() {

	 return new ResponseEntity<>(fordCsService.getDeviceFactorySettings(), HttpStatus.OK);      
 }

}

