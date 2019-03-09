package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the otroproducto database table.
 * 
 */
@Entity
@NamedQuery(name="Otroproducto.findAll", query="SELECT o FROM Otroproducto o")
public class Otroproducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOtroProducto;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String nombre;

	private int porcentaje;

	//bi-directional many-to-one association to Otraactividad
	@ManyToOne
	private Otraactividad otraactividad;

	public Otroproducto() {
	}

	public int getIdOtroProducto() {
		return this.idOtroProducto;
	}

	public void setIdOtroProducto(int idOtroProducto) {
		this.idOtroProducto = idOtroProducto;
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

	public int getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Otraactividad getOtraactividad() {
		return this.otraactividad;
	}

	public void setOtraactividad(Otraactividad otraactividad) {
		this.otraactividad = otraactividad;
	}

}