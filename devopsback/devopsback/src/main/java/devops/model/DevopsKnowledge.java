package devops.model;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class DevopsKnowledge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "skill")
	private String skill;

	@Column(name = "nivel")
	private Integer nivel;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;


	public DevopsKnowledge() {
		// TODO Auto-generated constructor stub
	}

	public DevopsKnowledge(String skill, Integer nivel, Area area) {
		super();
		this.skill = skill;
		this.nivel = nivel;
		this.area = area;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "DevopsKnowledge [skill=" + skill + ", nivel=" + nivel + "]";

	}

}
