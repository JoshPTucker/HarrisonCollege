package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCCOURSES database table.
 * 
 */
@Entity
@Table(name="HCCOURSES")
@NamedQuery(name="Hccourse.findAll", query="SELECT h FROM Hccourse h")
public class Hccourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCCOURSES_COURSEID_GENERATOR", sequenceName="HCCOURSES_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCCOURSES_COURSEID_GENERATOR")
	private long courseid;

	private String coursedescription;

	private String coursename;

	private BigDecimal credits;

	private BigDecimal deptnumber;

	private BigDecimal subjectcode;

	//bi-directional many-to-one association to Hcclass
	@OneToMany(mappedBy="hccours")
	private List<Hcclass> hcclasses;

	public Hccourse() {
	}

	public long getCourseid() {
		return this.courseid;
	}

	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}

	public String getCoursedescription() {
		return this.coursedescription;
	}

	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public BigDecimal getDeptnumber() {
		return this.deptnumber;
	}

	public void setDeptnumber(BigDecimal deptnumber) {
		this.deptnumber = deptnumber;
	}

	public BigDecimal getSubjectcode() {
		return this.subjectcode;
	}

	public void setSubjectcode(BigDecimal subjectcode) {
		this.subjectcode = subjectcode;
	}

	public List<Hcclass> getHcclasses() {
		return this.hcclasses;
	}

	public void setHcclasses(List<Hcclass> hcclasses) {
		this.hcclasses = hcclasses;
	}

	public Hcclass addHcclass(Hcclass hcclass) {
		getHcclasses().add(hcclass);
		hcclass.setHccours(this);

		return hcclass;
	}

	public Hcclass removeHcclass(Hcclass hcclass) {
		getHcclasses().remove(hcclass);
		hcclass.setHccours(null);

		return hcclass;
	}

}