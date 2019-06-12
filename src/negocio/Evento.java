package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEvento;

	private String caracter;

	@Temporal(TemporalType.DATE)
	private Date fecha;
	private String nombre;
	private int porcentaje;

	private String responsable;

	//bi-directional many-to-one association to Grupoie
	@ManyToOne
	private Grupoie grupoie;

	public Evento() {
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getCaracter() {
		return this.caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
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

	public String getResponsable() {
		return this.responsable;
	}

	public void setResponsable(String responzable) {
		this.responsable = responzable;
	}

	public Grupoie getGrupoie() {
		return this.grupoie;
	}

	public void setGrupoie(Grupoie grupoie) {
		this.grupoie = grupoie;
	}

}