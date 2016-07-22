package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCCLASSROOMS database table.
 * 
 */
@Entity
@Table(name="HCCLASSROOMS")
@NamedQuery(name="Hcclassroom.findAll", query="SELECT h FROM Hcclassroom h")
public class Hcclassroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCCLASSROOMS_CLASSROOMID_GENERATOR", sequenceName="HCCLASSROOMS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCCLASSROOMS_CLASSROOMID_GENERATOR")
	private long classroomid;

	private String buildingname;

	private BigDecimal maxcapacity;

	private BigDecimal roomnumber;

	//bi-directional many-to-one association to Hcclass
	@OneToMany(mappedBy="hcclassroom")
	private List<Hcclass> hcclasses;

	public Hcclassroom() {
	}

	public long getClassroomid() {
		return this.classroomid;
	}

	public void setClassroomid(long classroomid) {
		this.classroomid = classroomid;
	}

	public String getBuildingname() {
		return this.buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public BigDecimal getMaxcapacity() {
		return this.maxcapacity;
	}

	public void setMaxcapacity(BigDecimal maxcapacity) {
		this.maxcapacity = maxcapacity;
	}

	public BigDecimal getRoomnumber() {
		return this.roomnumber;
	}

	public void setRoomnumber(BigDecimal roomnumber) {
		this.roomnumber = roomnumber;
	}

	public List<Hcclass> getHcclasses() {
		return this.hcclasses;
	}

	public void setHcclasses(List<Hcclass> hcclasses) {
		this.hcclasses = hcclasses;
	}

	public Hcclass addHcclass(Hcclass hcclass) {
		getHcclasses().add(hcclass);
		hcclass.setHcclassroom(this);

		return hcclass;
	}

	public Hcclass removeHcclass(Hcclass hcclass) {
		getHcclasses().remove(hcclass);
		hcclass.setHcclassroom(null);

		return hcclass;
	}

}