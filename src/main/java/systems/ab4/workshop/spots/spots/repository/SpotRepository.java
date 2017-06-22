package systems.ab4.workshop.spots.spots.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import systems.ab4.workshop.spots.spots.Spot;

/**
 * Created by Vlad on 22/06/2017.
 */
@Repository
public interface SpotRepository extends CrudRepository<Spot, Long> {
}
