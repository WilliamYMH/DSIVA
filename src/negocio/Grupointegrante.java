package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the grupointegrante database table.
 * 
 */
@Entity
@NamedQuery(name="Grupointegrante.findAll", query="SELECT g FROM Grupointegrante g")
public class Grupointegrante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupoIntegrante;

	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	//bi-directional many-to-one association to Grupoie
	@ManyToOne
	private Grupoie grupoie;

	//bi-directional many-to-one association to Integrante
	@ManyToOne
	private Integrante integrante;

	public Grupointegrante() {
	}

	public int getIdGrupoIntegrante() {
		return this.idGrupoIntegrante;
	}

	public void setIdGrupoIntegrante(int idGrupoIntegrante) {
		this.idGrupoIntegrante = idGrupoIntegrante;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Grupoie getGrupoie() {
		return this.grupoie;
	}

	public void setGrupoie(Grupoie grupoie) {
		this.grupoie = grupoie;
	}

	public Integrante getIntegrante() {
		return this.integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

}