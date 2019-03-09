package model;

import negocio.Cargo;
import util.Conexion;

public class CargoDao extends Conexion<Cargo> implements GenericDao<Cargo> {

	public CargoDao(){
		super(Cargo.class);
	}
	
}
