package model;

import negocio.Grupointegrante;
import util.Conexion;

public class GrupointegranteDao extends Conexion<Grupointegrante> implements GenericDao<Grupointegrante> {
public GrupointegranteDao() {
	super(Grupointegrante.class);
}
}
