package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCINSTRUCTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Hcinstructor.findAll", query="SELECT h FROM Hcinstructor h")
public class Hcinstructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCINSTRUCTOR_INSTRUCTORID_GENERATOR", sequenceName="HCINSTRUCTOR_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCINSTRUCTOR_INSTRUCTORID_GENERATOR")
	private long instructorid;

	private BigDecimal deptnumber;

	private String firstname;

	private String lastname;

	private BigDecimal officenumber;

	//bi-directional many-to-one association to Hcclass
	@OneToMany(mappedBy="hcinstructor")
	private List<Hcclass> hcclasses;

	//bi-directional many-to-one association to Hcuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Hcuser hcuser;

	public Hcinstructor() {
	}

	public long getInstructorid() {
		return this.instructorid;
	}

	public void setInstructorid(long instructorid) {
		this.instructorid = instructorid;
	}

	public BigDecimal getDeptnumber() {
		return this.deptnumber;
	}

	public void setDeptnumber(BigDecimal deptnumber) {
		this.deptnumber = deptnumber;
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

	public BigDecimal getOfficenumber() {
		return this.officenumber;
	}

	public void setOfficenumber(BigDecimal officenumber) {
		this.officenumber = officenumber;
	}

	public List<Hcclass> getHcclasses() {
		return this.hcclasses;
	}

	public void setHcclasses(List<Hcclass> hcclasses) {
		this.hcclasses = hcclasses;
	}

	public Hcclass addHcclass(Hcclass hcclass) {
		getHcclasses().add(hcclass);
		hcclass.setHcinstructor(this);

		return hcclass;
	}

	public Hcclass removeHcclass(Hcclass hcclass) {
		getHcclasses().remove(hcclass);
		hcclass.setHcinstructor(null);

		return hcclass;
	}

	public Hcuser getHcuser() {
		return this.hcuser;
	}

	public void setHcuser(Hcuser hcuser) {
		this.hcuser = hcuser;
	}

}