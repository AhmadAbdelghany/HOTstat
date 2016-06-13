package ie.nuim.hotstat.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import ie.nuim.hotstat.entity.DbCredential;

/**
 * The persistent class for the project database table.
 * 
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    
    private Integer srid;
    
    private Integer scale;
    
    // uni-directional one-to-one association to DbCredential
    @OneToOne
    @JoinColumn(name = "db_credentials")
    @JsonIgnore
    private DbCredential dbCredential;

    // bi-directional many-to-one association to Report
    @OneToMany(mappedBy = "project")
    @JsonBackReference
    private List<Report> reports;

    public Project() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSrid() {
        return srid;
    }

    public void setSrid(Integer srid) {
        this.srid = srid;
    }
    
    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public DbCredential getDbCredential() {
        return this.dbCredential;
    }

    public void setDbCredential(DbCredential dbCredential) {
        this.dbCredential = dbCredential;
    }

    public List<Report> getReports() {
        return this.reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Report addReport(Report report) {
        getReports().add(report);
        report.setProject(this);
        return report;
    }

    public Report removeReport(Report report) {
        getReports().remove(report);
        report.setProject(null);
        return report;
    }
    
    

}