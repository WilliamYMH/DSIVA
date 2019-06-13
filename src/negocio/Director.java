package negocio;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the director database table.
 * 
 */
@Entity
@NamedQuery(name="Director.findAll", query="SELECT d FROM Director d")
public class Director implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDirector;

	private String apellido;

	private String email;

	private String identificacion;

	private String nombre;

	private String password;

	
	//bi-directional many-to-one association to Grupodirector
	@OneToMany(mappedBy="director")
	private List<Grupodirector> grupodirectors;
	
	public Director(){
		grupodirectors=new ArrayList<>();
	}

	public int getIdDirector() {
		return this.idDirector;
	}

	public void setIdDirector(int idDirector) {
		this.idDirector = idDirector;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public List<Grupodirector> getGrupodirectors() {
		return this.grupodirectors;
	}

	public void setGrupodirectors(ArrayList<Grupodirector> grupodirectors) {
		this.grupodirectors = grupodirectors;
	}

	public Grupodirector addGrupodirector(Grupodirector grupodirector) {
		getGrupodirectors().add(grupodirector);
		grupodirector.setDirector(this);

		return grupodirector;
	}

	public Grupodirector removeGrupodirector(Grupodirector grupodirector) {
		getGrupodirectors().remove(grupodirector);
		grupodirector.setDirector(null);

		return grupodirector;
	}



}