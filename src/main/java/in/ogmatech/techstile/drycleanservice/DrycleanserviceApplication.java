package in.ogmatech.techstile.drycleanservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DrycleanserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrycleanserviceApplication.class, args);
	}
}
