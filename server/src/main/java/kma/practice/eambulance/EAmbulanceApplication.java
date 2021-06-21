package kma.practice.eambulance;


import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
@AllArgsConstructor
public class EAmbulanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EAmbulanceApplication.class, args);
	}


}
