package systems.ab4.workshop.spots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class SpotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotsApplication.class, args);
	}
}
