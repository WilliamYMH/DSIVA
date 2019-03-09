package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the grupodirector database table.
 * 
 */
@Entity
@NamedQuery(name="Grupodirector.findAll", query="SELECT g FROM Grupodirector g")
public class Grupodirector implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupoDirector;

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	//bi-directional many-to-one association to Director
	@ManyToOne
	private Director director;

	//bi-directional many-to-one association to Grupoie
	@ManyToOne
	private Grupoie grupoie;

	public Grupodirector() {
	}

	public int getIdGrupoDirector() {
		return this.idGrupoDirector;
	}

	public void setIdGrupoDirector(int idGrupoDirector) {
		this.idGrupoDirector = idGrupoDirector;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Director getDirector() {
		return this.director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Grupoie getGrupoie() {
		return this.grupoie;
	}

	public void setGrupoie(Grupoie grupoie) {
		this.grupoie = grupoie;
	}

}