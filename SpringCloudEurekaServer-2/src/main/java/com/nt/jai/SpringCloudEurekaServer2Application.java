package com.nt.jai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServer2Application.class, args);
	}

}
