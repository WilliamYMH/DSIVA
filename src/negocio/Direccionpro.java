package negocio;


import java.io.Serializable;
import javax.persistence.*;

import converters.NivelAcademicoEnumConverter;


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

	private String nombreEstudiante;

	private int porcentaje;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="departamento_id")
	private Departamento departamento;
	
	@JoinColumn(name="NivelAcademico")
	@Convert(converter = NivelAcademicoEnumConverter.class)
	private NivelAcademicoEnum nivelAcademico;

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
	
	public Departamento getDepartamento(){
		return this.departamento;
	}
	
	public void setDepartamento(Departamento departamento){
		this.departamento=departamento;
	}

	public NivelAcademicoEnum getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(NivelAcademicoEnum nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

}