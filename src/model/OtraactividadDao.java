package model;

import negocio.Otraactividad;
import util.Conexion;

public class OtraactividadDao extends Conexion<Otraactividad> implements GenericDao<Otraactividad> {
	public OtraactividadDao() {
		super(Otraactividad.class)
;	}
}
