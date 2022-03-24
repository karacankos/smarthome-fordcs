package com.swt.fordcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.swt.fordcs.device.FordCsFSM;

//
@SpringBootApplication
public class FordCsApplication {
	// --
	public static void main(String[] args) {
		SpringApplication.run(FordCsApplication.class, args);
	}

}
