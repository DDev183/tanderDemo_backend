package page.danya.tanderDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import page.danya.tanderDemo.Models.City;
import page.danya.tanderDemo.Models.Region;

import java.util.List;
import java.util.Optional;

public interface CityRepo extends JpaRepository<City, Integer> {


    Optional<City> findByName(String name);

    List<City> findByRegion(Region region);
}
