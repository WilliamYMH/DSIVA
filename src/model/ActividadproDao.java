package model;

import negocio.*; 
import util.Conexion;

public class ActividadproDao extends Conexion<Actividadpro> implements GenericDao<Actividadpro> {
public ActividadproDao() {
	super(Actividadpro.class);
}


}
