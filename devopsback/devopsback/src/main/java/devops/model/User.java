package devops.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8755294667305923771L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "numeroEmpleado")
	private Integer numeroEmpleado;

	@Column(name = "nombre")
	private String Nombre;

	@Column(name = "apellidos")
	private String Apellidos;
	


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "users_areas", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "area_id", referencedColumnName = "id", nullable = false, updatable = false) })

	private Set<Area> areas = new HashSet<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(Integer numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

//	public Set<AreaDevops> getAreas() {
//		return areas;
//	}
//
//	public void setAreas(Set<AreaDevops> areas) {
//		this.areas = areas;
//	}

	public User(long id, Integer numeroEmpleado, String nombre, String apellidos) {
		super();
		this.id = id;
		this.numeroEmpleado = numeroEmpleado;
		Nombre = nombre;
		Apellidos = apellidos;
//		this.areas = areas;
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", numeroEmpleado=" + numeroEmpleado + ", Nombre=" + Nombre + ", Apellidos="
//				+ Apellidos + ", areas=" + areas + "]";
//	}

}
