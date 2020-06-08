package page.danya.tanderDemo.DTO;

import page.danya.tanderDemo.Models.City;
import page.danya.tanderDemo.Models.Comment;
import page.danya.tanderDemo.Models.Region;

public class CommentDTO {

    private String lastname;
    private String firstname;
    private String middlename;
    private String telnumber;
    private String email;
    private String commentText;
    private String region;
    private String city;
    private int id;

    public CommentDTO(String lastname, String firstname, String middlename, String telnumber, String email, String commentText, String region, String city) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.telnumber = telnumber;
        this.email = email;
        this.commentText = commentText;
        this.region = region;
        this.city = city;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.firstname = comment.getFirstname();
        this.lastname = comment.getLastname();
        this.middlename = comment.getMiddlename();
        this.city = comment.getCity().getName();
        this.region = comment.getCity().getRegion().getName();
        this.email = comment.getEmail();
        this.telnumber = comment.getTelnumber();
        this.commentText = comment.getCommentText();
    }
}
