package pl.com.filmweb.model;

import javax.persistence.*;

@Entity
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private int productionYear;

    public Movie() {
    }

    public Movie(Long id, String title, int productionYear) {
        this.id = id;
        this.title = title;
        this.productionYear = productionYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }
}
