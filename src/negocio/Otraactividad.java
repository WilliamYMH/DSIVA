package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the otraactividad database table.
 * 
 */
@Entity
@NamedQuery(name="Otraactividad.findAll", query="SELECT o FROM Otraactividad o")
public class Otraactividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOtraActividad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nombre;

	private int porcentaje;

	private String responzable;

	//bi-directional many-to-one association to Grupoie
	@ManyToOne
	private Grupoie grupoie;

	//bi-directional many-to-one association to Otroproducto
	@OneToMany(mappedBy="otraactividad")
	private List<Otroproducto> otroproductos;

	public Otraactividad() {
	}

	public int getIdOtraActividad() {
		return this.idOtraActividad;
	}

	public void setIdOtraActividad(int idOtraActividad) {
		this.idOtraActividad = idOtraActividad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getResponzable() {
		return this.responzable;
	}

	public void setResponzable(String responzable) {
		this.responzable = responzable;
	}

	public Grupoie getGrupoie() {
		return this.grupoie;
	}

	public void setGrupoie(Grupoie grupoie) {
		this.grupoie = grupoie;
	}

	public List<Otroproducto> getOtroproductos() {
		return this.otroproductos;
	}

	public void setOtroproductos(List<Otroproducto> otroproductos) {
		this.otroproductos = otroproductos;
	}

	public Otroproducto addOtroproducto(Otroproducto otroproducto) {
		getOtroproductos().add(otroproducto);
		otroproducto.setOtraactividad(this);

		return otroproducto;
	}

	public Otroproducto removeOtroproducto(Otroproducto otroproducto) {
		getOtroproductos().remove(otroproducto);
		otroproducto.setOtraactividad(null);

		return otroproducto;
	}

}