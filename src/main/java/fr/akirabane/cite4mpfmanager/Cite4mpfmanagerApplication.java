package fr.akirabane.cite4mpfmanager;

import fr.akirabane.cite4mpfmanager.model.Units;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cite4mpfmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cite4mpfmanagerApplication.class, args);
	}

}
