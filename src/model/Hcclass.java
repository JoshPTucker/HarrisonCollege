package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
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
	@SequenceGenerator(name="HCCLASSES_CRN_GENERATOR", sequenceName="HCCLASSES_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCCLASSES_CRN_GENERATOR")
	private long crn;

	private BigDecimal subjectcode;

	private String times;

	//bi-directional many-to-one association to Hcclassroom
	@ManyToOne
	@JoinColumn(name="CLASSROOMID")
	private Hcclassroom hcclassroom;

	//bi-directional many-to-one association to Hccourse
	@ManyToOne
	@JoinColumn(name="COURSEID")
	private Hccourse hccours;

	//bi-directional many-to-one association to Hcinstructor
	@ManyToOne
	@JoinColumn(name="INSTRUCTORID")
	private Hcinstructor hcinstructor;

	//bi-directional many-to-one association to Hcclassroster
	@OneToMany(mappedBy="hcclass")
	private List<Hcclassroster> hcclassrosters;

	public Hcclass() {
	}

	public long getCrn() {
		return this.crn;
	}

	public void setCrn(long crn) {
		this.crn = crn;
	}

	public BigDecimal getSubjectcode() {
		return this.subjectcode;
	}

	public void setSubjectcode(BigDecimal subjectcode) {
		this.subjectcode = subjectcode;
	}

	public String getTimes() {
		return this.times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public Hcclassroom getHcclassroom() {
		return this.hcclassroom;
	}

	public void setHcclassroom(Hcclassroom hcclassroom) {
		this.hcclassroom = hcclassroom;
	}

	public Hccourse getHccours() {
		return this.hccours;
	}

	public void setHccours(Hccourse hccours) {
		this.hccours = hccours;
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