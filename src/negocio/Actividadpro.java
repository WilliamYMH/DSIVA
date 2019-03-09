package negocio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the actividadpro database table.
 * 
 */
@Entity
@NamedQuery(name="Actividadpro.findAll", query="SELECT a FROM Actividadpro a")
public class Actividadpro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idActividadPro;

	private String descripcion;

	private String nombreActividad;

	//bi-directional many-to-one association to Proyecto
	@ManyToOne
	private Proyecto proyecto;

	public Actividadpro() {
	}

	public int getIdActividadPro() {
		return this.idActividadPro;
	}

	public void setIdActividadPro(int idActividadPro) {
		this.idActividadPro = idActividadPro;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreActividad() {
		return this.nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public Proyecto getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}