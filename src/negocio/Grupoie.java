package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupoie database table.
 * 
 */
@Entity
@NamedQuery(name="Grupoie.findAll", query="SELECT g FROM Grupoie g")
public class Grupoie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupoIE;

	private String nombre;

	private String unidadAcademica;

	//bi-directional many-to-one association to Direccionpro
	@OneToMany(mappedBy="grupoie")
	private List<Direccionpro> direccionpros;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="grupoie")
	private List<Evento> eventos;

	//bi-directional many-to-one association to Grupodirector
	@OneToMany(mappedBy="grupoie")
	private List<Grupodirector> grupodirectors;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	private Departamento departamento;

	//bi-directional many-to-one association to Grupointegrante
	@OneToMany(mappedBy="grupoie")
	private List<Grupointegrante> grupointegrantes;

	//bi-directional many-to-one association to Lineainvesrigacion
	@OneToMany(mappedBy="grupoie")
	private List<Lineainvesrigacion> lineainvesrigacions;

	//bi-directional many-to-one association to Otraactividad
	@OneToMany(mappedBy="grupoie")
	private List<Otraactividad> otraactividads;

	public Grupoie() {
	}

	public int getIdGrupoIE() {
		return this.idGrupoIE;
	}

	public void setIdGrupoIE(int idGrupoIE) {
		this.idGrupoIE = idGrupoIE;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidadAcademica() {
		return this.unidadAcademica;
	}

	public void setUnidadAcademica(String unidadAcademica) {
		this.unidadAcademica = unidadAcademica;
	}

	public List<Direccionpro> getDireccionpros() {
		return this.direccionpros;
	}

	public void setDireccionpros(List<Direccionpro> direccionpros) {
		this.direccionpros = direccionpros;
	}

	public Direccionpro addDireccionpro(Direccionpro direccionpro) {
		getDireccionpros().add(direccionpro);
		direccionpro.setGrupoie(this);

		return direccionpro;
	}

	public Direccionpro removeDireccionpro(Direccionpro direccionpro) {
		getDireccionpros().remove(direccionpro);
		direccionpro.setGrupoie(null);

		return direccionpro;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setGrupoie(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setGrupoie(null);

		return evento;
	}

	public List<Grupodirector> getGrupodirectors() {
		return this.grupodirectors;
	}

	public void setGrupodirectors(List<Grupodirector> grupodirectors) {
		this.grupodirectors = grupodirectors;
	}

	public Grupodirector addGrupodirector(Grupodirector grupodirector) {
		getGrupodirectors().add(grupodirector);
		grupodirector.setGrupoie(this);

		return grupodirector;
	}

	public Grupodirector removeGrupodirector(Grupodirector grupodirector) {
		getGrupodirectors().remove(grupodirector);
		grupodirector.setGrupoie(null);

		return grupodirector;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Grupointegrante> getGrupointegrantes() {
		return this.grupointegrantes;
	}

	public void setGrupointegrantes(List<Grupointegrante> grupointegrantes) {
		this.grupointegrantes = grupointegrantes;
	}

	public Grupointegrante addGrupointegrante(Grupointegrante grupointegrante) {
		getGrupointegrantes().add(grupointegrante);
		grupointegrante.setGrupoie(this);

		return grupointegrante;
	}

	public Grupointegrante removeGrupointegrante(Grupointegrante grupointegrante) {
		getGrupointegrantes().remove(grupointegrante);
		grupointegrante.setGrupoie(null);

		return grupointegrante;
	}

	public List<Lineainvesrigacion> getLineainvesrigacions() {
		return this.lineainvesrigacions;
	}

	public void setLineainvesrigacions(List<Lineainvesrigacion> lineainvesrigacions) {
		this.lineainvesrigacions = lineainvesrigacions;
	}

	public Lineainvesrigacion addLineainvesrigacion(Lineainvesrigacion lineainvesrigacion) {
		getLineainvesrigacions().add(lineainvesrigacion);
		lineainvesrigacion.setGrupoie(this);

		return lineainvesrigacion;
	}

	public Lineainvesrigacion removeLineainvesrigacion(Lineainvesrigacion lineainvesrigacion) {
		getLineainvesrigacions().remove(lineainvesrigacion);
		lineainvesrigacion.setGrupoie(null);

		return lineainvesrigacion;
	}

	public List<Otraactividad> getOtraactividads() {
		return this.otraactividads;
	}

	public void setOtraactividads(List<Otraactividad> otraactividads) {
		this.otraactividads = otraactividads;
	}

	public Otraactividad addOtraactividad(Otraactividad otraactividad) {
		getOtraactividads().add(otraactividad);
		otraactividad.setGrupoie(this);

		return otraactividad;
	}

	public Otraactividad removeOtraactividad(Otraactividad otraactividad) {
		getOtraactividads().remove(otraactividad);
		otraactividad.setGrupoie(null);

		return otraactividad;
	}

}