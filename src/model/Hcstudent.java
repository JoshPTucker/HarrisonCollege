package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HCSTUDENTS database table.
 * 
 */
@Entity
@Table(name="HCSTUDENTS")
@NamedQuery(name="Hcstudent.findAll", query="SELECT h FROM Hcstudent h")
public class Hcstudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCSTUDENTS_STUDENTID_GENERATOR", sequenceName="HCSTUDENTS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCSTUDENTS_STUDENTID_GENERATOR")
	private long studentid;

	private String entryyear;

	private String firstname;

	private String lastname;

	private String major;

	//bi-directional many-to-one association to Hcclassroster
	@OneToMany(mappedBy="hcstudent")
	private List<Hcclassroster> hcclassrosters;

	//bi-directional many-to-one association to Hcuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Hcuser hcuser;

	public Hcstudent() {
	}

	public long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getEntryyear() {
		return this.entryyear;
	}

	public void setEntryyear(String entryyear) {
		this.entryyear = entryyear;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<Hcclassroster> getHcclassrosters() {
		return this.hcclassrosters;
	}

	public void setHcclassrosters(List<Hcclassroster> hcclassrosters) {
		this.hcclassrosters = hcclassrosters;
	}

	public Hcclassroster addHcclassroster(Hcclassroster hcclassroster) {
		getHcclassrosters().add(hcclassroster);
		hcclassroster.setHcstudent(this);

		return hcclassroster;
	}

	public Hcclassroster removeHcclassroster(Hcclassroster hcclassroster) {
		getHcclassrosters().remove(hcclassroster);
		hcclassroster.setHcstudent(null);

		return hcclassroster;
	}

	public Hcuser getHcuser() {
		return this.hcuser;
	}

	public void setHcuser(Hcuser hcuser) {
		this.hcuser = hcuser;
	}

}