package com.swt.fordcs.device;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swt.fordcs.device.FordCSSettingDataX;

class Test_FordCSReportDataX {

	@Test
	void test_ConvertToJSON() {
		
	    ObjectMapper mapper = new ObjectMapper();

	    // Java object to JSON string
	    String jsonString="";
		try {
			jsonString = mapper.writeValueAsString(new FordCSSettingDataX(true));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(jsonString);;
	}

}
