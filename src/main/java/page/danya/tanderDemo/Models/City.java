package page.danya.tanderDemo.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


    @OneToMany(mappedBy = "city")
    private List<Comment> comment;

    public City() {
    }

    public City(int id, String name, Region region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public City(String name, Region region) {
        this.name = name;
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }


    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
