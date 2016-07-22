package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HCUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Hcuser.findAll", query="SELECT h FROM Hcuser h")
public class Hcuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCUSER_USERID_GENERATOR", sequenceName="HCUSER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCUSER_USERID_GENERATOR")
	private long userid;

	private String email;

	private String firstname;

	private String lastname;

	private String password;

	private String username;

	//bi-directional many-to-one association to Hcinstructor
	@OneToMany(mappedBy="hcuser")
	private List<Hcinstructor> hcinstructors;

	//bi-directional many-to-one association to Hcstudent
	@OneToMany(mappedBy="hcuser")
	private List<Hcstudent> hcstudents;

	public Hcuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Hcinstructor> getHcinstructors() {
		return this.hcinstructors;
	}

	public void setHcinstructors(List<Hcinstructor> hcinstructors) {
		this.hcinstructors = hcinstructors;
	}

	public Hcinstructor addHcinstructor(Hcinstructor hcinstructor) {
		getHcinstructors().add(hcinstructor);
		hcinstructor.setHcuser(this);

		return hcinstructor;
	}

	public Hcinstructor removeHcinstructor(Hcinstructor hcinstructor) {
		getHcinstructors().remove(hcinstructor);
		hcinstructor.setHcuser(null);

		return hcinstructor;
	}

	public List<Hcstudent> getHcstudents() {
		return this.hcstudents;
	}

	public void setHcstudents(List<Hcstudent> hcstudents) {
		this.hcstudents = hcstudents;
	}

	public Hcstudent addHcstudent(Hcstudent hcstudent) {
		getHcstudents().add(hcstudent);
		hcstudent.setHcuser(this);

		return hcstudent;
	}

	public Hcstudent removeHcstudent(Hcstudent hcstudent) {
		getHcstudents().remove(hcstudent);
		hcstudent.setHcuser(null);

		return hcstudent;
	}

}