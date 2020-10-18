package devops.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "areas")
public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2221223696244362538L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nombreArea")
	private Integer nombreArea;
	

    @ManyToMany(mappedBy = "areas", fetch = FetchType.LAZY)
    private Set<User> usuarios = new HashSet<>();
    
    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<DevopsKnowledge> skills;
	
	public Area() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(Integer nombreArea) {
		this.nombreArea = nombreArea;
	}

//	public Set<User> getStudents() {
//		return students;
//	}
//
//	public void setStudents(Set<User> students) {
//		this.students = students;
//	}

	public Area(long id, Integer nombreArea, Set<DevopsKnowledge> skills) {
		super();
		this.id = id;
		this.nombreArea = nombreArea;
		this.skills = skills;
	}

	public Set<DevopsKnowledge> getSkills() {
		return skills;
	}

	public void setSkills(Set<DevopsKnowledge> skills) {
		this.skills = skills;
	}

//	@Override
//	public String toString() {
//		return "AreaDevops [id=" + id + ", nombreArea=" + nombreArea + ", students=" + students + "]";
//	}



}
