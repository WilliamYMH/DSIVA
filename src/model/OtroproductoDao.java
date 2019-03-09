package model;

import negocio.Otroproducto;
import util.Conexion;

public class OtroproductoDao extends Conexion<Otroproducto> implements GenericDao<Otroproducto> {
public OtroproductoDao() {
	super(Otroproducto.class);
}
}
