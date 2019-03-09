package model;

import negocio.Direccionpro;
import util.Conexion;

public class DireccionproDao extends Conexion<Direccionpro> implements GenericDao<Direccionpro> {
public DireccionproDao() {
	super(Direccionpro.class);
}
}
