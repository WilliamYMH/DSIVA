package model;

import negocio.Proyecto;
import util.Conexion;

public class ProyectoDao extends Conexion<Proyecto> implements GenericDao<Proyecto> {
public ProyectoDao() {
	super(Proyecto.class);
}
}
