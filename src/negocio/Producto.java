package negocio;

import java.io.Serializable; 
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProducto;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nombre;
	
	private String responsable;

	//bi-directional many-to-one association to Otraactividad
		@ManyToOne
		@JoinColumn(name="id_OtraActividad")
		private Otraactividad otraactividad;

		//bi-directional many-to-one association to Proyecto
		@ManyToOne
		private Proyecto proyecto;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	public Otraactividad getOtraactividad() {
		return this.otraactividad;
	}

	public void setOtraactividad(Otraactividad otraactividad) {
		this.otraactividad = otraactividad;
	}


	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

}