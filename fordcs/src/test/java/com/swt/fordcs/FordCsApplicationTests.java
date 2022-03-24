package com.swt.fordcs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.swt.fordcs.device.FordCsFSM;

@SpringBootTest
class FordCsApplicationTests {

	@Test
	void contextLoads() {
		
				
				FordCsFSM fsm = FordCsFSM.getInstance();
					
				
				String sn = fsm.getsSWCnameFSM();
				String sd = fsm.getsSWCDescriptionFSM();
				String sv = fsm.getsSWCValueFSM();
				
				System.out.print(sn+" "+sd+" "+sv);
	}

}
