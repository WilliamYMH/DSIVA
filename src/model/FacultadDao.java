package model;

import negocio.Facultad;
import util.Conexion;

public class FacultadDao extends Conexion<Facultad> implements GenericDao<Facultad> {
public FacultadDao() {
	super(Facultad.class);
}
}
