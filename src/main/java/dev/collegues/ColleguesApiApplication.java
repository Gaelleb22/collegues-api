package dev.collegues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ColleguesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColleguesApiApplication.class, args);
	}

}
