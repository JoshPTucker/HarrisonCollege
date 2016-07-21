package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HCCLASSES database table.
 * 
 */
@Entity
@Table(name="HCCLASSES")
@NamedQuery(name="Hcclass.findAll", query="SELECT h FROM Hcclass h")
public class Hcclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCCLASSES_CLASSID_GENERATOR", sequenceName="HCCLASSES_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCCLASSES_CLASSID_GENERATOR")
	private long classid;

	private String crn;

	private String description;

	private String location;

	@Column(name="\"TIME\"")
	private String time;

	//bi-directional many-to-one association to Hcinstructor
	@ManyToOne
	@JoinColumn(name="INSTRUCTORID")
	private Hcinstructor hcinstructor;

	//bi-directional many-to-one association to Hcclassroster
	@OneToMany(mappedBy="hcclass")
	private List<Hcclassroster> hcclassrosters;

	public Hcclass() {
	}

	public long getClassid() {
		return this.classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public String getCrn() {
		return this.crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Hcinstructor getHcinstructor() {
		return this.hcinstructor;
	}

	public void setHcinstructor(Hcinstructor hcinstructor) {
		this.hcinstructor = hcinstructor;
	}

	public List<Hcclassroster> getHcclassrosters() {
		return this.hcclassrosters;
	}

	public void setHcclassrosters(List<Hcclassroster> hcclassrosters) {
		this.hcclassrosters = hcclassrosters;
	}

	public Hcclassroster addHcclassroster(Hcclassroster hcclassroster) {
		getHcclassrosters().add(hcclassroster);
		hcclassroster.setHcclass(this);

		return hcclassroster;
	}

	public Hcclassroster removeHcclassroster(Hcclassroster hcclassroster) {
		getHcclassrosters().remove(hcclassroster);
		hcclassroster.setHcclass(null);

		return hcclassroster;
	}

}