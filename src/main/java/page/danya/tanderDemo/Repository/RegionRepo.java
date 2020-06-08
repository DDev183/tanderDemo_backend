package page.danya.tanderDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import page.danya.tanderDemo.Models.Region;

import java.util.Optional;

public interface RegionRepo extends JpaRepository<Region, Integer> {

    Optional<Region> findByName(String name);

}
