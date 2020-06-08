package page.danya.tanderDemo.DTO;

public class StatDTO {

    private String region;
    private int size;

    public StatDTO() {
    }

    public StatDTO(String region, int size) {
        this.region = region;
        this.size = size;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
