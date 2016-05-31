package ie.nuim.hotstat.entity;

import java.util.List;
import javax.persistence.*;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
    
    @ManyToMany
    @JoinTable(name="profile_measure", joinColumns = @JoinColumn(name = "profile_id"), inverseJoinColumns = @JoinColumn(name = "measure_id"))
    private List<Measure> measures;

    public Profile() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(List<Measure> measures) {
        this.measures = measures;
    }
    
}