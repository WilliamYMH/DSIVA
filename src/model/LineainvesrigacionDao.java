package model;

import negocio.Lineainvesrigacion;
import util.Conexion;

public class LineainvesrigacionDao extends Conexion<Lineainvesrigacion> implements GenericDao<Lineainvesrigacion> {
public LineainvesrigacionDao() {
	super(Lineainvesrigacion.class);
}
}
