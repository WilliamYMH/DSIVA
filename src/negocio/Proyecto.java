package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProyecto;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	@Lob
	private String objetivo;

	private int porcentaje;

	private String proyecto;

	private String responzable;

	//bi-directional many-to-one association to Actividadpro
	@OneToMany(mappedBy="proyecto")
	private List<Actividadpro> actividadpros;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="proyecto")
	private List<Producto> productos;

	//bi-directional many-to-one association to Lineainvesrigacion
	@ManyToOne
	private Lineainvesrigacion lineainvesrigacion;

	public Proyecto() {
	}

	public int getIdProyecto() {
		return this.idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public int getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public String getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getResponzable() {
		return this.responzable;
	}

	public void setResponzable(String responzable) {
		this.responzable = responzable;
	}

	public List<Actividadpro> getActividadpros() {
		return this.actividadpros;
	}

	public void setActividadpros(List<Actividadpro> actividadpros) {
		this.actividadpros = actividadpros;
	}

	public Actividadpro addActividadpro(Actividadpro actividadpro) {
		getActividadpros().add(actividadpro);
		actividadpro.setProyecto(this);

		return actividadpro;
	}

	public Actividadpro removeActividadpro(Actividadpro actividadpro) {
		getActividadpros().remove(actividadpro);
		actividadpro.setProyecto(null);

		return actividadpro;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setProyecto(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setProyecto(null);

		return producto;
	}

	public Lineainvesrigacion getLineainvesrigacion() {
		return this.lineainvesrigacion;
	}

	public void setLineainvesrigacion(Lineainvesrigacion lineainvesrigacion) {
		this.lineainvesrigacion = lineainvesrigacion;
	}

}