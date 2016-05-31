package ie.nuim.hotstat.entity;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the report database table.
 * 
 */
@Entity
public class Report {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Timestamp created;

	//uni-directional many-to-one association to Profile
	@ManyToOne
	private Profile profile;

	//bi-directional many-to-one association to Project
	@ManyToOne
	private Project project;

	public Report() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}