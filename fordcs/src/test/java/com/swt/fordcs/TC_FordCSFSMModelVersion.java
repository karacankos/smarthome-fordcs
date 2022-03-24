package com.swt.fordcs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TC_FordCSFSMModelVersion {
	@Value("${SWCnameFSM}")
	private String sSWCnameFSM;
	@Value("${SWCDescriptionFSM}")
	private String sSWCDescriptionFSM;
	@Value("${SWCValueFSM}")
	private String sSWCValueFSM;

	@Test
	void TC_FSMModelVersion() {
		String expected_sSWCValueFSM = "2022.03";
		System.out.println(sSWCnameFSM+" "+sSWCDescriptionFSM+" "+sSWCValueFSM);
		assertEquals(expected_sSWCValueFSM, sSWCValueFSM, "FSM Model VERSION mismatch!");
	}

}
