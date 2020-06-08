package page.danya.tanderDemo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import page.danya.tanderDemo.DTO.CommentDTO;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String lastname;
    private String firstname;
    private String middlename;
    private String telnumber;
    private String email;
    private String commentText;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Comment() {
    }

    public Comment(int id, String lastname, String firstname, String middlename, String telnumber, String email, String comment) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.telnumber = telnumber;
        this.email = email;
        this.commentText = comment;
    }

    public Comment(String lastname, String firstname, String middlename, String telnumber, String email, String comment) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.telnumber = telnumber;
        this.email = email;
        this.commentText = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Comment(int id, String lastname, String firstname, String middlename, String telnumber, String email, String commentText, City city) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.telnumber = telnumber;
        this.email = email;
        this.commentText = commentText;
        this.city = city;
    }

    public Comment(String lastname, String firstname, String middlename, String telnumber, String email, String commentText, City city) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.telnumber = telnumber;
        this.email = email;
        this.commentText = commentText;
        this.city = city;
    }

    public Comment(CommentDTO dto){
        this.lastname = dto.getLastname();
        this.firstname = dto.getFirstname();
        this.middlename = dto.getMiddlename();
        this.telnumber = dto.getTelnumber();
        this.email = dto.getEmail();
        this.commentText = dto.getCommentText();
    }
}
