package negocio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the direccionpro database table.
 * 
 */
@Entity
@NamedQuery(name="Direccionpro.findAll", query="SELECT d FROM Direccionpro d")
public class Direccionpro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDireccionPro;

	private String director;

	private String institucion;

	private String nombreEstudiante;

	private int porcentaje;

	private String programaAca;

	private String tipoPro;

	private String tituloPro;

	//bi-directional many-to-one association to Grupoie
	@ManyToOne
	private Grupoie grupoie;

	public Direccionpro() {
	}

	public int getIdDireccionPro() {
		return this.idDireccionPro;
	}

	public void setIdDireccionPro(int idDireccionPro) {
		this.idDireccionPro = idDireccionPro;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getNombreEstudiante() {
		return this.nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public int getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getProgramaAca() {
		return this.programaAca;
	}

	public void setProgramaAca(String programaAca) {
		this.programaAca = programaAca;
	}

	public String getTipoPro() {
		return this.tipoPro;
	}

	public void setTipoPro(String tipoPro) {
		this.tipoPro = tipoPro;
	}

	public String getTituloPro() {
		return this.tituloPro;
	}

	public void setTituloPro(String tituloPro) {
		this.tituloPro = tituloPro;
	}

	public Grupoie getGrupoie() {
		return this.grupoie;
	}

	public void setGrupoie(Grupoie grupoie) {
		this.grupoie = grupoie;
	}

}