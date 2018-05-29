package app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "city")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    //necesar pt ca automat transforma camelCase in camel_case
    //atunci cand mapeaza proprietatea la coloana
    @Column(name = "countrycode")
    private String countryCode;

    private Long population;

    public City(Long id, @NotBlank String name,
                String countryCode, Long population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.population = population;
    }

    public City(@NotBlank String name, @NotBlank String countryCode, Long population) {
        this.name = name;
        this.countryCode = countryCode;
        this.population = population;
    }

    public City(@NotBlank String name, String countryCode) {
        this.name = name;
        this.countryCode = countryCode;
    }

    public City() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

}
