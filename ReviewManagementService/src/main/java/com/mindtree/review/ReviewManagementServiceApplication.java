package com.mindtree.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class ReviewManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewManagementServiceApplication.class, args);
	}

}
