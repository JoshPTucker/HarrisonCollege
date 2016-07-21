package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HCCOURSES database table.
 * 
 */
@Entity
@Table(name="HCCOURSES")
@NamedQuery(name="Hccours.findAll", query="SELECT h FROM Hccours h")
public class Hccours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCCOURSES_COURSEID_GENERATOR", sequenceName="HCCOURSES_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCCOURSES_COURSEID_GENERATOR")
	private long courseid;

	private String coursedescription;

	private String crn;

	private String dept;

	public Hccours() {
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

	public String getCrn() {
		return this.crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}