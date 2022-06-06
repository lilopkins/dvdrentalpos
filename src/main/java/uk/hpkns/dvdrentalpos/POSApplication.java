package uk.hpkns.dvdrentalpos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class POSApplication {

	public static void main(String[] args) {
		SpringApplication.run(POSApplication.class, args);
	}

}
