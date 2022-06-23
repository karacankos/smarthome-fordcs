package com.swt.fordcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.swt.fordcs.device.FordCsFSM;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//

@SpringBootApplication
@EnableSwagger2
public class FordCsApplication {
	// --
	public static void main(String[] args) {
		// create and initialize the state machine as singleton!
		private static FordCsFSM fordCsFSM = FordCsFSM.getInstance();

		SpringApplication.run(FordCsApplication.class, args);
	}	
	
	
	// ref.: https://www.youtube.com/watch?v=gduKpLW_vdY , https://www.youtube.com/watch?v=8s9I1G4tXhA
	@Bean 
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/v1/**")) // get rid of basic-error-controller
//				.apis(RequestHandlerSelectors.basePackage("io.javabrains"))
				.build(); 
	} 

	
	

}
