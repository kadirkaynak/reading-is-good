package com.company.readingisgood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableMongoRepositories
public class ReadingIsGoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingIsGoodApplication.class, args);
	}

}
