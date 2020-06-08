package page.danya.tanderDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import page.danya.tanderDemo.Models.City;
import page.danya.tanderDemo.Repository.CityRepo;
import page.danya.tanderDemo.Repository.RegionRepo;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class CityController {




    @Autowired
    private CityRepo cityRepository;

    @Autowired
    private RegionRepo regionRepository;


    @GetMapping("/cities")
    public ResponseEntity regions(@RequestParam String region){



        List<String> dto = new ArrayList<>();

        List<City> cityList = cityRepository.findByRegion(regionRepository.findByName(region).get());





        cityList.stream().forEach(
                city -> {
                    dto.add(city.getName());
                }
        );



        return ResponseEntity.ok(dto);
    }

}
