package model;

import negocio.Grupodirector;
import util.Conexion;

public class GrupodirectorDao extends Conexion<Grupodirector> implements GenericDao<Grupodirector> {
public GrupodirectorDao() {
	super(Grupodirector.class);
}
}
