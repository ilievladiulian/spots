package systems.ab4.workshop.spots;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.format.datetime.DateFormatter;
import systems.ab4.workshop.spots.locations.Location;
import systems.ab4.workshop.spots.locations.LocationType;
import systems.ab4.workshop.spots.locations.repository.LocationRepository;
import systems.ab4.workshop.spots.spots.Activity;
import systems.ab4.workshop.spots.spots.Spot;
import systems.ab4.workshop.spots.spots.repository.SpotRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
@EntityScan
public class SpotsApplication {

	private static final Logger log = LoggerFactory.getLogger(SpotsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpotsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LocationRepository locationRepository, SpotRepository spotRepository) {
		return (args) -> {
			Location romania = new Location("Romania", null, LocationType.COUNTRY);

			Location ilfov = new Location("Ilfov", romania, LocationType.REGION);
			Location brasov = new Location("Brasov", romania, LocationType.REGION);
			Location constanta = new Location("Constanta", romania, LocationType.REGION);

			Location bucuresti = new Location("Bucuresti", ilfov, LocationType.CITY);
			Location predeal = new Location("Predeal", brasov, LocationType.CITY);
			Location sinaia = new Location("Sinaia", brasov, LocationType.CITY);
			Location mamaia = new Location("Mamaia", constanta, LocationType.CITY);
			Location neptun = new Location("Neptun", constanta, LocationType.CITY);
			Location vama = new Location("Vama", constanta, LocationType.CITY);

			List<Location> locations = Arrays.asList(romania, ilfov, brasov, constanta, bucuresti, predeal, mamaia, neptun, vama);

			locationRepository.save(locations);

			DateFormatter df = new DateFormatter("dd/MM/yyyy");
			Locale ro = Locale.forLanguageTag("ro");

			Spot predealClimbing = new Spot("Predeal Climbing School", predeal, df.parse("15/06/2017", ro), df.parse("15/10/2017", ro), 29.99, new HashSet<>(Arrays.asList(Activity.CLIMB)));

			List<Spot> spots = Arrays.asList(predealClimbing);
			spotRepository.save(spots);



			log.info("Locations found with findAll()");
			log.info("------------------------------");
			for (Location location : locationRepository.findByNameIn("Neptun")) {
				log.info(location.toString());
			}

			log.info("");
		};
	}
}
