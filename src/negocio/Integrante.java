package negocio;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the integrante database table.
 * 
 */
@Entity
@NamedQuery(name="Integrante.findAll", query="SELECT i FROM Integrante i")
public class Integrante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIntegrante;

	private String apellido;

	private String edad;

	private String email;

	private String identificacion;

	private String nombre;

	private String password;

	//bi-directional many-to-one association to Grupointegrante
	@OneToMany(mappedBy="integrante")
	private List<Grupointegrante> grupointegrantes;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	private Cargo cargo;

	public Integrante() {
		grupointegrantes=new ArrayList<Grupointegrante>();
	}

	public int getIdIntegrante() {
		return this.idIntegrante;
	}

	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEdad() {
		return this.edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Grupointegrante> getGrupointegrantes() {
		return this.grupointegrantes;
	}

	public void setGrupointegrantes(List<Grupointegrante> grupointegrantes) {
		this.grupointegrantes = grupointegrantes;
	}

	public Grupointegrante addGrupointegrante(Grupointegrante grupointegrante) {
		getGrupointegrantes().add(grupointegrante);
		grupointegrante.setIntegrante(this);

		return grupointegrante;
	}

	public Grupointegrante removeGrupointegrante(Grupointegrante grupointegrante) {
		getGrupointegrantes().remove(grupointegrante);
		grupointegrante.setIntegrante(null);

		return grupointegrante;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

}