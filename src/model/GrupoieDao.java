package model;

import negocio.Grupoie;
import util.Conexion;

public class GrupoieDao extends Conexion<Grupoie> implements GenericDao<Grupoie> {
public GrupoieDao() {
	super(Grupoie.class);
}
}
