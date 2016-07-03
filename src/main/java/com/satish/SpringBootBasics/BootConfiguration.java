package com.satish.SpringBootBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *  http://localhost:8080/metrics
 *  http://localhost:8080/health
 *  http://localhost:8080/info
 *  http://localhost:8080/trace
 *  http://localhost:8080/chat/new
 *  http://localhost:8080/chat/message/5
 *  http://docs.spring.io/spring-data/mongodb/docs/1.2.x/reference/html/mongo.repositories.html
 */
@SpringBootApplication
public class BootConfiguration 
{
  
	public static void main(String[] args) {
        SpringApplication.run(BootConfiguration.class, args);
    }
}
