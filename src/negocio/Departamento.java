package negocio;

import java.io.Serializable; 
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDepartamento;

	private String director;

	private String nombre;

	//bi-directional many-to-one association to Facultad
	@ManyToOne
	private Facultad facultad;

	//bi-directional many-to-one association to Grupoie
	@OneToMany(mappedBy="departamento")
	private List<Grupoie> grupoies;
	
	//bi-directional many-to-one association to Direccionpro
	@OneToMany(mappedBy="departamento")
	private List<Direccionpro> direccionpros;

	public Departamento() {
	}

	public int getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return this.facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public List<Direccionpro> getDireccionpros() {
		return this.direccionpros;
	}

	public void setDireccionpros(List<Direccionpro> direccionpros) {
		this.direccionpros = direccionpros;
	}
	
	public List<Grupoie> getGrupoies() {
		return this.grupoies;
	}

	public void setGrupoies(List<Grupoie> grupoies) {
		this.grupoies = grupoies;
	}

	public Grupoie addGrupoy(Grupoie grupoy) {
		getGrupoies().add(grupoy);
		grupoy.setDepartamento(this);

		return grupoy;
	}
	

	public Grupoie removeGrupoy(Grupoie grupoy) {
		getGrupoies().remove(grupoy);
		grupoy.setDepartamento(null);

		return grupoy;
	}

}