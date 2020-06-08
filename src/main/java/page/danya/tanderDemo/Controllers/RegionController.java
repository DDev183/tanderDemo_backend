package page.danya.tanderDemo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import page.danya.tanderDemo.DTO.CommentDTO;
import page.danya.tanderDemo.Models.Comment;
import page.danya.tanderDemo.Models.Region;
import page.danya.tanderDemo.Repository.CityRepo;
import page.danya.tanderDemo.Repository.CommentRepo;
import page.danya.tanderDemo.Repository.RegionRepo;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin()
@RestController
public class RegionController {


    @Autowired
    private RegionRepo regionRepository;

    @GetMapping("/regions")
    public ResponseEntity regions(){

        List<String> dto = new ArrayList<>();

        List<Region> regionList = regionRepository.findAll();

        regionList.stream().forEach(
                region -> {
                    dto.add(region.getName());
                }
        );

        return ResponseEntity.ok(dto);
    }

}
