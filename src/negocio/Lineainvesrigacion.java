package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the lineainvesrigacion database table.
 * 
 */
@Entity
@NamedQuery(name="Lineainvesrigacion.findAll", query="SELECT l FROM Lineainvesrigacion l")
public class Lineainvesrigacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLineaInvesrigacion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String liderLinea;

	private String lineaInvesrigacion;

	//bi-directional many-to-one association to Grupoie
	@ManyToOne
	private Grupoie grupoie;

	//bi-directional many-to-one association to Proyecto
	@OneToMany(mappedBy="lineainvesrigacion")
	private List<Proyecto> proyectos;

	public Lineainvesrigacion() {
	}

	public int getIdLineaInvesrigacion() {
		return this.idLineaInvesrigacion;
	}

	public void setIdLineaInvesrigacion(int idLineaInvesrigacion) {
		this.idLineaInvesrigacion = idLineaInvesrigacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLiderLinea() {
		return this.liderLinea;
	}

	public void setLiderLinea(String liderLinea) {
		this.liderLinea = liderLinea;
	}

	public String getLineaInvesrigacion() {
		return this.lineaInvesrigacion;
	}

	public void setLineaInvesrigacion(String lineaInvesrigacion) {
		this.lineaInvesrigacion = lineaInvesrigacion;
	}

	public Grupoie getGrupoie() {
		return this.grupoie;
	}

	public void setGrupoie(Grupoie grupoie) {
		this.grupoie = grupoie;
	}

	public List<Proyecto> getProyectos() {
		return this.proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		getProyectos().add(proyecto);
		proyecto.setLineainvesrigacion(this);

		return proyecto;
	}

	public Proyecto removeProyecto(Proyecto proyecto) {
		getProyectos().remove(proyecto);
		proyecto.setLineainvesrigacion(null);

		return proyecto;
	}

}