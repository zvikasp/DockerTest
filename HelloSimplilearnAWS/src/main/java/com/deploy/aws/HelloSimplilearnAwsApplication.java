package com.deploy.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloSimplilearnAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSimplilearnAwsApplication.class, args);
	}

}

@RestController
class HelloWorldController {

	@RequestMapping("/")
	public String hello() {
		return "Hello World Spring Boot...";
	}

	@RequestMapping("/welcome/{name}")
	public String welcome(@PathVariable String name) {
		return "Welcome " + name;
	}
}
