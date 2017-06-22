package systems.ab4.workshop.spots.locations.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import systems.ab4.workshop.spots.locations.Location;

import java.util.List;

/**
 * Created by Vlad on 22/06/2017.
 */
@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

    List<Location> findByNameIn(String name);
}
