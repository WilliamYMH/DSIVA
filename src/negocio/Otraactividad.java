package negocio;

import java.io.Serializable; 
import javax.persistence.*;
import java.util.ArrayList;
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

	private String responsable;

	//bi-directional many-to-one association to Grupoie
	@ManyToOne
	private Grupoie grupoie;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="otraactividad")
	private List<Producto> productos;


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

	public Grupoie getGrupoie() {
		return this.grupoie;
	}

	public void setGrupoie(Grupoie grupoie) {
		this.grupoie = grupoie;
	}


	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setOtraactividad(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setOtraactividad(null);

		return producto;
	}

}