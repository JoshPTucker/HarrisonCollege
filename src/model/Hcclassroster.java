package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HCCLASSROSTER database table.
 * 
 */
@Entity
@NamedQuery(name="Hcclassroster.findAll", query="SELECT h FROM Hcclassroster h")
public class Hcclassroster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCCLASSROSTER_ROSTERID_GENERATOR", sequenceName="HCCLASSROSTER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCCLASSROSTER_ROSTERID_GENERATOR")
	private long rosterid;

	//bi-directional many-to-one association to Hcclass
	@ManyToOne
	@JoinColumn(name="CRN")
	private Hcclass hcclass;

	//bi-directional many-to-one association to Hcstudent
	@ManyToOne
	@JoinColumn(name="STUDENTID")
	private Hcstudent hcstudent;

	public Hcclassroster() {
	}

	public long getRosterid() {
		return this.rosterid;
	}

	public void setRosterid(long rosterid) {
		this.rosterid = rosterid;
	}

	public Hcclass getHcclass() {
		return this.hcclass;
	}

	public void setHcclass(Hcclass hcclass) {
		this.hcclass = hcclass;
	}

	public Hcstudent getHcstudent() {
		return this.hcstudent;
	}

	public void setHcstudent(Hcstudent hcstudent) {
		this.hcstudent = hcstudent;
	}

}