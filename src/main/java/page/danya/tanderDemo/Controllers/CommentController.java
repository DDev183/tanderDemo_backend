package page.danya.tanderDemo.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import page.danya.tanderDemo.DTO.CommentDTO;
import page.danya.tanderDemo.DTO.StatDTO;
import page.danya.tanderDemo.Models.Comment;
import page.danya.tanderDemo.Models.Region;
import page.danya.tanderDemo.Repository.CityRepo;
import page.danya.tanderDemo.Repository.CommentRepo;
import page.danya.tanderDemo.Repository.RegionRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class CommentController {


    @Autowired
    private CommentRepo commentRepository;

    @Autowired
    private CityRepo cityRepository;

    @Autowired
    private RegionRepo regionRepository;

    @PostMapping("/comment")
    public ResponseEntity comment(@RequestBody CommentDTO dto){

        System.out.println(dto.toString());

        Comment comment = new Comment(dto);
        comment.setCity(cityRepository.findByName(dto.getCity()).get());

        commentRepository.save(comment);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/all")
    public ResponseEntity getAllWithParam(@RequestParam String id){


        if (!id.equalsIgnoreCase("null")) {
            commentRepository.delete(commentRepository.findById(Integer.parseInt(id)).get());
        }

        List<CommentDTO> dto = new ArrayList<>();

        commentRepository.findAll().stream().forEach(
                comment -> {
                    dto.add(new CommentDTO(comment));
                }
        );


        return ResponseEntity.ok(dto);
    }

    @GetMapping("/stat")
    public ResponseEntity stat(){

        List<StatDTO> dto = new ArrayList<>();

        List<Comment> comments = commentRepository.findAll();



        regionRepository.findAll().stream().forEach(region -> {
            int counter = (int) comments.stream().filter(comment -> comment.getCity().getRegion().getName().equalsIgnoreCase(region.getName())).count();
            if (counter >= 5){
                dto.add(new StatDTO(region.getName(), counter));
            }
        });


        List<StatDTO> finalDto = dto.stream()
                .sorted(Comparator.comparingInt(StatDTO::getSize).reversed())
                .collect(Collectors.toList());

        return ResponseEntity.ok(finalDto);
    }


    @GetMapping("/regionStat")
    public ResponseEntity regionStat(@RequestParam String region){

        List<StatDTO> dto = new ArrayList<>();

        Region thisRegion = regionRepository.findByName(region).get();

        List<Comment> comments = commentRepository.findAll();

        cityRepository.findByRegion(thisRegion).stream().forEach(city -> {
            int counter = (int) comments.stream().filter(comment -> comment.getCity().getName().equalsIgnoreCase(city.getName())).count();
            dto.add(new StatDTO(city.getName(), counter));
        });

        List<StatDTO> finalDto = dto.stream()
                .sorted(Comparator.comparingInt(StatDTO::getSize).reversed())
                .collect(Collectors.toList());


        return ResponseEntity.ok(finalDto);
    }
}
