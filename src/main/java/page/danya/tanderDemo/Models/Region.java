package page.danya.tanderDemo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Region {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "region")
    private List<City> cityList;

    public Region() {
    }

    public Region(int id, String name, List<City> cityList) {
        this.id = id;
        this.name = name;
        this.cityList = cityList;
    }

    public Region(String name, List<City> cityList) {
        this.name = name;
        this.cityList = cityList;
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

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
